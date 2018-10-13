package DBAccess;

import FunctionLayer.BrickCalculator;
import FunctionLayer.GeneralException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class DataMapper {

    public static void createUser(User user) throws GeneralException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO User (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws GeneralException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM User "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new GeneralException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static int createOrder(HashMap<String, Integer> map, User user) throws GeneralException {
        try {
            Integer i = null;
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `Order` (id, User_Id, isShipped, length, width, height) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setNull(1, Types.INTEGER);
            ps.setInt(2, user.getId());
            ps.setBoolean(3, false);
            ps.setInt(4, map.get("length"));
            ps.setInt(5, map.get("width"));
            ps.setInt(6, map.get("height"));

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            return id;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrdersByUserID(int userID) throws GeneralException {
        ArrayList<Order> l = new ArrayList();
        BrickCalculator bc = new BrickCalculator();
        try {
            Connection con = Connector.connection();
            String SQL = "select id, isshipped, length, width, height from `Order` where User_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                int length = res.getInt("length");
                int width = res.getInt("width");
                int height = res.getInt("height");
                boolean isShipped = res.getBoolean("isShipped");
                HashMap brickMap = bc.calculate(String.valueOf(length), String.valueOf(width), String.valueOf(height));
                Order o = new Order(id, length, width, height, brickMap, isShipped);
                l.add(o);
            }
            return l;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static ArrayList<User> getAllUsers() throws GeneralException {
        ArrayList<User> l = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "select id, email, role from `User`;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String email = res.getString("email");
                String role = res.getString("role");
                User u = new User(email,"",role);
                u.setId(id);
                l.add(u);
            }
            return l;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }
    

}
