/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Cart;
import model.Order;
import model.User;


@WebServlet(name="CheckOutServlet", urlPatterns={"/cart-check-out"})
public class CheckOutServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             Date date = new Date();
             // retrive all cart product
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            // user authentication
             User auth = (User) request.getSession().getAttribute("auth");
             
             // check auth and cart list
             if( cart_list != null && auth !=null){
                 // prepare the order object
                    for (Cart c : cart_list) {
                          Order order = new Order();
                          order.setId(c.getId());
                          order.setUid(auth.getId());
                          order.setQuantity(c.getQuantity());
                          order.setDate(formatter.format(date));
                          // instantiate the dao class
                          OrderDAO orderDAO = new OrderDAO();
                          // calling  the insert method
                        boolean result =  orderDAO.insertOrder(order);
                        if(!result) break;
                 }
                    cart_list.clear();
                    response.sendRedirect("thanks.jsp");
  
                 
                 
             }else{
                 if(auth == null){
                     response.sendRedirect("user-login");
                     }
                  response.sendRedirect("cart.jsp");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
