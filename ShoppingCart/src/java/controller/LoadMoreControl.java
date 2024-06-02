/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoadMoreControl", urlPatterns = {"/load"})
public class LoadMoreControl extends HttpServlet {

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
        String amount = request.getParameter("exits");
        int lmao = Integer.parseInt(amount);
        PrintWriter out = response.getWriter();
        ProductDAO pdao = new ProductDAO();
        List<Product> productList = pdao.getNextProduct(lmao);
        for (Product o : productList) {
            out.println("    <div class=\"products col-12 col-md-6 col-lg-4 mt-3\">\n"
                    + "        <div class=\"card w-100 p-2\" style=\"border-radius: 15px; overflow: hidden; margin-bottom: 20px; overflow: hidden;\">\n"
                    + "            <img class=\"card-img-top mb-3 img-fluid\" src=\"product-image/" + o.getImage() + "\" alt=\"Card image cap\">\n"
                    + "            <h6 style=\"text-align: center; color: #f64876; font-size: 14px;\" class=\"price\">" + o.getGia() + "</h6>\n"
                    + "            <div class=\"border-bottom mt-3\" style=\"position: relative;\">\n"
                    + "                <a href=\"add-to-cart?id=" + o.getId() + "\" class=\"text-success\">\n"
                    + "                    <i class='bx bx-cart-alt border text-center bg-white fs-2'\n"
                    + "                       style=\"width: 30px; line-height: 30px;\n"
                    + "                       height: 30px; border-radius: 50%; position: absolute; left: 50%;\n"
                    + "                       top: 0; transform: translate(-50%, -50%);\"></i>\n"
                    + "                </a>\n"
                    + "            </div>\n"
                    + "            <div class=\"text-center mt-4\">\n"
                    + "                <h4 style=\"font-size: 16px\" class=\"card-title show_txt\">\n"
                    + "                    <a href=\"detail?pid=" + o.getId() + "\" style=\"color: #333;\" title=\"View Product\" style=\"color: #39434d; text-decoration: none !important;\">" + o.getName() + "</a></h4>\n"
                    + "                <div class=\"row align-items-center\">\n"
                    + "                    <div class=\"col-5\">\n"
                    + "                        <h6 class=\"fw-bold\" style=\"color: #537da7;\">" + o.getPrice() + "$</h6>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"col-7\">\n"
                    + "                        <div class=\"d-flex align-items-center\">\n"
                    + "                            <a class=\"px-3 py-2\" style=\"border: 1px solid #00a832; text-decoration: none;color: #00a832; border-radius: 5px;\"\n"
                    + "                               href=\"order-now?quantity=1&id=" + o.getId() + "\">Buy Now <i class='bx bxs-hot'></i></a>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </div>");

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
