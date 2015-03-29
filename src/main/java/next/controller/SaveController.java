package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class SaveController extends AbstractController {
	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);

	
	private QuestionDao questionDao = QuestionDao.getInstance();
	
	
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String writer = ServletRequestUtils.getStringParameter(request, "writer");
		String title = ServletRequestUtils.getStringParameter(request, "title");
		String contents = ServletRequestUtils.getStringParameter(request, "contents");
		
		logger.debug("question inserted  title: {} writer: {} contents: {}",title,writer,contents);
		
		Question question = new Question(writer, title, contents);
		questionDao.insert(question);
		
		ModelAndView mav = jstlView("redirect:/list.next");
		
		return mav; 
	}
}
