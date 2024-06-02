/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static dal.DBContext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Order;
import model.Orders;
import model.Product;

/**
 *
 * @author admin
 */
public class OrderDAO extends DBContext {

    public boolean insertOrder(Order model) {
        boolean result = false;
        try {

            String sql = "insert into orders (p_id, u_id, o_quantity, o_date) values(?,?,?,?)";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, model.getId());
            ps.setInt(2, model.getUid());
            ps.setInt(3, model.getQuantity());
            ps.setString(4, model.getDate());
            ps.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {

            String sql = " select * from orders o\n"
                    + "  join products p\n"
                    + "  on p.id = o.p_id\n"
                    + "  join category c\n"
                    + "  on c.cid = p.id\n"
                    + "  where u_id= ? order by o.o_id desc";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDAO productDAO = new ProductDAO();
                int pId = rs.getInt("p_id");
                Product product = productDAO.getSingleProduct(pId);
                order.setOrderId(rs.getInt("o_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setImage(product.getImage());
                order.setGia(product.getGia());
                order.setPrice(product.getPrice() * rs.getInt("o_quantity"));
                order.setQuantity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"));
                order.setCate(c);
                list.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void cancelOrder(int id) {
        try {

            String sql = "delete from orders where o_id=?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getTotalMoneyByYear(int year) {
        double totalMoney = 0.0;
        try {
            String sql = "SELECT SUM(totalprice) AS totalprice FROM Orders_Detail WHERE YEAR(order_date) = ?";
            Connection con = DBContext(); // Assuming this method returns a Connection
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, year);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalMoney = rs.getDouble("totalprice"); // Set totalMoney to the retrieved totalprice
            }
            return  totalMoney;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        OrderDAO pdao = new OrderDAO();
        double totalMoney = pdao.getTotalMoneyByYear(2021);
        System.out.println("Total money for year 2018: " + totalMoney);
    }
}
