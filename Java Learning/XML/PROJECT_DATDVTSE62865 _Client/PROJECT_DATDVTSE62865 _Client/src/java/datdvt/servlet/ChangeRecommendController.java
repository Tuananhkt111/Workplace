/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.servlet;

import datdvt.dtos.ImageCategoryDTO;
import datdvt.imageutils.FilterImageProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ChangeRecommendController", urlPatterns = {"/ChangeRecommendController"})
public class ChangeRecommendController extends HttpServlet {

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
        String categoryId = request.getParameter("categoryChange");
        HttpSession session = request.getSession();
        String widthString = (String) session.getAttribute("WIDTH");
        String depthString = (String) session.getAttribute("DEPTH");
        String priceString = (String) session.getAttribute("PRICE");
        int price = 0;
        float width = 0, depth = 0;
        boolean hasPrice = true, hasArea = true;
        if (priceString.equals("") || priceString == null) {
            hasPrice = false;
        } else {
            price = Integer.parseInt(priceString);
        }
        if ((widthString.equals("") || widthString == null) && (depthString.equals("") || depthString == null)) {
            hasArea = false;
        } else {
            if (Float.parseFloat(widthString) < Float.parseFloat(depthString)) {
                String temp = widthString;
                widthString = depthString;
                depthString = temp;
            }
            width = Integer.parseInt(widthString);
            depth = Integer.parseInt(depthString);
        }
        try {
            if (categoryId.equals("categoryOther")) {
                List<ImageCategoryDTO> result = (List<ImageCategoryDTO>) session.getAttribute("OTHERRESULTLIST");
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getPosition() == result.get(i).getImages().size() - 1) {
                        result.get(i).setPosition(0);
                    } else {
                        result.get(i).setPosition(result.get(i).getPosition() + 1);
                    }
                }
                session.setAttribute("OTHERRESULTLIST", result);

            } else {
                System.out.println("letss");
                List<ImageCategoryDTO> result = (List<ImageCategoryDTO>) session.getAttribute("RESULTLIST");
                System.out.println(priceString + "X");
                System.out.println(widthString + "X");
                System.out.println(depthString + "X");
                if (!hasPrice && !hasArea) {
                    for (int i = 0; i < result.size(); i++) {
                        if (result.get(i).getCategory().getId() == Integer.parseInt(categoryId)) {
                            if (result.get(i).getPosition() == result.get(i).getImages().size() - 1) {
                                result.get(i).setPosition(0);
                            } else {
                                result.get(i).setPosition(result.get(i).getPosition() + 1);
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < result.size(); i++) {
                        if (result.get(i).getCategory().getId() == Integer.parseInt(categoryId)) {
                            if (result.get(i).getPosition() == result.get(i).getImages().size() - 1) {
                                result.get(i).setPosition(0);
                            } else {
                                result.get(i).setPosition(result.get(i).getPosition());
                            }
                            int pos = result.get(i).getPosition();
                            boolean flag = false;
                            for (int j = pos + 1; j < result.get(i).getImages().size(); j++) {
                                result.get(i).setPosition(j);
                                if (hasPrice && hasArea) {
                                    if (FilterImageProduct.getPriceOfProduct(result) <= price && FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
                                        flag = true;
                                        break;
                                    }
                                } else if (hasPrice) {
                                    if (hasPrice && FilterImageProduct.getPriceOfProduct(result) <= price) {
                                        flag = true;
                                        break;
                                    }
                                } else if (hasArea) {
                                    if (FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
                                        flag = true;
                                        break;
                                    }
                                }
//                                if (hasPrice && hasArea && FilterImageProduct.getPriceOfProduct(result) <= price && FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
//                                    flag = true;
//                                    break;
//                                } else if (hasPrice && FilterImageProduct.getPriceOfProduct(result) <= price) {
//                                    flag = true;
//                                    break;
//                                } else if (hasArea && FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
//                                    flag = true;
//                                    break;
//                                }
                            }

                            if (!flag) {
                                for (int j = 0; j < pos; j++) {
                                    result.get(i).setPosition(j);
                                    if (hasPrice && hasArea) {
                                        if (FilterImageProduct.getPriceOfProduct(result) <= price && FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
                                            break;
                                        }
                                    } else if (hasPrice) {
                                        if (hasPrice && FilterImageProduct.getPriceOfProduct(result) <= price) {
                                            break;
                                        }
                                    } else if (hasArea) {
                                        if (FilterImageProduct.getAreaOfProduct(result) <= (width * depth) && FilterImageProduct.checkAppropriate(result, width, depth)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                session.setAttribute("RESULTLIST", result);
                session.setAttribute("TOTALPRICE", FilterImageProduct.getPriceOfProduct(result));
                session.setAttribute("TOTALAREA", FilterImageProduct.getAreaOfProduct(result));
            }
        } catch (Exception e) {
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
