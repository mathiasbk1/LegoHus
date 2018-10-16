package FunctionLayer;

import DBAccess.DataMapper;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws GeneralException {
        return DataMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws GeneralException {
        User user = new User(email, password, "customer");
        DataMapper.createUser( user );
        return user;
    }
    public static Order makeOrder (String width, String length, String height, User user) throws GeneralException{
        if(user == null) throw new GeneralException("No user logged in");
        BrickCalculator b = new BrickCalculator();
        HashMap<String, Integer> map = b.calculate(width, length, height);
        int id = DataMapper.createOrder(map,user);
        
        return new Order(id, map.get("width"), map.get("length"), map.get("height"), map, false);
        
    }
    public static ArrayList<Order> viewOrders(User u) throws GeneralException{
        return DataMapper.getOrdersByUserID(u.getId());
        
    }
    
    public static ArrayList<User> getAllUsers() throws GeneralException{
        return DataMapper.getAllUsers();
        
    }
    
    

}
