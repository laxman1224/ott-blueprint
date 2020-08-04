package com.soct.ott.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.soct.ott.api.entities.User;

@Repository
//@RepositoryRestResource(exported = false)
public interface UserRepository extends PagingAndSortingRepository<User, String>{

	User findByEmail(String email);
	
	User findByUserId(String userId);
}
