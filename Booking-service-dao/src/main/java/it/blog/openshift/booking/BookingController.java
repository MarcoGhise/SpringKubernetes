package it.blog.openshift.booking;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired
    private BookingRepository repository;

	private static final Log logger = LogFactory.getLog(BookingController.class);
	
	@RequestMapping("/list")
    public List<Booking> getBooking(@RequestHeader("x-request-id") String xreq,
			  @RequestHeader("x-b3-traceid") String xtraceid,
			  @RequestHeader("x-b3-spanid") String xspanid,
			  @RequestHeader("x-b3-sampled") String xsampled){
		
	logger.info("Get Bookings");
	
	logger.info("x-request-id:" + xreq);
	logger.info("x-b3-traceid:" + xtraceid);
	logger.info("x-b3-spanid:" + xspanid);
	logger.info("x-b3-sampled:" + xsampled);
		
        return repository.findAll();
    }

   	@RequestMapping(method = RequestMethod.POST, path="/add")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking){
    	
		
	logger.info("Add booking:" + booking.getCode());
		
        repository.save(booking);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
