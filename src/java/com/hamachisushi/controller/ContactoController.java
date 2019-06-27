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
import com.hamachisushi.model.Contacto;
import com.hamachisushi.daos.ContactoDAO;
/**
 *
 * @author migue
 */
@WebServlet(name = "ContactoController", urlPatterns = {"/contactocontroller.do"})
public class ContactoController extends HttpServlet {

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
        
        String nombre = request.getParameter("txtContactoNombre");
        String correo = request.getParameter("txtContactoCorreo");
        String asunto = request.getParameter("txtContactoAsunto");
        String mensaje = request.getParameter("txtContactoMensaje");
        
        Contacto contacto = new Contacto(nombre, correo, asunto, mensaje);
        ContactoDAO contactoDAO = new ContactoDAO();
        
        if (contactoDAO.sql_insert(contacto) == true) {
            String respuesta = ("Mensaje enviado correctamente");
            request.getSession().setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String respuesta = ("El mensaje no se envio correctamente, intentelo nuevamente.");
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
