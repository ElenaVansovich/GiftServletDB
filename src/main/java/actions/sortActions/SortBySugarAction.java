package actions.sortActions;

import actions.Action;
import database.ManagementSystem;
import servlets.Commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Elena on 25.10.2016.
 */
public class SortBySugarAction implements Action {

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        try {
            Commander.sweetList = managementSystem.sortBySugar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", Commander.sweetList);
        request.getRequestDispatcher("/WEB-INF/createGiftForm.jsp").forward(request, response);
    }

}
