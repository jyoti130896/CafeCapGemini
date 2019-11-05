package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.UserDetails;
import com.cg.repo.UserDetailsRepo;
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailsRepo repo;
	
	@Override
	public UserDetails addNewUser(UserDetails user) {
		return repo.save(user);
	}

	@Override
	public UserDetails getById(int userId) {
		return repo.findById(userId).get();
	}

}
