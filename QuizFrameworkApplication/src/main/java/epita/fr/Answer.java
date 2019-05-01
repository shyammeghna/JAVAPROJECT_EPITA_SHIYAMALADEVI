package epita.fr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="answer")

public class Answer implements java.io.Serializable{

	private static final long serialVersionUID =1L;
	private Integer id;
	private Question question;
	private String content;
	private boolean correct;
	
	public Answer() {
		
	}
	public Answer(Question question,String content,boolean correct) {
		this.question=question;
		this.content=content;
		this.correct=correct;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id",nullable=false)
	public Question getQuestion() {
		return this.question;
	}
	public void setQuestion(Question question) {
		this.question=question;
	}
	
	@Column(name ="content",nullable=false,length=65535)
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content=content;
	}
	@Column(name ="correct",nullable=false)
	public boolean isCorrect() {
		return this.correct;
	}
	public void setCorrect(boolean correct) {
		this.correct=correct;
	}
}

