package contract.controller;

import contract.model.service.Impl.ContractServiceImpl;
import customers.model.bean.Customers;
import customers.model.service.Impl.CustomerServiceImpl;
import employee.model.bean.Employee;
import employee.model.service.Impl.EmployeeServiceImpl;
import services.model.bean.Service;
import services.model.service.Impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractServiceImpl contractService = new ContractServiceImpl();
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    ServiceServiceImpl serviceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateContract(request, response);
                break;
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        List<Customers> customersList = customerService.selectAllCustomers();
        List<Service> serviceList = serviceService.selectAllService();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customersList",customersList);
        request.setAttribute("serviceList",serviceList);

        try {
            request.getRequestDispatcher("/view/contract/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}