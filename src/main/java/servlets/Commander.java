package servlets;

import actions.*;
import actions.getInfActions.*;
import actions.sweetsActions.*;
import database.ManagementSystem;
import actions.sortActions.SortByPriceAction;
import actions.sortActions.SortBySugarAction;
import actions.sortActions.SortByWeightAction;
import sweets.Sweet;
import sweets.Wafer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Elena on 25.10.2016.
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {

    public static List<Sweet> sweetList = new ArrayList<Sweet>();

    private Map<String, Action> actionMap = new HashMap<String, Action>();

    private ManagementSystem managementSystem = new ManagementSystem();

    public Commander(){

        actionMap.put("ShowGift", new ShowGiftAction());
        actionMap.put("CreateGift", new CreateGiftAction());
        actionMap.put("Search", new SearchAction());
        actionMap.put("ParametersSearch", new ParametersSearchAction());
        actionMap.put("SortByPrice", new SortByPriceAction());
        actionMap.put("SortBySugar", new SortBySugarAction());
        actionMap.put("SortByWeight", new SortByWeightAction());
        actionMap.put("ButterscotchGetInf", new ButterscotchGetInfAction());
        actionMap.put("ChocolateGetInf", new ChocolateGetInfAction());
        actionMap.put("JellyGetInf", new JellyGetInfAction());
        actionMap.put("LiqueurGetInf", new LiqueurGetInfAction());
        actionMap.put("WaferGetInf", new WaferGetInfAction());
        actionMap.put("Butterscotch", new ButterscotchAction());
        actionMap.put("Chocolate", new ChocolateAction());
        actionMap.put("Jelly", new JellyAction());
        actionMap.put("Liqueur", new LiqueurAction());
        actionMap.put("Wafer", new WaferAction());
        actionMap.put("TotalWeight", new TotalWeightAction());
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionKey = request.getParameter("command");
        Action action = actionMap.get(actionKey);
        try {
            action.execute(request, response, managementSystem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
