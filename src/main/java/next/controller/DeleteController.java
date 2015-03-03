package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.DaoFactory;
import next.dao.QuestionDao;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class DeleteController extends AbstractController{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao qDao = DaoFactory.getQuestionDao();
		AnswerDao aDao = DaoFactory.getAnswerDao();
		
		long answerId = ServletRequestUtils.getLongParameter(request, "answerId");
		long questionId = ServletRequestUtils.getLongParameter(request, "questionId");
		
		aDao.deleteAnswer(answerId);
		qDao.minusCount(questionId);
		
		ModelAndView mav = jsonView();
		return mav;	
	}

}
