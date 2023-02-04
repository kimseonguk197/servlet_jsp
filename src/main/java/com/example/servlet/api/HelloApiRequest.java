package com.example.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


// post요청을 툥해 데이터를 받는 경우
@WebServlet(name = "helloApiRequest", urlPatterns = "/hello-api-request")
public class HelloApiRequest extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        Hello hello = objectMapper.readValue(messageBody, Hello.class);
        System.out.println(hello.getName());
        System.out.println(hello.getAge());
        resp.getWriter().write("ok");
    }
}