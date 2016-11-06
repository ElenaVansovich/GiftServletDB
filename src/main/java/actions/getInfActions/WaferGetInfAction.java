package actions.getInfActions;

import actions.Action;
import database.ManagementSystem;
import servlets.Commander;
import sweets.Sweet;
import sweets.Wafer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Elena on 25.10.2016.
 */
public class WaferGetInfAction implements Action {

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        Sweet wafer = new Wafer(request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                Double.parseDouble(request.getParameter("sugar")),
                Double.parseDouble(request.getParameter("weight")),
                Double.parseDouble(request.getParameter("wafer")));
        try {
            managementSystem.addSweet(wafer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Commander.sweetList = managementSystem.getAllSweets();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", Commander.sweetList);
        request.getRequestDispatcher("/WEB-INF/createGiftForm.jsp").forward(request, response);
    }

}
