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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;

/**
 *
 * @author admin
 */
public class CommentDAO extends DBContext {

    public ArrayList<Comment> getComment(String pid) {
        ArrayList<Comment> arr = new ArrayList();
        try {
            String sql = "SELECT * FROM [comment] JOIN users ON comment.userid = users.id WHERE [productid] = "+pid;
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                arr.add(new Comment(rs.getInt("productid"), rs.getInt("userid"), rs.getString("content"), rs.getString("name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void createComment(int pid, int uid, String cmt) {
        try {
            String sql = "INSERT INTO [comment] ([productid], [userid], [content]) VALUES (?, ?, ?)";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            ps.setString(3, cmt);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteComment(int commentId) {
    try {
        String sql = "DELETE FROM [comment] WHERE [commentid] = ?";
        Connection con = DBContext();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, commentId);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void updateComment(int commentId, String newContent) {
    try {
        String sql = "UPDATE [comment] SET [content] = ? WHERE [commentid] = ?";
        Connection con = DBContext();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newContent);
        ps.setInt(2, commentId);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
