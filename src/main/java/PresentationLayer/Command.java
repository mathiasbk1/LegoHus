package PresentationLayer;

import FunctionLayer.GeneralException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "backdoor", new Backdoor() );
        commands.put( "makeOrder", new MakeOrder() );
        commands.put( "goBack", new GoBack() );
        commands.put( "showOrdersForUser" , new ShowOrdersForUser() );
        commands.put( "showAllOrders" , new ShowAllOrders() );
        commands.put( "logOut" , new LogOut() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws GeneralException;

}
