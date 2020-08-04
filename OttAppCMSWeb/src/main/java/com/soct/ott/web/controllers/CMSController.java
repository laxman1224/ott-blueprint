package com.soct.ott.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.soct.ott.web.entities.MovieEntity;
import com.soct.ott.web.entities.MovieResultsEntity;
import com.soct.ott.web.entities.PaymentEntity;
import com.soct.ott.web.entities.SubscriptionEntity;
import com.soct.ott.web.entities.UserEntity;

@Controller
public class CMSController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping({ "/", "/home" })
	public String hello(Model model) {
		return "index";
	}

	@GetMapping(value= {"/movies", "/movies/pages/{pageId}"})
	public ModelAndView getMovieList(@PathVariable("pageId") Optional<Integer> pageId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("movies");
		return mv;
	}
	
	@GetMapping("/movies/{id}")
	public ModelAndView getMovieDetails(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("assetId", id);
		mv.setViewName("movie-details");
		return mv;
	}
	
	@GetMapping("/users")
	public ModelAndView getUsers(HttpSession session) {
		String usersListUrl = "http://localhost:8765/users-ws/users";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
		System.out.println("Token: "+session.getAttribute("token").toString());
		headers.setBearerAuth(session.getAttribute("token").toString());
		
		HttpEntity<List<UserEntity>> entity = new HttpEntity<>(headers);
		ResponseEntity<List<UserEntity>> usersListResponse = restTemplate.exchange(usersListUrl, HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<UserEntity>>() {
				});
		List<UserEntity> usersList = usersListResponse.getBody();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", usersList);
		mv.setViewName("users");
		return mv;
	}
	
	@GetMapping("/payments")
	public ModelAndView getPayments(HttpSession session) {
		String paymentsListUrl = "http://localhost:8765/payments-ws/users/16/payments";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
		headers.setBearerAuth(session.getAttribute("token").toString());
		
		HttpEntity<List<PaymentEntity>> entity = new HttpEntity<>(headers);
		ResponseEntity<List<PaymentEntity>> paymentsListResponse = restTemplate.exchange(paymentsListUrl, HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<PaymentEntity>>() {
				});
		List<PaymentEntity> paymentsList = paymentsListResponse.getBody();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("paymentsList", paymentsList);
		mv.setViewName("payments");
		return mv;
	}
	
	@GetMapping("/subscriptions")
	public ModelAndView getSubscriptions(HttpSession session) {
		String subscriptionsListUrl = "http://localhost:8765/payments-ws/subscriptions";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
		headers.setBearerAuth(session.getAttribute("token").toString());
		
		HttpEntity<List<SubscriptionEntity>> entity = new HttpEntity<>(headers);
		ResponseEntity<List<SubscriptionEntity>> subscriptionsListResponse = restTemplate.exchange(subscriptionsListUrl, HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<SubscriptionEntity>>() {
				});
		List<SubscriptionEntity> subscriptionsList = subscriptionsListResponse.getBody();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("subscriptionsList", subscriptionsList);
		mv.setViewName("subscriptions");
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("token");
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
