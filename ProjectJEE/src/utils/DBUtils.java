package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import beans.File;
import beans.User;
 
public class DBUtils {
 
    public static User findUser(Connection conn, String username, String password) throws SQLException {
 
        String sql = "Select users.username, users.password from project.users where users.username = ? and users.password = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static User findUser(Connection conn, String username) throws SQLException {
 
        String sql = "Select users.username, users.password from project.users where users.username = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("password");
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static List<File> queryFile(Connection conn) throws SQLException {
    	
        String sql = "Select files.id, files.name, files.composer, files.type, files.price from project.files";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        
        List<File> list = new ArrayList<File>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String composer = rs.getString("composer");
            String type = rs.getString("type");
            float price = rs.getFloat("price");
            File file = new File();
            file.setId(id);
            file.setName(name);
            file.setComposer(composer);
            file.setType(type);
            file.setPrice(price);
            list.add(file);
        }
        return list;
    }
    
    public static File findFile(Connection conn, int id) throws SQLException {
        String sql = "Select files.id, files.name, files.composer, files.type, files.price from project.files where files.id=?";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("name");
            String composer = rs.getString("composer");
            String type = rs.getString("type");
            float price = rs.getFloat("price");
            File product = new File(id, name, composer, type, price);
            return product;
        }
        return null;
    }
 
    public static void updateFile(Connection conn, File file) throws SQLException {
        String sql = "Update files set name =?, composer=?, type=?, price=? where id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, file.getName());
        pstm.setString(2, file.getComposer());
        pstm.setString(3, file.getType());
        pstm.setFloat(4, file.getPrice());
        pstm.setInt(5, file.getId());
        pstm.executeUpdate();
    }
 
    public static void insertFile(Connection conn, File file) throws SQLException {
        String sql = "Insert into files(id, name, composer, type, price) values (?,?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, file.getId());
        pstm.setString(2, file.getName());
        pstm.setString(3, file.getComposer());
        pstm.setString(4, file.getType());
        pstm.setFloat(5, file.getPrice());
 
        pstm.executeUpdate();
    }
 
    public static void deleteFile(Connection conn, int id) throws SQLException {
        String sql = "Delete from files where id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
}
