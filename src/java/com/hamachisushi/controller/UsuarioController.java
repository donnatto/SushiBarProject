/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.controller;

import com.hamachisushi.daos.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hamachisushi.model.Usuario;
import com.hamachisushi.daos.UsuarioDAO;
import com.hamachisushi.model.Empleado;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuariocontroller.do"})
public class UsuarioController extends HttpServlet {

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

    String accion = request.getParameter("accion");
    HttpSession sessionOK = request.getSession();

    if (accion.equals("login")) {
      String correo = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      Usuario usuario = new Usuario(correo, clave);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      Usuario usuarioR = usuarioDAO.login(usuario);
      if (usuarioR != null) {
        sessionOK.setAttribute("nombre", usuarioR.getNombre());
        sessionOK.setAttribute("apellido", usuarioR.getApellido());
        sessionOK.setAttribute("correo", usuarioR.getCorreo());
        sessionOK.setAttribute("area", usuarioR.getArea());
        request.getRequestDispatcher("system.jsp").forward(request, response);
      } else {
        String respuesta = ("Usuario o clave incorrecta");
        request.getSession().setAttribute("respuesta", respuesta);
        request.getRequestDispatcher("error.jsp").forward(request, response);
      }

    } else if (accion.equals("registrar")) {

      String nombre = request.getParameter("txtUsuarioNombre");
      String apellido = request.getParameter("txtUsuarioApellido");
      String correo = request.getParameter("txtUsuarioCorreo");
      String area = request.getParameter("cargo");
      String clave = request.getParameter("txtUsuarioClave");
      String codigo = request.getParameter("codigoTrabajador");

      Empleado empleado = new Empleado(codigo, nombre, apellido);
      EmpleadoDAO empleadoDAO = new EmpleadoDAO();
      Usuario usuario = new Usuario(nombre, apellido, correo, area, clave);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      
      //primero valida si código de trabajador coincide con el de la BD
      if (empleadoDAO.validar(empleado) == true) {
        //registra nuevo Usuario
        if (usuarioDAO.register(usuario) == true) {
          String respuesta = ("Usuario registrado correctamente");
          request.getSession().setAttribute("respuesta", respuesta);
          request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
          String respuesta = ("El usuario no se registro, intentelo nuevamente");
          request.getSession().setAttribute("respuesta", respuesta);
          request.getRequestDispatcher("error.jsp").forward(request, response);
        }

      } else {
        String respuesta = ("El empleado no existe, o el codigo ingresado es incorrecto");
        request.getSession().setAttribute("respuesta", respuesta);
        request.getRequestDispatcher("error.jsp").forward(request, response);
      }

    } else if (accion.equals("cerrar")) {

      sessionOK.removeAttribute("nombre");
      sessionOK.removeAttribute("apellido");
      sessionOK.removeAttribute("correo");
      sessionOK.removeAttribute("area");
      sessionOK.invalidate();
      request.getRequestDispatcher("index.jsp").forward(request, response);
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
