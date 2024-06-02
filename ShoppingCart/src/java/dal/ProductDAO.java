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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Category;
import model.Product;
import model.User;

public class ProductDAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "Select * from products";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> products = new ArrayList<>();
        String sql = "Select * from products Where name like ? ";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Product> getProductByCID(String cid) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "Select * from products\n"
                    + "where category_id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Vector<Product> getProductByCid(int[] cateId) {
        StringBuilder sql = new StringBuilder("SELECT * FROM products P WHERE 1=1");
        Vector<Product> list = new Vector<>();
        if (cateId != null && cateId.length > 0) {
            sql.append(" AND P.category_id IN (");
            for (int i = 0; i < cateId.length; i++) {
                if (i > 0) {
                    sql.append(", ");
                }
                sql.append("?");
            }
            sql.append(")");
        }

        try (Connection con = DBContext(); PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int parameterIndex = 1;
            if (cateId != null && cateId.length > 0) {
                for (int categoryId : cateId) {
                    ps.setInt(parameterIndex++, categoryId);
                }
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setGia(rs.getString("gia"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setImage(rs.getString("image"));
                    product.setTitle(rs.getString("title"));
                    product.setDescribes(rs.getString("describes"));
                    product.setImage1(rs.getString("image1"));
                    product.setImage2(rs.getString("image2"));
                    list.add(product);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getProductByID(String id) {
        try {
            String sql = "Select * from products\n"
                    + "where id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Product newProduct() {
        try {
            String sql = "SELECT  top 1 *\n"
                    + "FROM products order by id desc";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setGia(rs.getString("gia"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getString("image"));
            product.setTitle(rs.getString("title"));
            product.setDescribes(rs.getString("describes"));
            product.setImage1(rs.getString("image1"));
            product.setImage2(rs.getString("image2"));
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Product maxProduct() {
        try {
            String sql = "SELECT *\n"
                    + "FROM products\n"
                    + "WHERE price = (SELECT MAX(price) FROM products)";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setGia(rs.getString("gia"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getString("image"));
            product.setTitle(rs.getString("title"));
            product.setDescribes(rs.getString("describes"));
            product.setImage1(rs.getString("image1"));
            product.setImage2(rs.getString("image2"));
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<Cart>();
        Connection con = DBContext();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String sql = " select p.id,p.gia,p.name,p.price,p.image,p.title,p.describes,p.image1,\n"
                            + "  p.image2,c.cid,c.cname from  products p \n"
                            + "  inner join category c\n"
                            + "   on p.category_id = c.cid\n"
                            + "  where id = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, item.getId());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setImage(rs.getString("image"));
                        row.setGia(rs.getString("gia"));
                        row.setPrice(rs.getDouble("price") * item.getQuantity());
                        Category c = new Category(rs.getInt("cid"), rs.getString("cname"));
                        row.setCate(c);
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return products;

    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        Connection con = DBContext();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String sql = "select * from products where id = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, item.getId());
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return sum;

    }

    public List<Product> getAllProductsByPrice(String sortBy) {
        List<Product> products = new ArrayList<>();
        String orderBy = "";

        // Kiểm tra và xây dựng phần ORDER BY của truy vấn
        if ("LowToHigh".equals(sortBy)) {
            orderBy = "ASC";
        } else if ("HighToLow".equals(sortBy)) {
            orderBy = "DESC";
        } else {
            orderBy = "";
        }

        String sql = "SELECT * FROM products ORDER BY price " + orderBy;

        try (Connection con = DBContext(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public Product getSingleProduct(int id) {
        Product row = null;
        try {
            Connection con = DBContext();
            String sql = "select * from products where id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setGia(rs.getString("gia"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
                row.setTitle(rs.getString("title"));
                row.setDescribes(rs.getString("describes"));
                row.setImage1(rs.getString("image1"));
                row.setImage2(rs.getString("image2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;

    }

    public List<Product> getProductBySellID(int id) {

        try {
            String sql = "select p.id,p.gia,p.name,p.price,p.image,p.title,p.describes,p.image1,\n"
                    + "  p.image2,c.cid,c.cname from  products p \n"
                    + "  inner join category c\n"
                    + "   on p.category_id = c.cid\n"
                    + "  where sell_id = ?";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                Category c = new Category(rs.getInt("cid"), rs.getString("cname"));
                product.setCate(c);
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void deleteProductById(String pid) {
        String sql = "delete from products where id = ?";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertProduct(String name, String category, int sid,
            String price, String image, String gia, String title, String describes, String image1, String image2) {
        String sql = "INSERT INTO products ( name, category_id,sell_id, price, image,gia,title,describes,image1,image2)\n"
                + "VALUES (?, ?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setInt(3, sid);
            ps.setString(4, price);
            ps.setString(5, image);
            ps.setString(6, gia);
            ps.setString(7, title);
            ps.setString(8, describes);
            ps.setString(9, image1);
            ps.setString(10, image2);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void upDateProduct(String name, String category, String pid,
            String price, String image, String gia, String title, String describes, String image1, String image2) {
        String sql = "UPDATE products "
                + "SET name = ?, "
                + "    category_id = ?, "
                + "    price = ?, "
                + "    image = ?, "
                + "    gia = ? , "
                + "    title = ? , "
                + "    describes = ? , "
                + "    image1 = ?, "
                + "    image2 = ? "
                + "WHERE id = ?";
        try {
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setString(5, gia);
            ps.setString(6, title);
            ps.setString(7, describes);
            ps.setString(8, image1);
            ps.setString(9, image2);
            ps.setString(10, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Product getAllProductByID(String id) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "Select * from products\n"
                    + "where id = ? ";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                return product;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Product> getTop6Product() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "Select top 6 * from products";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }
            return products;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Product> getNextProduct(int amount) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "  select * from products order by id \n"
                    + "  offset ? rows\n"
                    + "  fetch next 6 rows only";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, amount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                products.add(product);
            }
            return products;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int getTotalProduct() {
        try {
            String sql = "Select count(*) from products";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public List<Product> PagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select* from products  \n"
                    + "Order by id\n"
                    + "offset ? rows fetch next 4 rows only";
            Connection con = DBContext();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 4);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setGia(rs.getString("gia"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setTitle(rs.getString("title"));
                product.setDescribes(rs.getString("describes"));
                product.setImage1(rs.getString("image1"));
                product.setImage2(rs.getString("image2"));
                list.add(product);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        List<Product> list = pdao.getTop6Product();
        for (Product o : list) {
            System.out.println(o);
        }

    }
}
