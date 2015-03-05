package next.dao;

import next.dao.AnswerDao;
import next.dao.QuestionDao;

public class DaoFactory {
	private static QuestionDao questionDao = new QuestionDao();
	private static AnswerDao  answerDao = new AnswerDao();
	
	public static QuestionDao getQuestionDao(){
		return questionDao;
	}
	
	public static AnswerDao getAnswerDao(){
		return answerDao;
	}
}
