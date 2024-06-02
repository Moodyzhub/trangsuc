/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddCateServlet", urlPatterns = {"/add-cate"})
public class AddCateServlet extends HttpServlet {

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
            out.println("<title>Servlet AddCateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCateServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("cid");
        String name = request.getParameter("cname");
        CategoryDAO cdao = new CategoryDAO();
        int cid;
        try {
            cid = Integer.parseInt(id_raw);

            Category cname = cdao.checkNameCate(name);
            if (cname != null) {
                request.setAttribute("error1", name + " đã tồn tại");
                request.getRequestDispatcher("addCate.jsp").forward(request, response);
                return;
            }

            Category c = cdao.getCategoryById(cid);
            if (c != null) {
                request.setAttribute("error", cid + " đã tồn tại");
                request.getRequestDispatcher("addCate.jsp").forward(request, response);
            } else {
                Category cnew = new Category(cid, name);
                cdao.insert(cnew);
                request.getRequestDispatcher("list-cate").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "ID phải là một số nguyên.");
            request.getRequestDispatcher("addCate.jsp").forward(request, response);
        }
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
