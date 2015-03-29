package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.exception.ExistedAnotherUserException;
import next.exception.ResourceNotFoundException;
import next.service.QuestionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class ApiDeleteQuestionController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(ApiDeleteQuestionController.class);

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");
		logger.debug("questionId : {}", questionId);

		QuestionService qs = new QuestionService();

		try {
			qs.setQuestion(questionId);
			qs.delete();
			return jsonView();

		} catch (ResourceNotFoundException|ExistedAnotherUserException e) {
			ModelAndView mav = jsonView();
			mav.addObject("question", qs.getQuestion());
			mav.addObject("answers", qs.getAnswers());
			mav.addObject("errorMessage", "다른 사용자가 추가한 댓글이 존재하여 삭제 할 수 없습니다. ");
			return mav;
		}
	}

}
