package com.rop.service;

import java.util.List;

import com.rop.entity.Tourist;
import com.rop.exception.TouristNotFoundException;

public interface ITouristMgmtService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	public String deleteTourist(Integer tid);
	public String updateTouristBudgetById(Integer id, Float hikePercent);

}
