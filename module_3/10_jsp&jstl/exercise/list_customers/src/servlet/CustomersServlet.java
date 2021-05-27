package servlet;

import controller.AddCustomers;
import model.Customers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomersServlet",urlPatterns = "" )
public class CustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customers = AddCustomers.addCustomers();
        request.setAttribute("cus",customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show.jsp");
        requestDispatcher.forward(request,response);
    }
}