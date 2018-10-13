/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.GeneralException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathias
 */
public class ShowAllOrders extends Command {

    public ShowAllOrders() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        ArrayList<User> list = LogicFacade.getAllUsers();
        System.out.println("list size------------"+list.size());
        request.getSession().setAttribute("userList", list);
        return "showAllOrders";
    }
    
}
