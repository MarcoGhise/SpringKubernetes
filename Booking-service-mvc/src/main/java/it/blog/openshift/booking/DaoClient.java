package it.blog.openshift.booking;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="dao-service",url="${dao-service.url}")
public interface DaoClient {
	
	  @RequestMapping(method = RequestMethod.GET, value = "/list")
	  List<Booking> getBooking(@RequestHeader("x-request-id") String xreq,
			  @RequestHeader("x-b3-traceid") String xtraceid,
			  @RequestHeader("x-b3-spanid") String xspanid,
			  @RequestHeader("x-b3-sampled") String xsampled);
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/add")
	  ResponseEntity<String> addBooking(Booking booking);
}