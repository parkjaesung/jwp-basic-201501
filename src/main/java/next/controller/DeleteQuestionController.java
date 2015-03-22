package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.DaoFactory;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class DeleteQuestionController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(DeleteQuestionController.class);
	
	private QuestionDao questionDao = DaoFactory.getQuestionDao();
	private AnswerDao answerDao = DaoFactory.getAnswerDao();
	
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Question question;
		List<Answer> answers;
		
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");
		logger.debug("questionId : {}", questionId);
		question = questionDao.findById(questionId);
		answers = answerDao.findAllByQuestionId(questionId);
		ModelAndView mav = jsonView();
		if(answers.size()!= 0 && isNotSameWriter(answers,question)){
			return mav;
		}
		questionDao.delete(questionId);
		return mav;
	}

	private boolean isNotSameWriter(List<Answer> answers, Question question) {
		for (Answer answer : answers) {
			if(answer.getWriter() != question.getWriter()){
				return true;
			}
		}
		return false;
	}


}
