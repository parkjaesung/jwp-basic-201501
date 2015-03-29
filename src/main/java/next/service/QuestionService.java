package next.service;

import java.util.List;

import javax.servlet.ServletException;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

public class QuestionService {
	QuestionDao questionDao = QuestionDao.getInstance();
	AnswerDao answerDao = AnswerDao.getInstance();

	Question question;
	List<Answer> answers;

	public QuestionService(long questionId) throws ServletException {
		question = questionDao.findById(questionId);
		if (question == null) {
			throw new ServletException("존재하지 않는 질문 입니다 ");
		}

	}

	public boolean delete() {
		answers = answerDao.findAllByQuestionId(question.getQuestionId());
		if (isAnotherWriter(answers)) {
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
		if (answers.isEmpty())
			return false;
		for (Answer answer : answers) {
			if (answer.getWriter() != question.getWriter()) {
				return true;
			}
		}
		
		return false;
	}

	public Object getQuestion() {
		return question;
	}

	public Object getAnswers() {
		return answers;
	}

}
