package next.dao;

import java.util.HashMap;
import java.util.Map;

import next.model.Question;

public class Database {
	private static Map<Long,Question> db = new HashMap<Long, Question>();
	
	public static void addQuestion(Question question) {
		db.put(question.getQuestionId(),question);
	}
	
	public static Question deleteQuestion(Long questionId ) {
		return db.get(questionId);
	}
}
