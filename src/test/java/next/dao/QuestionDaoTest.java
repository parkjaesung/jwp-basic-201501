package next.dao;

import static org.junit.Assert.*;

import java.util.List;

import next.model.Question;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import core.jdbc.ConnectionManager;

public class QuestionDaoTest {
	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("jwp.sql"));
		DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
	}

	@Test
	public void crud() throws Exception {
		Question expected = new Question("자바지기", "title", "contents");
		QuestionDao dut = new QuestionDao();
		dut.insert(expected);
		
		List<Question> questions = dut.findAll();
		assertTrue(questions.size() > 0);
	}
	@Test
	public void deleteQustionWithNoAnswer() throws Exception {
		Question expected = new Question("자바지기", "title", "contents");
		
		long questionId = 1;
		QuestionDao dut = new QuestionDao();
		dut.delete(questionId);
		//지워져야함 
	}
	@Test
	public void deleteQustionWithAnswerBySameWriter() throws Exception {
		long questionId = 1;
		QuestionDao dut = new Database();
		dut.delete(questionId);
		//지워져야함 
	}
	@Test
	public void deleteQustionWithNoAnswerByNotSameWriter() throws Exception {
		long questionId = 1;
		QuestionDao dut = new QuestionDao();
		dut.delete(questionId);
		//않지워져야함 
	}
	@Test
	public void deleteQustionWithNoAnswerByAllWriter() throws Exception {
		long questionId = 1;
		QuestionDao dut = new QuestionDao();
		dut.delete(questionId);
		//않지워져야함 
	}
	@Test
	public void mockito() throws Exception {
		
	}
}
