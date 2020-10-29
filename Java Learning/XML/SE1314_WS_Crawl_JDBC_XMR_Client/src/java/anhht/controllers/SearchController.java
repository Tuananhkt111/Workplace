/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author tuana
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String BASE_URI = "http://localhost:8084/SE1314_WS_Crawl_JDBC_XMR/webresources";
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
            String search = request.getParameter("txtSearch");
            Client client = ClientBuilder.newClient();
            Response serviceResponse = client.target(BASE_URI)
                    .path("generic/findByLikeTitle").queryParam("title", search)
                    .request(MediaType.APPLICATION_XML_TYPE)
                    .get(Response.class);
            //JSTL
//            List<NewDTO> list = serviceResponse.readEntity(new GenericType<List<NewDTO>>() {});
//            if(serviceResponse.getStatus() == 200) {
//                request.setAttribute("INFO", list);
//                request.getRequestDispatcher("view.jsp").forward(request, response);
//            }
            //live search
            String str = serviceResponse.readEntity(String.class);
//            out.write(str);
            String path = getServletContext().getRealPath("/");
            String xslPath = path + "/WEB-INF/itemsFO.xsl";
            String foPath = path + "/WEB-INF/itemsFO.fo";
            methodTrAX(xslPath, str, foPath, path);
            ByteArrayOutputStream outPDF = new ByteArrayOutputStream();
            response.setContentType("application/pdf");
            FopFactory ff = FoPFactory.newInstance();
            FOUserAgent fua = ff.newFOUserAgent();
            Fop fop = ff.newFop(MimeConstants.MIME_PDF, fua, outPDF);
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer trans = tff.newTransformer();
            File fo = new File(foPath);
            Source src = new StreamSource(fo);
            Result result = new SAXResult(fop.getDefaultHandler());
            byte[] content = outPDF.toByteArray();
            response.setContentLength(content.length);
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void methodTrAX(String xslPath, String xmlString, String output, String path) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource xslFile = new StreamSource(xslPath);
            Transformer trans = tf.newTransformer(xslFile);
            trans.setParameter("pathFile", path);
            InputStream is = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));
            StreamSource xmlFile = new StreamSource();
            StreamResult htmlFile = new StreamResult(new FileOutputStream(output));
            trans.transform(xmlFile, htmlFile);
        } catch (Exception e) {
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
