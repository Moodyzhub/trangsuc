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
import model.Product;

public class CategoryDAO extends DBContext {

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "Select * from category";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void deleteCate(int cid) {
        try {
            String sql = "delete from category where cid = ?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Category getCategoryById(int cid) {
        String sql = "SELECT * FROM dbo.Category WHERE cid = ?";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {

        }
        return null;
    }
        public Category checkNameCate(String name) {
        String sql = "SELECT * FROM dbo.Category WHERE cname = ?";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO Category VALUES(?, ?)";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCid());
            ps.setString(2, c.getCname());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void update(Category c) {
        String sql = "UPDATE Category SET cname = ?  WHERE cid = ?";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCname());
            ps.setInt(2, c.getCid());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }
//       public static void main(String[] args) {
//         CategoryDAO dAO = new CategoryDAO();
//         List<Category> listC = dAO.getAllCategory();
//           for (Category category : listC) {
//                System.out.println(category);
//           }
//    }
}
