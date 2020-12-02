package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Fiche_de_satisfaction")
public class Fiche {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Satisfaction_ID")
	private Long id;
	@Column(name="Question1")
	private Boolean question1;
	@Column(name="Question2")
	@Enumerated(EnumType.STRING)
	Question2 question2;
	@Column(name="Question3")
	private String question3;
	@Column(name="Question4")
	private String question4;
	@Column(name="Question5")
	private String question5;
	@Column(name="Question6")
	private String question6;
	@Column(name="Question7")
	private String question7;
	@Column(name="Question8")
	private String question8;
	@Column(name="Proposition")
	private String proposition;
	@ManyToOne
	User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getQuestion1() {
		return question1;
	}
	public void setQuestion1(Boolean question1) {
		this.question1 = question1;
	}
	
	public Question2 getQuetion2() {
		return question2;
	}
	public void setQuetion2(Question2 quetion2) {
		this.question2 = quetion2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	public String getQuestion5() {
		return question5;
	}
	public void setQuestion5(String question5) {
		this.question5 = question5;
	}
	public String getQuestion6() {
		return question6;
	}
	public void setQuestion6(String question6) {
		this.question6 = question6;
	}
	public String getQuestion7() {
		return question7;
	}
	public void setQuestion7(String question7) {
		this.question7 = question7;
	}
	public String getQuestion8() {
		return question8;
	}
	public void setQuestion8(String question8) {
		this.question8 = question8;
	}
	
	public String getProposition() {
		return proposition;
	}
	public void setProposition(String proposition) {
		this.proposition = proposition;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Fiche( Boolean question1, Question2 question2, String question3, String question4, String question5,
			String question6, String question7, String question8, String proposition, User user) {
		super();
		
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.proposition = proposition;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Fiche [id=" + id + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3
				+ ", question4=" + question4 + ", question5=" + question5 + ", question6=" + question6 + ", question7="
				+ question7 + ", question8=" + question8 + ", proposition=" + proposition + ", user=" + user + "]";
	}
	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
