import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/calculate")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String productDes = request.getParameter("productDesc");
        double price = Double.parseDouble(request.getParameter("listPrice"));
        double percent = Double.parseDouble(request.getParameter("discountPercent"));

        double discountAmount = price * percent * 0.01 ;

        double discountPrice = price - discountAmount;
        request.setAttribute("proDes1",productDes);
        request.setAttribute("dis1",discountAmount);
        request.setAttribute("price1",discountPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-discount.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
