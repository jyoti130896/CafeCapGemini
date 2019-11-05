package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.dto.RatingMaster;


public interface RatingMasterRepo extends JpaRepository <RatingMaster, Integer>{
	
}
