package FunctionLayer;

import java.util.ArrayList;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User(String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    ArrayList<Order> orderList = new ArrayList();
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;

    public void AddOrderToList(Order order){
        orderList.add(order);
    }
    public ArrayList<Order> getOrders() throws GeneralException{
        return LogicFacade.viewOrders(this);
    }
    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
