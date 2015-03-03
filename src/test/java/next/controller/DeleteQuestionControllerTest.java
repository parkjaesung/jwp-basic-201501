package next.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

import org.junit.Test;
import org.mockito.Mockito;

public class DeleteQuestionControllerTest {

	DeleteQuestionController dqc = new DeleteQuestionController();
	QuestionDao qDao = Mockito.mock(QuestionDao.class);
	AnswerDao aDao = Mockito.mock(AnswerDao.class);
	
	@Test
	public void testWhenAnswerSizeZero() {
		Mockito.when(qDao.findById(1)).thenReturn(new Question("javajigi", "제목", "내용"));
		Result result = dqc.delete(1, "javajigi", qDao, aDao);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void testWhenAnswerSizeNotZeroAndSameWriter() {
		Question q = new Question(1, "javajigi", "제목", "z", new Date(), 1);
		Mockito.when(qDao.findById(1)).thenReturn(q);
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer("javajigi", "내용", 1));
		Mockito.when(aDao.findAllByQuestionId(1)).thenReturn(answers);
		
		Result result = dqc.delete(1, "javajigi", qDao, aDao);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void testWhenWriterDifferent() {
		Mockito.when(qDao.findById(1)).thenReturn(new Question("ja", "제목", "내용"));
		Result result = dqc.delete(1, "javajigi", qDao, aDao);
		assertFalse(result.isSuccess());
	}
	
	@Test
	public void testWhenAnswerWriterDifferent() {
		Question q = new Question(1, "javajigi", "제목", "z", new Date(), 1);
		Mockito.when(qDao.findById(1)).thenReturn(q);
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer("gi", "제목", 1));
		Mockito.when(aDao.findAllByQuestionId(1)).thenReturn(answers);
		
		Result result = dqc.delete(1, "javajigi", qDao, aDao);
		assertFalse(result.isSuccess());
		
	}
	

}
