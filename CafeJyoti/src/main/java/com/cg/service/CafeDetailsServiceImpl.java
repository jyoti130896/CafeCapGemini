package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CafeDetails;
import com.cg.repo.CafeDetailsRepo;
@Service
@Transactional
public class CafeDetailsServiceImpl implements CafeDetailsService{
@Autowired
private CafeDetailsRepo repo;
	@Override
	public CafeDetails addNewCafe(CafeDetails cafe) {
		return repo.save(cafe);
	}
	@Override
	public CafeDetails getById(int cafeId) {
		return repo.findById(cafeId).get();
	}
	@Override
		public CafeDetails getByCafeLocation(String cafeLocation) {
			return repo.getByCafeLocation(cafeLocation);
		}

}
