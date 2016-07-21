package next.controller.qna;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.controller.UserSessionUtils;
import next.dao.QuestionDao;
import next.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 1001192 on 2016. 7. 21..
 */
public class CreateQuestionController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(AddAnswerController.class);

    private QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
        //세션가져와서 검증
        if (!UserSessionUtils.isLogined(req.getSession())) {
            return jspView("redirect:/users/loginForm");
        }
        Question question = new Question(req.getParameter("writer"),
                req.getParameter("contents"),
                req.getParameter("title")
                );

        log.debug("question : {}", question);
        questionDao.insert(question);

        return jspView("../index.jsp").addObject("questions", questionDao.findAll());
    }
}
