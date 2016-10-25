package actions;

import database.ManagementSystem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Elena on 25.10.2016.
 */
public interface Action {
    /**
     * @param request
     * @param response
     * @param managementSystem
     * @throws Exception
     */
    void execute(HttpServletRequest request, HttpServletResponse response,
                 ManagementSystem managementSystem) throws Exception;
}
