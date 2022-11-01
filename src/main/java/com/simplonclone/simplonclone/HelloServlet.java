package com.simplonclone.simplonclone;

import java.io.*;
import java.util.List;

import com.simplonclone.simplonclone.entity.Apprenant;
import com.simplonclone.simplonclone.services.ApprenantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.rowset.serial.SerialException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApprenantService apprenantService = new ApprenantService();
        List<Apprenant> list = apprenantService.getAll(10);
        request.setAttribute("apprenants",list);
        request.getRequestDispatcher("apprenants.jsp").forward(request,response);
    }

    public void destroy() {
    }
}