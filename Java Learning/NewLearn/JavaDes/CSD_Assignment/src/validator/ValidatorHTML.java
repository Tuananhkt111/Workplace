/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tuana
 */
public class ValidatorHTML {

    Stack<String> st = new Stack<>();

    public void validateHTML(ArrayList<String> htmlContent) {
        Pattern p = Pattern.compile("((\\<\\w+\\s*[^\\<\\>]*\\>)|(\\<\\/\\w+\\s*\\>))");
        int lineOfLastOpeningTag = 0;
        for (int i = 0; i < htmlContent.size(); i++) {
            Matcher m = p.matcher(htmlContent.get(i));
            while (m.find()) {
                String temp = m.group();
                if (temp.matches("\\<\\w+\\s*[^\\<\\>]*\\>")) {
                    st.push(temp);
                    lineOfLastOpeningTag = i;
                } else {
                    if(st.empty()) {
                        System.out.println("File HTML is invalid");
                        System.out.println("Line error: " + (i + 1));
                        System.out.println("Missing opening tag of " + temp + " in line " + (i + 1));
                    } else if (isMatchingTag(temp)) {
                        st.pop();                
                    } else {
                        System.out.println("File HTML is invalid");
                        System.out.println("Line error: " + (i + 1));
                        System.out.println("Missing closing tag of " + st.peek() + " in line " + lineOfLastOpeningTag);
                    }
                }
            }
        }
        System.out.println("File HTML is valid");
    }

    private boolean isMatchingTag(String endingTag) {
        String openingTag = st.peek();
        Pattern p1 = Pattern.compile("(?=[^\\s])(\\<\\w+)");
        Pattern p2 = Pattern.compile("(?=[^\\s])(\\<\\/\\w+)");
        Matcher m1 = p1.matcher(openingTag);
        Matcher m2 = p2.matcher(endingTag);
        String temp, result = null;
        if (m1.find()) {
            temp = m1.group();
            openingTag = temp + ">";
            openingTag = "</" + openingTag.substring(1);
        }
        if (m2.find()) {
            temp = m2.group();
            result = temp + ">";
        }
        return openingTag.equals(result);
    }
}
