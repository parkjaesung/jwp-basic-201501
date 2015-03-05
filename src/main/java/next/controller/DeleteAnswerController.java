package next.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class DeleteAnswerController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(DeleteAnswerController.class);

	
	private AnswerDao answerDao = new AnswerDao();
	private QuestionDao questionDao = new QuestionDao();
	
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long questionId = ServletRequestUtils.getLongParameter(request, "questionId");
		Long answerId = ServletRequestUtils.getLongParameter(request, "answerId");
		
		answerDao.delete(answerId);
		questionDao.updateCount(questionId,-1);
		
		logger.debug("Answer deleted  questionId: {} answerId : {}", questionId, answerId);
		
		ModelAndView mav = jsonView();
		return mav; 
	}
}
