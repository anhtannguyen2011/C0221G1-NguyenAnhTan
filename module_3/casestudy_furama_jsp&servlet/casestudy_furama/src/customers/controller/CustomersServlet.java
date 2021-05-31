package customers.controller;

import customers.model.bean.Customers;
import customers.model.service.ICustomerServices;
import customers.model.service.Impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomersServlet",urlPatterns = {"","/customers"})
public class CustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICustomerServices customerServices;

    @Override
    public void init() throws ServletException {
        customerServices = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }

        switch (action){
            case "12" :
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = customerServices.selectAllCustomers();
        request.setAttribute("listCustomers",customersList);
        request.getRequestDispatcher("view/customer/list.jsp").forward(request,response);

    }
}
