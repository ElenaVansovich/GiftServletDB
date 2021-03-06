package actions.sweetsActions;

import actions.Action;
import database.ManagementSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Elena on 25.10.2016.
 */
public class LiqueurAction implements Action {

    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    public void execute(HttpServletRequest request, HttpServletResponse response,
                        ManagementSystem managementSystem) throws Exception {
        request.getRequestDispatcher("/WEB-INF/inputInfoForm/liqueurForm.jsp").forward(request, response);
    }

}
