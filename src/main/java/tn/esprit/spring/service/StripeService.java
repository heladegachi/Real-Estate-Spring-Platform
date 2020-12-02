package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.stripe.model.PaymentIntent;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.ChargeRequest;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AssuranceRepository;
import tn.esprit.spring.repository.SubscriptionRepository;
import tn.esprit.spring.repository.SurveillanceRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class StripeService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SurveillanceRepository surveillancerepo;
	@Autowired
	AssuranceRepository assurancerepo;
	@Autowired
	SubscriptionRepository subrepo;
	
	public AssuranceRepository getAssurancerepo() {
		return assurancerepo;
	}



	public void setAssurancerepo(AssuranceRepository assurancerepo) {
		this.assurancerepo = assurancerepo;
	}



	public SubscriptionRepository getSubrepo() {
		return subrepo;
	}



	public void setSubrepo(SubscriptionRepository subrepo) {
		this.subrepo = subrepo;
	}



	public UserRepository getUserRepository() {
		return userRepository;
	}



	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	public SurveillanceRepository getSurveillancerepo() {
		return surveillancerepo;
	}



	public void setSurveillancerepo(SurveillanceRepository surveillancerepo) {
		this.surveillancerepo = surveillancerepo;
	}



	public String getSecretKey() {
		return secretKey;
	}



	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	//@Value("${STRIPE_SECRET_KEY}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}
	
	
	
	public String createStripeCustomer(int idUser) {
		
		// stripe key
		Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";

		User user = userRepository.findById((long) idUser).get();
		Map<String, Object> params = new HashMap<>();
		params.put("description", "My First Test Customer (created for API docs)");
		params.put("email", user.getEmail());

		// affichage id du customer
		try {
			Customer customer = Customer.create(params);

			System.out.println("create customer id: {}");
			return customer.getId();
		} catch (StripeException e) {

			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub
//		return null;
	}

	
	public String createCustumorStripe(String customerId, String carta, String expMonth, String expYear, String cvc)
			throws StripeException {
		// TODO Auto-generated method stub
		//return null;
		// stripe key
		Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";

		Customer customer = Customer.retrieve(customerId);

		Map<String, Object> cardParam = new HashMap<String, Object>();
		cardParam.put("number", carta);
		cardParam.put("exp_month", expMonth);
		cardParam.put("exp_year", expYear);
		cardParam.put("cvc", cvc);

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam);

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId());

		customer.getSources().create(source);
		return token.getId();
	}

	
	public String paymentIntent(ChargeRequest chargerequest)throws StripeException{
		// TODO Auto-generated method stub
		//return null;
		// stripe key
		Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";

		// `source` is obtained with Stripe.js; see
		// https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
		List<String> paymentMethodTypes = new ArrayList();
		paymentMethodTypes.add("card");
		
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount",chargerequest.getAmount());
		params.put("currency", chargerequest.getCurrency());
		params.put("description", chargerequest.getDescription());
		params.put("payment_method_types", paymentMethodTypes);
		
		PaymentIntent p = PaymentIntent.create(params);
		p.getId();
		//Charge charge = Charge.create(params);
		return p.getId();
	}
	
	
	
	/*
	 * this methode is to confirm that your customer intends to pay with current
	 * or provided payment method. Upon confirmation, the PaymentIntent will
	 * attempt to initiate a payment
	 */
	public PaymentIntent confirm(String id) throws StripeException {
		Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";
		PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
		Map<String, Object> params = new HashMap<>();
		params.put("payment_method", "pm_card_visa");
		// params.put("customer", "cus_H1OvsnwEn1KX36");
		paymentIntent.confirm(params);
		return paymentIntent;
	}
	@Transactional
	public void PaySurveillance(long idSurveil,String carta, int expMonth, int expYear, String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
		Surveillance order =surveillancerepo.getSubById1(idSurveil);
		
			if(order.getPrix()!=0){
				Map<String, Object> params = new HashMap<>();
		        Map<String, Object> tokenParams = new HashMap<>();
		        Map<String, Object> cardParams = new HashMap<>();
		        Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";
		        cardParams.put("number", carta);
		        cardParams.put("exp_month", expMonth);
		        cardParams.put("exp_year", expYear);
		        cardParams.put("cvc", cvc);
		        int nMontant= (int) Math.floor(order.getPrix());
		        tokenParams.put("card", cardParams);
		        Token token =Token.create(tokenParams);
		      //  System.out.println(token.getCard().getId());
		        if (token.getId()!=null){
		        params.put("amount", nMontant);
		        params.put("description", "test de stipe");
		        params.put("currency", "eur");
		        params.put("source", token.getId());
		        Charge charge = Charge.create(params);
		        order.setPrix(null);
		        }
		        
		        }
		
		
			
	}
	@Transactional
	public void PayAssurance(long idSurveil,String carta, int expMonth, int expYear, String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
		Assurance order =assurancerepo.getSubById1(idSurveil);
		
			if(order.getPrix()!=0){
				Map<String, Object> params = new HashMap<>();
		        Map<String, Object> tokenParams = new HashMap<>();
		        Map<String, Object> cardParams = new HashMap<>();
		        Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";
		        cardParams.put("number", carta);
		        cardParams.put("exp_month", expMonth);
		        cardParams.put("exp_year", expYear);
		        cardParams.put("cvc", cvc);
		        int nMontant= (int) Math.floor(order.getPrix());
		        tokenParams.put("card", cardParams);
		        Token token =Token.create(tokenParams);
		      //  System.out.println(token.getCard().getId());
		        if (token.getId()!=null){
		        params.put("amount", nMontant);
		        params.put("description", "test de stipe");
		        params.put("currency", "eur");
		        params.put("source", token.getId());
		        Charge charge = Charge.create(params);
		        order.setPrix(null);
		        }
		        
		        }}
	@Transactional
	public void PayPublication(long idSurveil,String carta, int expMonth, int expYear, String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
		Subscription order =subrepo.getSubById1(idSurveil);
		
			if(order.getPrix()!=0){
				Map<String, Object> params = new HashMap<>();
		        Map<String, Object> tokenParams = new HashMap<>();
		        Map<String, Object> cardParams = new HashMap<>();
		        Stripe.apiKey = "sk_test_EuGQtEoAyYzRXgpQ9n4hexDx00WGQOuC9d";
		        cardParams.put("number", carta);
		        cardParams.put("exp_month", expMonth);
		        cardParams.put("exp_year", expYear);
		        cardParams.put("cvc", cvc);
		        int nMontant= (int) Math.floor(order.getPrix());
		        tokenParams.put("card", cardParams);
		        Token token =Token.create(tokenParams);
		      //  System.out.println(token.getCard().getId());
		        if (token.getId()!=null){
		        params.put("amount", nMontant);
		        params.put("description", "test de stipe");
		        params.put("currency", "eur");
		        params.put("source", token.getId());
		        Charge charge = Charge.create(params);
		        order.setPrix(null);
		        }
		        
		        }}
	
}
