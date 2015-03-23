package next.dao;

import java.util.HashMap;
import java.util.Map;

import next.model.Answer;
import next.model.Question;

public class Database extends QuestionDao {
	private Map<Long, Question> qustions = new HashMap<Long, Question>();
	private Map<Long, Answer> answers = new HashMap<Long, Answer>();

	public void insert(Question question) {
		qustions.put(question.getQuestionId(), question);
	}
	public void insert(Answer answer) {
		answers.put(answer.getQuestionId(), answer);
	}

	public Question find(Long questionId) {
		return qustions.get(questionId);
	}
	public Answer findAllByQuestionId(Long questionId) {
		return answers.get(questionId);
	}

	public Question deleteQuestion(Long questionId) {
		return qustions.remove(questionId);
	}
}
