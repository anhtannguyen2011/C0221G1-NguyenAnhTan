<%@ page import="model.Customers" %>
<%@ page import="controller.AddCustomers" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.CustomersServlet" %>
<%--

  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/27/2021
  Time: 7:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <style>
        td{
            line-height: 100px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h3 class="text-center">Danh Sách Khách Hàng</h3>
    <table class="table border border-dark">
        <thead>
        <tr>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cus}" var="c">
            <tr>
                <td>${c.name}</td>
                <td>${c.dayOfBirth}</td>
                <td>${c.address}</td>
                <td><img src="${c.image}" width="100px" height="100px"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



</body>
</html>
