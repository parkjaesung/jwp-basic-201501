package next.service;

import java.util.List;


import next.exception.ExistedAnotherUserException;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.exception.ResourceNotFoundException;
import next.model.Answer;
import next.model.Question;

public class QuestionService {
	QuestionDao questionDao = QuestionDao.getInstance();
	AnswerDao answerDao = AnswerDao.getInstance();

	Question question;

	public void setQuestion(long questionId) throws ResourceNotFoundException {
		question = questionDao.findById(questionId);
		if (question == null) {
			throw new ResourceNotFoundException("존재하지 않는 질문 입니다 ");
		}

	}

	public void delete() throws ExistedAnotherUserException{
		List<Answer> answers = answerDao.findAllByQuestionId(question.getQuestionId());
		if (isAnotherWriter(answers)) {
			throw new ExistedAnotherUserException("다른 사용자가 추가한 댓글이 존재해 삭제할 수 없습니다.");
		}
		answerDao.deleteAll(question.getQuestionId());
		questionDao.delete(question.getQuestionId());

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
	public Object getAnswers(){
		return  answerDao.findAllByQuestionId(question.getQuestionId());
	}

}
