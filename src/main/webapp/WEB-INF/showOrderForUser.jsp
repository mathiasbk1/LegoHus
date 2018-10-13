<%-- 
    Document   : showOrderForUser
    Created on : 12-10-2018, 15:04:17
    Author     : Mathias
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <% ArrayList<Order> list = ((User) session.getAttribute("user")).getOrders(); %>
        <h3>List of previous orders:</h3>
        <ul>
            <%
                for (int i = 0; i < list.size(); i++) {
                    Order o = list.get(i);
                    HashMap<String, Integer> omap = o.getMap();
                    out.println("<li> Id = " + o.getId() + "<br>length = " + o.getLength() + ", width = " + o.getWidth() + ", height = " + o.getHeight()
                            + "<br>List of pieces: <br>Amount of 2x4 = " + omap.get("total2x4") + ", amount of 2x2 = " + omap.get("total2x2") + ", amount of 2x1 = " + omap.get("total2x1"));
                }


            %>

        </ul>
        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="goBack">
            <input type="submit" value="Go back">
        </form>
        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logOut">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
