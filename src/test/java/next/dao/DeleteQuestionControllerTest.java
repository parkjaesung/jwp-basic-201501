package next.dao;

import org.junit.Test;
import org.mockito.Mockito;

import next.controller.DeleteQuestionController;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.ModelAndView;




public class DeleteQuestionControllerTest {
	
	Controller controller = new DeleteQuestionController();
	QuestionDao questionDao = Mockito.mock(QuestionDao.class);
	AnswerDao answerDao = Mockito.mock(AnswerDao.class);
	Question question = new Question("writer", "title", "content");
	long questionId = 1;
	@Test
	public void deleteQustionWithNoAnswer() throws Exception {
		Mockito.when(questionDao.findById(questionId)).thenReturn(question);
//		ModelAndView mav = controller.execute(request, response);
		
		//지워져야함 
	}
	@Test
	public void deleteQustionWithAnswerBySameWriter() throws Exception {
		Mockito.when(questionDao.findById(questionId)).thenReturn(question);
		//지워져야함 
	}
	@Test
	public void deleteQustionWithNoAnswerByNotSameWriter() throws Exception {
		Mockito.when(questionDao.findById(questionId)).thenReturn(question);
		questionDao.delete(questionId);
		//않지워져야함 
	}
	@Test
	public void deleteQustionWithNoAnswerByAllWriter() throws Exception {
		Mockito.when(questionDao.findById(questionId)).thenReturn(question);
		questionDao.delete(questionId);
		//않지워져야함 
	}

}
