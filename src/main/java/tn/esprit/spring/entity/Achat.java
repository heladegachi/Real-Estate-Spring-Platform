package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name= "Achat")
public class Achat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date datedachat;
	@Column 
	private String history;
	@Column 
	@Enumerated(EnumType.STRING)
	Payementmode Payementmode;
	
	@Column 
	@Enumerated(EnumType.STRING)
	Payementperiode Payementperiode;
	@Column 
	private String Remarque;
	@Column 
	private String RecomendationLetter;
	
	@ManyToOne
	private Annonce annonce;
	
	@ManyToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Date getDatedachat() {
		return datedachat;
	}
	public void setDatedachat(Date datedachat) {
		this.datedachat = datedachat;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	public String getRemarque() {
		return Remarque;
	}
	public void setRemarque(String remarque) {
		Remarque = remarque;
	}
	public String getRecomendationLetter() {
		return RecomendationLetter;
	}
	public void setRecomendationLetter(String recomendationLetter) {
		RecomendationLetter = recomendationLetter;
	}
	public Payementmode getPayementmode() {
		return Payementmode;
	}
	public void setPayementmode(Payementmode payementmode) {
		Payementmode = payementmode;
	}
	public Payementperiode getPayementperiode() {
		return Payementperiode;
	}
	public void setPayementperiode(Payementperiode payementperiode) {
		Payementperiode = payementperiode;
	}
	/**
	 * @param id
	 * @param datedachat
	 * @param history
	 * @param payementmode
	 * @param payementperiode
	 * @param remarque
	 * @param recomendationLetter
	 */
	public Achat(Long id, Date datedachat, String history, tn.esprit.spring.entity.Payementmode payementmode,
			tn.esprit.spring.entity.Payementperiode payementperiode, String remarque, String recomendationLetter) {
		super();
		this.id = id;
		this.datedachat = datedachat;
		this.history = history;
		Payementmode = payementmode;
		Payementperiode = payementperiode;
		Remarque = remarque;
		RecomendationLetter = recomendationLetter;
	}
	@Override
	public String toString() {
		return "Achat [id=" + id + ", datedachat=" + datedachat + ", history=" + history + ", Payementmode="
				+ Payementmode + ", Payementperiode=" + Payementperiode + ", Remarque=" + Remarque
				+ ", RecomendationLetter=" + RecomendationLetter + "]";
	}
	/**
	 * @param datedachat
	 * @param history
	 * @param payementmode
	 * @param payementperiode
	 * @param remarque
	 * @param recomendationLetter
	 */
	public Achat(Date datedachat, String history, tn.esprit.spring.entity.Payementmode payementmode,
			tn.esprit.spring.entity.Payementperiode payementperiode, String remarque, String recomendationLetter) {
		super();
		this.datedachat = datedachat;
		this.history = history;
		Payementmode = payementmode;
		Payementperiode = payementperiode;
		Remarque = remarque;
		RecomendationLetter = recomendationLetter;
	}
	/**
	 * 
	 */
	public Achat() {
		super();
	}
	
	
//	@Override
//	public String toString() {
//		return "Achat [id=" + id + ", datedachat=" + datedachat + ", history=" + history + ", Payementmode="
//				+ Payementmode + ", Remarque=" + Remarque + ", RecomendationLetter=" + RecomendationLetter + "]";
//	}
//	/**
//	 * @param id
//	 * @param datedachat
//	 * @param history
//	 * @param payementmode
//	 * @param remarque
//	 * @param recomendationLetter
//	 */
//	public Achat(Long id, Date datedachat, String history, tn.esprit.spring.entity.Payementmode payementmode,
//			String remarque, String recomendationLetter) {
//		super();
//		this.id = id;
//		this.datedachat = datedachat;
//		this.history = history;
//		Payementmode = payementmode;
//		Remarque = remarque;
//		RecomendationLetter = recomendationLetter;
//	}
//	/**
//	 * @param datedachat
//	 * @param history
//	 * @param payementmode
//	 * @param remarque
//	 * @param recomendationLetter
//	 */
//	public Achat(Date datedachat, String history, tn.esprit.spring.entity.Payementmode payementmode, String remarque,
//			String recomendationLetter) {
//		super();
//		this.datedachat = datedachat;
//		this.history = history;
//		Payementmode = payementmode;
//		Remarque = remarque;
//		RecomendationLetter = recomendationLetter;
//	}
//	/**
//	 * 
//	 */
//	public Achat() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((Payementmode == null) ? 0 : Payementmode.hashCode());
//		result = prime * result + ((RecomendationLetter == null) ? 0 : RecomendationLetter.hashCode());
//		result = prime * result + ((Remarque == null) ? 0 : Remarque.hashCode());
//		result = prime * result + ((datedachat == null) ? 0 : datedachat.hashCode());
//		result = prime * result + ((history == null) ? 0 : history.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Achat other = (Achat) obj;
//		if (Payementmode != other.Payementmode)
//			return false;
//		if (RecomendationLetter == null) {
//			if (other.RecomendationLetter != null)
//				return false;
//		} else if (!RecomendationLetter.equals(other.RecomendationLetter))
//			return false;
//		if (Remarque == null) {
//			if (other.Remarque != null)
//				return false;
//		} else if (!Remarque.equals(other.Remarque))
//			return false;
//		if (datedachat == null) {
//			if (other.datedachat != null)
//				return false;
//		} else if (!datedachat.equals(other.datedachat))
//			return false;
//		if (history == null) {
//			if (other.history != null)
//				return false;
//		} else if (!history.equals(other.history))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
	
	
}
