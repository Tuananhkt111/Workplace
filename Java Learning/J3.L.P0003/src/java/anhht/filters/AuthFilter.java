/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuana
 */
public class AuthFilter implements Filter {

    private static final String LOGIN = "LoginPageAction";
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    private final ArrayList<String> guest;
    private final ArrayList<String> admin;
    private final ArrayList<String> user;

    public AuthFilter() {
        guest = new ArrayList<>();
        guest.add("LoginPageAction");
        guest.add("");
        guest.add("SearchAction");
        guest.add("SearchAction.action");
        guest.add("LoginAction");
        guest.add("LoginAction.action");
        guest.add("InsertUserPageAction");
        guest.add("InsertUserAction");
        guest.add("SearchRoomAction");
        guest.add("SearchRoomAction.action");
        admin = new ArrayList<>();
        admin.add("");
        admin.add("LogoutAction");
        admin.add("SearchAction");
        admin.add("SearchAction.action");
        admin.add("SearchRoomAction");
        admin.add("SearchRoomAction.action");
        admin.add("LoginPageAction");
        admin.add("InsertUserPageAction");
        admin.add("InsertAction");
        user = new ArrayList<>();
        user.add("");
        user.add("cart.jsp");
        user.add("AddToCartAction");
        user.add("CheckoutAction");
        user.add("DeleteCartAction");
        user.add("UpdateCartAction");
        user.add("BookingHistoryAction");
        user.add("BookingHistoryAction.action");
        user.add("DiscountAction");
        user.add("LogoutAction");
        user.add("SearchAction");
        user.add("SearchAction.action");
        user.add("SearchRoomAction");
        user.add("SearchRoomAction.action");
        user.add("CartPageAction");
        user.add("DeleteTranAction");
        user.add("LoginPageAction");
        user.add("CreatePaymentAction");
        user.add("CreatePaymentAction.action");
        user.add("ExecutePaymentAction");
        user.add("ExecutePaymentAction.action");
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String url = "";
        try {
            HttpSession session = req.getSession(false);
            int lastIndex = uri.lastIndexOf("/");
            String resource = uri.substring(lastIndex + 1);
            if (resource.lastIndexOf(".jsp") > 0 || !(resource.lastIndexOf(".css") > 0 || resource.lastIndexOf(".js") > 0 || resource.lastIndexOf(".jpg") > 0 || resource.lastIndexOf(".png") > 0 || resource.lastIndexOf(".jpeg") > 0)) {
                if (session == null || session.getAttribute("USER") == null) {
                    if (!guest.contains(resource)) {
                        url = LOGIN;
                    }
                } else {
                    String role = (String) session.getAttribute("ROLE");
                    if (role.equals("admin")) {
                        if (!admin.contains(resource)) {
                            url = LOGIN;
                        }
                    } else if (role.equals("user")) {
                        if (!user.contains(resource)) {
                            url = LOGIN;
                        }
                    } else {
                        url = LOGIN;
                    }
                }
            }
            if (url.equals("")) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(LOGIN);
            }
        } catch (IOException | ServletException e) {

        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AuthFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
