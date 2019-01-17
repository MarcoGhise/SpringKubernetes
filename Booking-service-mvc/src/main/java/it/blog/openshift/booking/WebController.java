package it.blog.openshift.booking;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebController {

	private static final Log logger = LogFactory.getLog(WebController.class);
	
	@Autowired
	private DaoClient client;

	@Value("${dao-service.random.exception}")
	private double exceptionNumber;
	
	@Value("${dao-service.random.max}")
	private double maxNumber;
	
	@Value("${dao-service.random.min}")
	private double minNumber;
	
	@RequestMapping("/")
	public ModelAndView welcome(Model model) throws Exception {

		double generateNumber = getRandomIntegerBetweenRange(minNumber, maxNumber);
		
		logger.info(String.format("Start Request for welcome v1.6 - Number:%s", generateNumber));
		
		if (exceptionNumber == generateNumber)
			throw new Exception("Fake exception raised");		
		
		model.addAttribute("booking", new Booking());

		return new ModelAndView("home");
	}
	
	@RequestMapping("/bookings")
	public ModelAndView getBooking() {
		
		logger.info("Start Request for Bookings");
		
		List<Booking> books = client.getBooking();	
		
		logger.info("Getting bookings:" + books.size());
		
		ModelAndView model = new ModelAndView("list");
		model.addObject("bookings", books);
		return model;
				
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public ModelAndView addBooking(@ModelAttribute Booking booking) {
		
		logger.info("Add booking:" + booking.getCode());
		
		ResponseEntity<?> response = client.addBooking(booking);
		
		logger.info("Response:" + response.getStatusCodeValue());
				
		return new ModelAndView("redirect:/");
				
	}	
	
	public static double getRandomIntegerBetweenRange(double min, double max){

	    double x = (int)(Math.random()*((max-min)+1))+min;

	    return x;

	}

}
