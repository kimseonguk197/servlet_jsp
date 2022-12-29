package com.example.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "helloJsp", urlPatterns = "/hello-jsp")
public class HelloJsp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Hello hello = new Hello();
        hello.setName("kim");
        hello.setAge(30);

        req.setAttribute("hello", hello);
//        /webapp/WEB-INF 폴더에서 jsp를 찾는걸로 약속이 돼 있어서, 반드시 해당 폴더 아래에 넣어야함
        String path = "/WEB-INF/views/hello_mvc.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }
}
