<%-- 
    Document   : singleOrder
    Created on : 12-10-2018, 14:10:27
    Author     : Mathias
--%>

<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.Order"%>
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
        <style>
            table {
                border-collapse: collapse;
                width: 50%;
            }

            td, th {
                text-align: left;
                padding: 8px;
            </style>

        </head>
        <body>
            <h1>Hello World!</h1>
            <div>
                <%
                    Order o = (Order) request.getSession().getAttribute("order");
                    HashMap<String, Integer> omap = o.getMap();
                    out.println("Id = " + o.getId() + "<br>length = " + o.getLength() + ", width = " + o.getWidth() + ", height = " + o.getHeight()
                            + "<br>List of pieces: <br>Amount of 2x4 = " + omap.get("total2x4") + ", amount of 2x2 = " + omap.get("total2x2") + ", amount of 2x1 = " + omap.get("total2x1"));%>
            </div>

            <h3>Your Order:</h3>

            <table class="table">
                <tr>
                    <th scope="col">House Length</th>
                    <th scope="col">House Width</th>
                    <th scope="col">House Height</th>
                </tr>
                <tr>
                    <td>
                        <%= omap.get("length")%>
                    </td>
                    <td>
                        <%= omap.get("width")%>
                    </td>
                    <td>
                        <%= omap.get("height")%>
                    </td>

                </tr>
            </table>
            <h3>Your Bricks:</h3>
            <table class="table">
                <tr>
                    <th scope="col">Type</th >
                    <th scope="col">Amount</th>
                </tr>
                <tr>
                    <td>4x2</td>
                    <td>
                        <%= omap.get("total2x4")%>
                    </td>
                </tr>
                <tr>
                    <td>2x2</td>
                    <td>
                        <%= omap.get("total2x2")%>
                    </td>
                </tr>
                <tr>
                    <td>1x2</td>
                    <td>
                        <%= omap.get("total2x1")%>
                    </td>
                </tr>
            </table>
            <br>
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
