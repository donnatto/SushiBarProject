/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hamachisushi.model.Postulante;
import com.hamachisushi.daos.PostulanteDAO;
/**
 *
 * @author Alumno
 */
@WebServlet(name = "PostulanteController", urlPatterns = {"/postulantecontroller.do"})
public class PostulanteController extends HttpServlet {

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
        
        String nombre = request.getParameter("txtPostNombre");
        String correo = request.getParameter("txtPostCorreo");
        String telefono = request.getParameter("txtPostTelefono");
        String mensaje = request.getParameter("txtPostMensaje");
        
        Postulante postulante = new Postulante(nombre, correo, telefono, mensaje);
        PostulanteDAO postulanteDAO = new PostulanteDAO();
        
        if (postulanteDAO.sql_insert(postulante) == true) {
            String respuesta = ("Aplicación realizada correctamente");
            request.getSession().setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String respuesta = ("La aplicación no se registró correctamente, inténtelo nuevamente.");
            request.getSession().setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
