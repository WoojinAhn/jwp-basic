package next.View;

import core.mvc.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1001192 on 2016. 7. 18..
 */
public class JspView implements View{
    private static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private String jspFilename;

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (jspFilename.startsWith(DEFAULT_REDIRECT_PREFIX)) {
                response.sendRedirect(jspFilename.substring(DEFAULT_REDIRECT_PREFIX.length()));
                return;
            }

            RequestDispatcher rd = request.getRequestDispatcher(jspFilename);
            rd.forward(request, response);
    }

    public JspView(String jspFileName) {
        this.jspFilename = jspFileName;
    }
}
