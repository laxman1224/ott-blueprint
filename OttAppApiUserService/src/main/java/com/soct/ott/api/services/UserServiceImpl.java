package com.soct.ott.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soct.ott.api.dtos.UserDto;
import com.soct.ott.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	// @Autowired
	// private PaymentsServiceClient paymentsServiceClient;

	@Override
	public com.soct.ott.api.entities.User save(com.soct.ott.api.entities.User user) {
		com.soct.ott.api.entities.User userEntity = this.userRepository.save(user);
		// paymentsServiceClient.save(userEntity.getId());
		return userEntity;
	}

	@Override
	public List<com.soct.ott.api.entities.User> all() {
		Iterable<com.soct.ott.api.entities.User> iterable = this.userRepository.findAll();
		List<com.soct.ott.api.entities.User> target = new ArrayList<>();
		iterable.forEach(target::add);
		return target;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.soct.ott.api.entities.User userEntity = this.userRepository.findByEmail(username);
		if (userEntity == null)
			throw new UsernameNotFoundException(username);

		return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public com.soct.ott.api.entities.User getUserDetailsByEmail(String email) {
		com.soct.ott.api.entities.User userEntity = this.userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return userEntity;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		com.soct.ott.api.entities.User userEntity = this.userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

		/*
		 * // using rest template String paymentUrl =
		 * String.format(this.env.getProperty("payments.url"), userId);
		 * 
		 * HttpHeaders headers = new HttpHeaders(); headers.setAccept(new
		 * ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
		 * 
		 * HttpEntity<List<PaymentEntity>> entity = new HttpEntity<>(headers);
		 * ResponseEntity<List<PaymentEntity>> paymentsListResponse =
		 * restTemplate.exchange(paymentUrl, HttpMethod.GET, entity, new
		 * ParameterizedTypeReference<List<PaymentEntity>>() {}); List<PaymentEntity>
		 * paymentsList = paymentsListResponse.getBody();
		 */

		// List<PaymentEntity> paymentsList = paymentsServiceClient.getPayments(userId);

		// userDto.setPayments(paymentsList);

		return userDto;
	}

}
