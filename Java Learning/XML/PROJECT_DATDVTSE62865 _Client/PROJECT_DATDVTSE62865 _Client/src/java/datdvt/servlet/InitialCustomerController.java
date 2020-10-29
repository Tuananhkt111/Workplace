/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.servlet;

import datdvt.clients.ColorClient;
import datdvt.clients.ImageClient;
import datdvt.dtos.ColorDTO;
import datdvt.dtos.ColorsDTO;
import datdvt.dtos.ImageDTO;
import datdvt.dtos.ImagesDTO;
import datdvt.jaxb.JAXBMarshalling;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "InitialCustomerController", urlPatterns = {"/InitialCustomerController"})
public class InitialCustomerController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            ImageClient iclient = new ImageClient();
            List<ImageDTO> imgList = ((ImagesDTO) iclient.findAll_XML(ImagesDTO.class)).getList();
            List<ColorDTO> colorList = new ArrayList<>();
            for (int i = 0; i < imgList.size(); i++) {
                if (imgList.get(i).getProduct().getWebsiteCategory().getCategory().getLevelAuth() == 1) {
                    if (colorList.size() != 0) {
                        boolean flag = false;
                        for (int j = 0; j < colorList.size(); j++) {
                            if (colorList.get(j).getId() == imgList.get(i).getColor().getId()) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            colorList.add(imgList.get(i).getColor());
                        }
                    } else {
                        colorList.add(imgList.get(i).getColor());
                    }
                }
            }
            ServletContext application = getServletContext();
            String realPath = application.getRealPath("/").replace("\\build\\web\\", "\\web\\WEB-INF\\");
            String colorPath = realPath+"colorchoose.xml"; 

            ColorsDTO colorsDTO = new ColorsDTO();
            colorsDTO.setList(colorList);
            JAXBMarshalling.marshallColorObject(colorsDTO, colorPath);
            session.setAttribute("COLORPICK", "");
            session.setAttribute("RESULTLIST", "");
            session.setAttribute("OTHERRESULTLIST", "");
            session.setAttribute("WIDTH", "");
            session.setAttribute("DEPTH", "");
            session.setAttribute("PRICE", "");
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
