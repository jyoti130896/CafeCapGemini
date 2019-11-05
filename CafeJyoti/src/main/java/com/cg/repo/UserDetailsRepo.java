package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.UserDetails;

public interface UserDetailsRepo extends JpaRepository <UserDetails,Integer> {

}
