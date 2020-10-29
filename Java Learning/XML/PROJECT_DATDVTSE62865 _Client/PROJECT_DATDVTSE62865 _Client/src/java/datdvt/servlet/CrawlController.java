/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.servlet;

import datdvt.clients.WebsiteCategoryClient;
import datdvt.dtos.WebsiteCategoriesDTO;
import datdvt.dtos.WebsiteCategoryDTO;
import datdvt.pages.Fitin;
import datdvt.pages.NoiThatAmber;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CrawlController", urlPatterns = {"/CrawlController"})
public class CrawlController extends HttpServlet {

    private final String FITIN = "fitin";
    private final String AMBER = "amber";

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
            String website = request.getParameter("website");
            String category = request.getParameter("category");
            HttpSession session = request.getSession();
            ServletContext application = getServletContext();
            String realPath = application.getRealPath("/").replace("\\build\\web\\", "\\web\\");
            if (website != null && !website.equals("")) {
                if (category == null) {
                    if (website.equals("fitin")) {
                        Fitin fitin = new Fitin(realPath);
                        fitin.getCateogryOfFitin();
                    } else {
                        NoiThatAmber amber = new NoiThatAmber(realPath);
                        amber.getCateogryOfAmber();
                    }
                }
                WebsiteCategoryClient client = new WebsiteCategoryClient();
                List<WebsiteCategoryDTO> list = ((WebsiteCategoriesDTO) client.getWebsiteCategoryByWebsite_XML(WebsiteCategoriesDTO.class, website)).getList();
                request.setAttribute("CATEGORY", list);
                session.setAttribute("WEBSITE", website);
            }
            if (category != null) {
                if (website.equals("fitin")) {
                    System.out.println("hello fitin");
                    Fitin fitin = new Fitin(realPath);
                    fitin.getProductsOfFitin(category);
                    request.setAttribute("MESSAGE", fitin.getMessage());
                } else if (website.equals("amber")) {
                    System.out.println("hello amber");
                    System.out.println(category);
                    NoiThatAmber amber = new NoiThatAmber(realPath);
                    amber.getProductsOfAmber(category);
                    request.setAttribute("MESSAGE", amber.getMessage());
                }
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher("crawlpage.jsp").forward(request, response);
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
