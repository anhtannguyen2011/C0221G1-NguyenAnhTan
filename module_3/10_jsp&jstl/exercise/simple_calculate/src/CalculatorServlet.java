import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/Calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        float fistNumber = Float.parseFloat(request.getParameter("fistNumber"));
        float secondNumber = Float.parseFloat(request.getParameter("secondNumber"));
        String operator = request.getParameter("operator");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1> Result </h1>");

        try{
            float result = Calculator.calculate(fistNumber,secondNumber,operator);
            printWriter.println("<h3>"+fistNumber+" " +operator+" "+secondNumber+" = "+result+"</h3>");
        }catch (Exception e){
            printWriter.println("Lỗi : " +e.getMessage());
        }

        printWriter.println("</html>");
    }
}
