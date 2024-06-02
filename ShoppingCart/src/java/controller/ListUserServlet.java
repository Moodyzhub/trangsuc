/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListUserServlet", urlPatterns = {"/list-user"})
public class ListUserServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        UserDAO dAO = new UserDAO();
        List<User> list = dAO.get();
        // search by name
        String searchName = request.getParameter("name");
        String searchEmail = request.getParameter("email"); 
        if (searchName != null && !searchName.isEmpty()) {
            List<User> searchList = dAO.searchByName(searchName);
            request.setAttribute("name", searchName);
            request.setAttribute("list", searchList);
        } else if (searchEmail != null && !searchEmail.isEmpty()) { 
            List<User> searchList = dAO.searchByEmail(searchEmail);
            request.setAttribute("email", searchEmail); 
            request.setAttribute("list", searchList);
        } else {
            request.setAttribute("list", list);
        }
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
        // search by name
//        String searchName = request.getParameter("name");
//        if (searchName != null) {
//            List<User> searchList = new ArrayList<>();
//            for (User user : list) {
//                if (user.getName().toLowerCase().contains(searchName.toLowerCase())) {
//                    searchList.add(user);
//                }
//            }
//            request.setAttribute("name", searchName);
//            request.setAttribute("list", searchList);
//        } else {
//            request.setAttribute("list", list);
//        }

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
