import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="ServletConfigClass",
        urlPatterns={"/my"},
        initParams = {
                @WebInitParam(name = "username", value = "admin"),
                @WebInitParam(name = "password", value = "123456"),

        })
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("Hello to doGet");
        System.out.println("Call the doGet");

        ServletConfig config = getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(String.format("Username: %s Password: %s", username, password));

    }
}
