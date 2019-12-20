/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.utils;

import javax.servlet.http.Part;

/**
 *
 * @author tuana
 */
public class MyUtils {

    public static String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp.contains("file")) {
            String[] items = contentDisp.split(";");
            for (String s : items) {
                if (s.trim().startsWith("filename")) {
                    // C:\file1.zip
                    // C:\Note\file2.zip
                    String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                    clientFileName = clientFileName.replace("\\", "/");
                    int i = clientFileName.lastIndexOf('/');
                    // file1.zip
                    // file2.zip
                    return clientFileName.substring(i + 1);
                }
            }
        }
        return null;
    }
}
