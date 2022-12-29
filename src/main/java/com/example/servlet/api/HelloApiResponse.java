package com.example.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "helloApiResponse", urlPatterns = "/hello-api-response")
public class HelloApiResponse extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        Hello hello = new Hello();
        hello.setName("kim");
        hello.setAge(30);
        String result = objectMapper.writeValueAsString(hello);
        resp.getWriter().write(result);
    }
}