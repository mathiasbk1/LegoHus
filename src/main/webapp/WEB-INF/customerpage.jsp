<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
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
        <title>Customer home page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
        <table>
            <tr><td>Make Order</td>
                <td>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="makeOrder">
                        Length in lego dots<br>
                        <input type="text" name="length" value="0">
                        <br>
                        Width in dots<br>
                        <input type="text" name="width" value="0">
                        <br>
                        Height in amount of layers<br>
                        <input type="text" name="height" value="0">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="showOrdersForUser">
                        <input type="submit" value="View your previous orders">
                    </form>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="logOut">
                        <input type="submit" value="Logout">
                    </form>
                </td>

        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>
