package next.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.DaoFactory;
import next.dao.QuestionDao;
import next.model.Answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class AddAnswerController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(AddAnswerController.class);

	
	private AnswerDao answerDao = DaoFactory.getAnswerDao();
	private QuestionDao questionDao = DaoFactory.getQuestionDao();
	
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long questionId = ServletRequestUtils.getLongParameter(request, "questionId");
		String writer = ServletRequestUtils.getStringParameter(request, "writer");
		String contents = ServletRequestUtils.getStringParameter(request, "contents");
		
		Answer answer = new Answer(writer, contents, questionId);
		answerDao.insert(answer);
		questionDao.updateCount(questionId,1);
		
		logger.debug("Answer inserted  questionId: {} writer: {} contents: {}", questionId, writer, contents);
		
		ModelAndView mav = jsonView();
		return mav; 
	}
}
