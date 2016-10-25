package actions;

import database.ManagementSystem;
import servlets.Commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Elena on 25.10.2016.
 */
public class CreateGiftAction implements Action{

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        try {
            managementSystem.clearGift();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Commander.sweetList.clear();
        request.getRequestDispatcher("/WEB-INF/createGiftForm.jsp").forward(request, response);
    }

}
