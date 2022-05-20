package com.rop.service;

import java.util.List;

import com.rop.entity.Tourist;

public interface ITouristMgmtService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTouristById(Integer tid);// throws TouristNotFoundEx
	public String updateTouristDetails(Tourist tourist);
	public String deleteTourist(Integer tid);
	public String updateTouristBudgetById(Integer id, Float hikePercent);

}
