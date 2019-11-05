package com.cg.service;

import com.cg.dto.CafeMenu;

public interface CafeMenuService {
CafeMenu addCafeMenu(CafeMenu menu);
CafeMenu getById(int menuId);
CafeMenu getByItemName(String itemName);

}
