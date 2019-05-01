package epita.fr.datamodels;
 import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import epita.fr.Answer;
import epita.fr.Question;

public class QuestionModel {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	@SuppressWarnings("unchecked")
	public List<Question> findAll(){
		List<Question>questions=null;
		Session session=null;
		Transaction transcation=null;
	
		
		try {
			session=sessionFactory.openSession();
			transcation =session.beginTransaction();
			questions=session.createQuery("from Question").getResultList();
			transcation.commit();
	}
		catch(Exception e) {
			if(transcation!=null) {
				transcation.rollback();
			}
			questions=null;
		}finally {
		session.close();
		}
		return questions;
	}
	public Question find (int questionId) {
		Question question=null;
		Session session=null;
		Transaction transcation=null;
	
		
		try {
			session=sessionFactory.openSession();
			transcation =session.beginTransaction();
			question=(Question) session.createQuery("from Question where id=:id")
					.setParameter("id",questionId)
					.getSingleResult();
			transcation.commit();
	}
		catch(Exception e) {
			if(transcation!=null) {
				transcation.rollback();
			}
			question=null;
		}finally {
		session.close();
		}
		return question;
}
	public int findAnswerIdCorrect(int questionId) {
		Question question= this.find(questionId);
		for(Answer answer : question.getAnswers()) {
			if(answer.isCorrect()) {
				return answer.getId();
			}
		}
		return -1;
	}
}
 