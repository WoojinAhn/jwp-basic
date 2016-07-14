package next;

import next.controller.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1001192 on 2016. 7. 11..
 */
public class RequestMapping {
    private Map<String, Controller> mappings = new HashMap<>();

    public RequestMapping() {
        init();
    }

    void init() {
        mappings.put("/", new HomeController());
        mappings.put("/users", new ListUserController());
        mappings.put("/users/login", new LoginController());
        mappings.put("/users/form", new CreateUserController());
        mappings.put("/users/create", new CreateUserController());
    }

    public Controller findController(String url) {
        return mappings.get(url);
    }

}
