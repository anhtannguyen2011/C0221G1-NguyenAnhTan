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

@WebServlet(name = "SortControlServlet",urlPatterns = "/sort")
public class SortControlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService service = new UserServiceImpl();
        List<User> userList = service.sortByName();
        request.setAttribute("listUser",userList);
        request.getRequestDispatcher("view/user/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
