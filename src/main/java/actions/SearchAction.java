package actions;

import database.ManagementSystem;
import servlets.Commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Elena on 25.10.2016.
 */
public class SearchAction implements Action{

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        double price = Double.parseDouble(request.getParameter("price"));
        double sugar = Double.parseDouble(request.getParameter("sugar"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        try {
            Commander.sweetList = managementSystem.getSweetsWithParameters(price, sugar, weight);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/showSearchSweet.jsp").forward(request, response);
    }

}
