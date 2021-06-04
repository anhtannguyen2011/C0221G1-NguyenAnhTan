package services.controller;

import services.model.bean.RentType;
import services.model.bean.Service;
import services.model.bean.ServiceType;
import services.model.service.Impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet",urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    ServiceServiceImpl serviceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create" :
                createServices(request,response);
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
                showcreateServices(request,response);
                break;
        }
    }

    private void showcreateServices(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        request.setAttribute("id_type",typeId);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void createServices(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("service_name");
        int serviceArea = Integer.parseInt(request.getParameter("service_area"));
        double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        RentType rentTypeId = serviceService.findByRentType(Integer.parseInt(request.getParameter("rent_type_id")));
        ServiceType serviceTypeID =serviceService.findByIdType(Integer.parseInt(request.getParameter("service_type_id")));
        String strandardRoom = request.getParameter("strandard_room");
        String des = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberFloor = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(name,serviceArea,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeID,strandardRoom,des,poolArea,numberFloor);
        serviceService.insertService(service);

        try {
            response.sendRedirect("view/main_page.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
