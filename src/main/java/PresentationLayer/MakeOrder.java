/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.GeneralException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathias
 */
public class MakeOrder extends Command {

    public MakeOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        String length = (String) request.getParameter("length");
        String width = (String) request.getParameter("width");
        String height = (String) request.getParameter("height");
//        
        User user = (User) request.getSession().getAttribute("user");
        
        if (Integer.parseInt(length) <5 || Integer.parseInt(length) >25){
            throw new GeneralException("Length must be between 5 and 25");   
        }
        if (Integer.parseInt(width) <5 || Integer.parseInt(width) >25)
            throw new GeneralException("Width must be between 5 and 25");
        if (Integer.parseInt(height) <2 || Integer.parseInt(height) >25)
            throw new GeneralException("Height must be between 2 and 25");
        
        Order o = LogicFacade.makeOrder(width, length, height, user);
        request.getSession().setAttribute("order", o);
        return "singleOrder";
    }
    
}
