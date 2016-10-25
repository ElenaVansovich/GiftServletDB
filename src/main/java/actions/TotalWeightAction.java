package actions;

import database.ManagementSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Elena on 25.10.2016.
 */
public class TotalWeightAction implements Action{

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        double weight = 0;
        try {
            weight = managementSystem.totalWeight();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("totalWeight", String.valueOf(weight));
        request.getRequestDispatcher("/WEB-INF/totalWeight.jsp").forward(request, response);
    }

}
