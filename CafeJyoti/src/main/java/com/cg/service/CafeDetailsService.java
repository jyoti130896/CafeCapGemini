package com.cg.service;

import com.cg.dto.CafeDetails;

public interface CafeDetailsService {
CafeDetails addNewCafe(CafeDetails cafe);
CafeDetails getById(int cafeId);
CafeDetails getByCafeLocation(String cafeLocation);
}
