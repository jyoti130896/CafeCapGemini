package com.cg.service;

import com.cg.dto.UserDetails;

public interface UserDetailService {
	UserDetails addNewUser(UserDetails user);
	UserDetails getById(int userId);
}
