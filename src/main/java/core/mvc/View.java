package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 1001192 on 2016. 7. 18..
 */
public interface View {
    void render(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
