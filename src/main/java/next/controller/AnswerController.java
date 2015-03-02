package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class AnswerController extends AbstractController{

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AnswerDao dao = new AnswerDao();
		String writer = ServletRequestUtils.getStringParameter(request, "writer");
		String contents = ServletRequestUtils.getStringParameter(request, "contents");
		long questionId = ServletRequestUtils.getLongParameter(request, "questionId");
		
		dao.insert(new Answer(writer, contents, questionId));
		QuestionDao qDao = new QuestionDao();
		qDao.updateCount(questionId);
		ModelAndView mav = jsonView();
		return mav;
	}

}
