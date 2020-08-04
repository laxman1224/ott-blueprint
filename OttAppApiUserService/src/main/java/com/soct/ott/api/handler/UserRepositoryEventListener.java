package com.soct.ott.api.handler;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.soct.ott.api.entities.User;

public class UserRepositoryEventListener {

	@PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(User user) {
		System.out.println("[USER AUDIT] About to update/delete user: " + user.getId());
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(User user) {
    	System.out.println("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }
    
    @PostLoad
    private void afterLoad(User user) {
    	System.out.println("[USER AUDIT] user loaded from database: " + user.getId());
    }

}
