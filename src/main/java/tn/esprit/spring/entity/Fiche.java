package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String question2;
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
	@Column(name="Question9")
	private String question9;
	@Column(name="Question10")
	private String question10;
	@Column(name="Question11")
	private String question11;
	@Column(name="Question12")
	private String question12;
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
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
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
	public String getQuestion9() {
		return question9;
	}
	public void setQuestion9(String question9) {
		this.question9 = question9;
	}
	public String getQuestion10() {
		return question10;
	}
	public void setQuestion10(String question10) {
		this.question10 = question10;
	}
	public String getQuestion11() {
		return question11;
	}
	public void setQuestion11(String question11) {
		this.question11 = question11;
	}
	public String getQuestion12() {
		return question12;
	}
	public void setQuestion12(String question12) {
		this.question12 = question12;
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
	@Override
	public String toString() {
		return "Fiche [id=" + id + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3
				+ ", question4=" + question4 + ", question5=" + question5 + ", question6=" + question6 + ", question7="
				+ question7 + ", question8=" + question8 + ", question9=" + question9 + ", question10=" + question10
				+ ", question11=" + question11 + ", question12=" + question12 + ", proposition=" + proposition
				+ ", user=" + user + "]";
	}
	public Fiche(Long id, Boolean question1, String question2, String question3, String question4, String question5,
			String question6, String question7, String question8, String question9, String question10,
			String question11, String question12, String proposition, User user) {
		super();
		this.id = id;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
		this.question10 = question10;
		this.question11 = question11;
		this.question12 = question12;
		this.proposition = proposition;
		this.user = user;
	}
	
	
}
