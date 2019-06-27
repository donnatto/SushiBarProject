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
import com.hamachisushi.model.Reserva;
import com.hamachisushi.daos.ReservaDAO;
import javafx.scene.control.Alert;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "ReservaController", urlPatterns = {"/reservacontroller.do"})
public class ReservaController extends HttpServlet {

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
        
        String nombre = request.getParameter("txtReservaNombre");
        String apellido = request.getParameter("txtReservaApellido");
        String fecha = request.getParameter("txtReservaFecha");
        String hora = request.getParameter("txtReservaHora");
        int comensales = Integer.parseInt(request.getParameter("txtReservaCantidad"));
        String telefono = request.getParameter("txtReservaTelefono");
        String correo = request.getParameter("txtReservaCorreo");
        int estado = 0; //Antes de confirmar reserva.
        
                
        Reserva reserva = new Reserva(nombre, apellido, fecha, hora, comensales,
            telefono, correo, estado);
        
        ReservaDAO reservaDAO = new ReservaDAO();
        if(reservaDAO.sql_insert(reserva) == true){
          String respuesta = ("Reserva realizada correctamente");
          request.getSession().setAttribute("respuesta", respuesta);
          request.getRequestDispatcher("index.jsp").forward(request, response);  
        }
        else{
          String respuesta = ("La reserva no pudo ser realizada, intentelo nuevamente.");
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
