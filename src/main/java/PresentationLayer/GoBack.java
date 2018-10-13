/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.GeneralException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathias
 */
public class GoBack extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        User u = (User) request.getSession().getAttribute( "user");
        return u.getRole() + "page";
    }
    
    
}
