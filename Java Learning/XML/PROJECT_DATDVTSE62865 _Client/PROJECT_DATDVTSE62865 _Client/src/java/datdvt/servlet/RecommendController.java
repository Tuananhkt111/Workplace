/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.servlet;

import datdvt.clients.ColorClient;
import datdvt.dtos.ColorDTO;
import datdvt.dtos.ImageCategoryDTO;
import datdvt.imageutils.FilterImageProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RecommendController", urlPatterns = {"/RecommendController"})
public class RecommendController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] colors = request.getParameterValues("colorPicker");
        request.setAttribute("COLORPI", colors);
        String width = request.getParameter("width");
        String depth = request.getParameter("depth");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();
        session.setAttribute("WIDTH", width);
        session.setAttribute("DEPTH", depth);
        session.setAttribute("PRICE", price);
    
        session.setAttribute("COLORPICK", colors);
        try {
            if (colors != null && colors.length != 0) {             
                session.setAttribute("CUSMESSAGE", null);
                ColorClient cclient = new ColorClient();
                List<ImageCategoryDTO> result = new ArrayList<>();
                List<ImageCategoryDTO> otherResult = new ArrayList<>();


                for (int i = 0; i < colors.length; i++) {
                    ColorDTO colorDto = cclient.find_XML(ColorDTO.class, colors[i]);
                    List<ImageCategoryDTO> temp = FilterImageProduct.getImageCategoriesWithColor(1, colorDto.getR(), colorDto.getG(), colorDto.getB(), 10, 100);
                    if (i == 0) {
                        result.addAll(temp);
                    } else {
                        for (int j = 0; j < result.size(); j++) {
                            for (int k = 0; k < temp.size(); k++) {
                                if (result.get(j).getCategory().getId() == temp.get(k).getCategory().getId()) {
                                    result.get(j).getImages().addAll(temp.get(k).getImages());
                                    Collections.shuffle(result.get(j).getImages());
                                }
                            }
                        }
                    }
                    List<ImageCategoryDTO> otherTemp = FilterImageProduct.getImageCategoriesWithColor(3, colorDto.getR(), colorDto.getG(), colorDto.getB(), 10, 100);
                    if (i == 0) {
                        otherResult.addAll(otherTemp);
                    } else {
                        for (int j = 0; j < otherResult.size(); j++) {
                            for (int k = 0; k < otherTemp.size(); k++) {
                                if (otherResult.get(j).getCategory().getId() == otherTemp.get(k).getCategory().getId()) {
                                    otherResult.get(j).getImages().addAll(otherTemp.get(k).getImages());
                                }
                            }
                        }
                    }

                }
                session.setAttribute("RESULTLIST", result);
                session.setAttribute("OTHERRESULTLIST", otherResult);
                session.setAttribute("TOTALPRICE", FilterImageProduct.getPriceOfProduct(result));
                session.setAttribute("TOTALAREA", FilterImageProduct.getAreaOfProduct(result));
                if (!price.equals("") || !width.equals("") || !depth.equals("")) {
                    if (price.equals("")) price ="0";
                    if (width.equals("")) width ="0";
                    if (depth.equals("")) depth ="0";
                    List<ImageCategoryDTO> templist = FilterImageProduct.getListWithBoth(result, Integer.parseInt(price), Float.parseFloat(width), Float.parseFloat(depth));
                    if (templist != null) {
                        session.setAttribute("RESULTLIST", templist);
                        session.setAttribute("TOTALPRICE", FilterImageProduct.getPriceOfProduct(templist));
                        session.setAttribute("TOTALAREA", FilterImageProduct.getAreaOfProduct(templist));
                    } else {
                        session.setAttribute("RESULTLIST", templist);
                        session.setAttribute("TOTALPRICE", 0);
                        session.setAttribute("TOTALAREA", 0);
                    }
                }
            } else {
                session.setAttribute("CUSMESSAGE", "Vui lòng chọn màu sắc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("customer.jsp").forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
