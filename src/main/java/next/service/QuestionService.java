package next.service;

import java.util.List;

import next.dao.AnswerDao;
import next.dao.DaoFactory;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

public class QuestionService {
	QuestionDao questionDao = DaoFactory.getQuestionDao();
	AnswerDao answerDao = DaoFactory.getAnswerDao();
	
	Question question;

	public QuestionService(long questionId) {
		question = questionDao.findById(questionId);
	}

	public boolean delete() {
		List<Answer> answers = answerDao.findAllByQuestionId(question.getQuestionId());
		if(isAnotherWriter(answers)){
			return false;
		}
		deleteAnswers(answers);
		deleteQuestion();
		
		return true;
		
	}

	private void deleteQuestion() {
		questionDao.delete(question.getQuestionId());
		
	}

	private void deleteAnswers(List<Answer> answers) {
		for (Answer answer : answers) {
			answerDao.delete(answer.getAnswerId());
		}
	}

	private boolean isAnotherWriter(List<Answer> answers) {
		for (Answer answer : answers) {
			if(answer.getWriter() != question.getWriter()){
				return true;
			}
		}
		return false;
	}
}
