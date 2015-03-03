package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.DaoFactory;
import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class DeleteQuestionController extends AbstractController {

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mid = "";
		long qid = 1;
		ModelAndView mav = jsonView();
		
		
		QuestionDao qDao = DaoFactory.getQuestionDao();
		AnswerDao aDao = DaoFactory.getAnswerDao();
		Result result = delete(qid, mid, qDao, aDao);
		result.addErrorMessage(mav);
		// 클라이언트에서 errorMessage가 있을경우 실패로 간주. 없으면 성
		return mav;
	}

	public Result delete(long questionId, String memberId, QuestionDao qDao, AnswerDao aDao) {
		
		Question question = qDao.findById(questionId);

		if (!question.hasDeleteRight(memberId, aDao))
			return new Result(false, "권한이 없습니다.");

		qDao.delete(questionId);
		return new Result(true);
	}

}
