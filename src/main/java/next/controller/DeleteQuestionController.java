package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.service.QuestionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class DeleteQuestionController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(DeleteQuestionController.class);

	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");
		logger.debug("questionId : {}", questionId);

		QuestionService qs = new QuestionService(questionId);
		if (qs.delete()) {
			// 성공
		}
		ModelAndView mav = jstlView("redirect:/list.next");
		return mav;

	}

}
