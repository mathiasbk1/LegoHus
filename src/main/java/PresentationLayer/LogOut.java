/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.GeneralException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathias
 */
public class LogOut extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        request.getSession().invalidate();
        return "index";
    }
    
}
