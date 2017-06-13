package com.gmail.s12348.evgen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InquirerServlet extends HttpServlet{
    private static Map<String,Integer> question =new HashMap<>();
    static {
        String [] s={"Red", "Orange", "Yellow", "Pascal", "Java", "Python"};
        for (String string:s) question.put(string, 0);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        putMap(request.getParameter("question_1"));
        putMap(request.getParameter("question_2"));
        response.getWriter().println(htmlAnswer());

    }
    private void putMap (String s){
        if (question.containsKey(s)) {
            question.put(s, question.get(s) + 1);
        } else {
            question.put(s, 1);
        }
    }

    private String htmlAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head>");
        sb.append("<meta charset='UTF-8'><title>Poll result</title><body><center>");
        sb.append("<table border=1><tr><th>Question</th><th>Answer</th></tr>");
        for(Map.Entry<String,Integer> set : question.entrySet()) {
            sb.append("<tr><td>");
            sb.append(set.getKey());
            sb.append("</td><td>");
            sb.append(set.getValue());
            sb.append("</td></tr>");
        }
        sb.append("</table>");
        sb.append("</body></html>");
        return sb.toString();
    }



}
