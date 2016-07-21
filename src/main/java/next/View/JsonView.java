package next.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.mvc.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1001192 on 2016. 7. 18..
 */
public class JsonView implements View{

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(createModel(request));
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
    }

    private Map<String, Object> createModel(HttpServletRequest request) {
        Enumeration<String> names = request.getAttributeNames();
        Map<String, Object> model = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            model.put(name, request.getAttribute(name));
        }
        return model;
    }

}
