package tn.esprit.spring.control;
//import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
*/
@RestController
@RequestMapping("/")
public class PaymentController {
	public static final String PAYPAL_SUCCESS_URL = "pay/success";
	public static final String PAYPAL_CANCEL_URL = "pay/cancel";
	
//	private Logger log = LoggerFactory.getLogger(getClass());
//	
//	@Autowired
//	private PaypalService paypalService;
	
	//@RequestMapping(method = RequestMethod.GET)
/*	public String index(){
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/pay")
	public String pay(HttpServletRequest request){
		String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
		String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
		try {
			Payment payment = paypalService.createPayment(
					4.00, 
					"USD", 
					PaypalPaymentMethod.paypal, 
					PaypalPaymentIntent.sale,
					"payment description", 
					cancelUrl, 
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
	public String cancelPay(){
		return "cancel";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "success";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}*/
}
