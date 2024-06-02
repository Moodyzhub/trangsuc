/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author admin
 */
public class UserDAO extends DBContext {

    public User userLogin(String email, String password) {
        User user = null;
        try {
            String sql = "Select * from users where email= ? and password= ?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User checkAccountExist(String email) {
        User user = null;
        try {
            String sql = "select * from users where email = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void signup(String name, String email, String pass, String country, String contact) {
        try {
            String sql = "INSERT INTO users (name, email, password, country, contact, isSeller, isAdmin) VALUES (?, ?, ?, ?, ?, 0, 0)";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name); // thay đổi ở đây
            ps.setString(2, email); // thay đổi ở đây
            ps.setString(3, pass); // thay đổi ở đây
            ps.setString(4, country);
            ps.setString(5, contact);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean checkLogin(String Password, String CPassword, String Email) {
        if (Password.equals(CPassword) && Password != null && CPassword != null && Email != null) {
            String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,15}$";
            if (!Password.matches(regex)) {
                return false;
            }
            try {
                String sql = "update users set password = ? where email = ? ";
                Connection con = DBContext();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, Password);
                ps.setString(2, Email);
                int check = ps.executeUpdate();
                return check > 0;

            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    public boolean checkEmail(String email) {
        boolean checkRegister = false;
        try {
            String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    checkRegister = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkRegister;
    }

    // Create
    public void add(String name, String email, String pass, String country, String contact) {
        try {
            String sql = "INSERT INTO users (name, email, password, country, contact, isSeller, isAdmin) VALUES (?, ?, ?, ?, ?, 0, 0)";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name); // thay đổi ở đây
            ps.setString(2, email); // thay đổi ở đây
            ps.setString(3, pass); // thay đổi ở đây
            ps.setString(4, country);
            ps.setString(5, contact);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // Read seller and customer

    public List<User> get() {
        try {
            String sql = "select * from users where isSeller IN(0,1) \n"
                    + "  or isAdmin=1";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // Search

    public List<User> searchByName(String name) {
        List<User> list = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            return list;
        }
        try {
            String sql = "Select * from users Where name like ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<User> searchByEmail(String email) {
        List<User> list = new ArrayList<>();
        if (email == null || email.isEmpty()) {
            return list;
        }
        try {
            String sql = "SELECT * FROM users WHERE email LIKE ?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + email + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
                list.add(user);
            }
            rs.close(); // Close ResultSet
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // Admin  Update
    public void updateUser(User user) {

        try {
            String sql = "update users set name = ? , email = ? , password = ? , isSeller = ?, isAdmin = ?, country = ? , contact = ? Where id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName()); // thay đổi ở đây
            ps.setString(2, user.getEmail()); // thay đổi ở đây
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getIsSeller());
            ps.setInt(5, user.getIsAdmin());
            ps.setString(6, user.getCountry());
            ps.setString(7, user.getContact());
            ps.setInt(8, user.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
// Users update profile
    public void updateUsers(String email, String country, String contact,String name) {

        try {
            String sql = "update users set  email = ? , country = ? , contact = ? Where name = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, country);
            ps.setString(3, contact);
            ps.setString(4, name);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Delete
    public void deleteById(int id) {
        try {
            String sql = "delete from users where id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // getPerson

    public User getUserById(int id) {
        try {
            String sql = "select * from users where id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setIsSeller(rs.getInt("isSeller"));
            user.setIsAdmin(rs.getInt("isAdmin"));
            user.setCountry(rs.getString("country"));
            user.setContact(rs.getString("contact"));

            return user;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int getTotalAccount() {
        try {
            String sql = "select count(*) from users";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public List<User> PagingAccount(int index) {

        try {
            String sql = "select* from users where isSeller IN(0,1) \n"
                    + "                     AND isAdmin=0\n"
                    + "Order by id\n"
                    + "offset ? rows fetch next 4 rows only";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 4);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIsSeller(rs.getInt("isSeller"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setCountry(rs.getString("country"));
                user.setContact(rs.getString("contact"));
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        List<User> list = udao.PagingAccount(2);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
