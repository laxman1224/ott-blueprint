package com.soct.ott.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CMSRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(HttpServletRequest request, HttpSession session) {
		String loginUrl = "http://localhost:8765/users-ws/login";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
		
		JSONObject requestJson = new JSONObject();
		requestJson.put("email", request.getParameter("email"));
		requestJson.put("password", request.getParameter("password"));
		
		ResponseEntity<String> response = restTemplate.postForEntity(loginUrl, requestJson.toString(), String.class);
		HttpHeaders respHeaders = response.getHeaders();
		session.setAttribute("token", respHeaders.getFirst("token"));
		String userId = respHeaders.getFirst("userid");
		session.setAttribute("userId", userId);
		return ResponseEntity.status(response.getStatusCode()).headers(respHeaders).body(userId);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(HttpServletRequest request, HttpSession session) {
		String registerUrl = "http://localhost:8765/users-ws/users";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED)));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName", request.getParameter("firstName"));
		map.put("lastName", request.getParameter("lastName"));
		map.put("email", request.getParameter("email"));
		map.put("password", request.getParameter("password"));
		
		ResponseEntity<String> response = restTemplate.postForEntity(registerUrl, map, String.class);
		HttpHeaders respHeaders = response.getHeaders();
		session.setAttribute("token", respHeaders.getFirst("token"));
		String userId = respHeaders.getFirst("userid");
		session.setAttribute("userId", userId);
		return ResponseEntity.status(response.getStatusCode()).headers(respHeaders).body(userId);
	}
}
