package customers.controller;

import customers.model.bean.CustomerType;
import customers.model.bean.Customers;
import customers.model.repository.CustomerTypeRepository;
import customers.model.service.ICustomerServices;
import customers.model.service.Impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomersServlet",urlPatterns = {"/customer"})
public class CustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICustomerServices customerServices;

    @Override
    public void init() throws ServletException {
        customerServices = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create" :
                createNewCustomer(request,response);
                break;
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }

        switch (action){
            case "create" :
                showCreateForm(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Customers customers = new Customers();
            request.setAttribute("customer",customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
            dispatcher.forward(request,response);

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = customerServices.selectAllCustomers();
        request.setAttribute("listCustomers",customersList);
        request.getRequestDispatcher("view/customer/list.jsp").forward(request,response);

    }
    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("day_of_birth");
        int idCard = Integer.parseInt(request.getParameter("id_card"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType id_type = customerServices.selectCustomerType(Integer.parseInt(request.getParameter("id_loai_khach")));
        Customers customers = new Customers(id,name,dayOfBirth,idCard,phone,email,address,id_type);
        try {
            customerServices.insertCustomer(customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<Customers> customersList = customerServices.selectAllCustomers();
            request.setAttribute("listCustomers",customersList);
            request.getRequestDispatcher("view/customer/list.jsp").forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
