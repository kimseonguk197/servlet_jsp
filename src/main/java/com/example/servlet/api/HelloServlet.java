package com.example.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//json이 아닌 text형태로 return을 주는 형태
@WebServlet(name = "helloServlet", urlPatterns = "/hello-api-servlet")
public class HelloServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Hello hello = new Hello();
        hello.setName("kim");
        hello.setAge(30);
        String result = objectMapper.writeValueAsString(hello);
        resp.getWriter().write(result);
    }
}
