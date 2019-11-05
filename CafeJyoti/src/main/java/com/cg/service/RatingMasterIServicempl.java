package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.RatingMaster;
import com.cg.repo.RatingMasterRepo;
@Service
@Transactional
public class RatingMasterIServicempl implements RatingMasterService{
	@Autowired
	RatingMasterRepo repo;
	@Override
	public RatingMaster addRatingMaster(RatingMaster master) {
		return repo.save(master);
	}
	@Override
	public boolean deleteRatingMaster(RatingMaster master) {
		repo.delete(master);
		return true;
	}

}
