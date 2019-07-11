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
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
        
        String nombre=null;
        String correo=null;
        String curriculum=null;
        String telefono=null;
        String mensaje=null;
        
        try {
            
            ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> multifiles  = sfu.parseRequest(request);
            Iterator<FileItem> iter = multifiles.iterator();
            
            while (iter.hasNext()) {
                
                FileItem item = iter.next();

                if (item.isFormField()) {
                    
                    String name = item.getString();
                    String parameter = item.getFieldName();
                    
                    if (parameter.equals("txtPostNombre")) {
                        nombre = name;
                    } else if (parameter.equals("txtPostCorreo")) {
                        correo = name;
                    } else if (parameter.equals("txtPostTelefono")) {
                        telefono = name;
                    } else if (parameter.equals("txtPostMensaje")) {
                        mensaje = name;
                    }
                                       
                } else {
                    
                    String ruta = "C:\\upload\\" + item.getName();
                    item.write(new File(ruta));
                    curriculum = ruta;
                }
            }     
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        }
        try {
        Postulante postulante = new Postulante(nombre, correo, curriculum,
                telefono, mensaje);
        PostulanteDAO postulanteDAO = new PostulanteDAO();
        
        if (postulanteDAO.sql_insert(postulante) == true) {
            String respuesta = ("Aplicacion realizada correctamente");
            request.getSession().setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String respuesta = ("La aplicacion no se registro correctamente, intentelo nuevamente.");
            request.getSession().setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        } catch (Exception ex) {
            System.out.println(ex);
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
