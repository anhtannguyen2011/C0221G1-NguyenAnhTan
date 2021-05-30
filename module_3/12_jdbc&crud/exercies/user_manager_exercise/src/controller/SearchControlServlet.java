package controller;

import model.bean.User;
import model.services.IUserService;
import model.services.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControlSearchServlet",urlPatterns = "/search")
public class SearchControlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        IUserService userService = new UserServiceImpl();
        List<User> userList = userService.searchByCountry(name);
        request.setAttribute("listUser",userList);
        request.getRequestDispatcher("view/user/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
