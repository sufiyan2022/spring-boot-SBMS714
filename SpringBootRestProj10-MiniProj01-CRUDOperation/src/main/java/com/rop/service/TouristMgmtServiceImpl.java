package com.rop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rop.entity.Tourist;
import com.rop.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		int id=touristRepo.save(tourist).getTid();
		return "Tourist is registered with id :"+id;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTouristDetails(Tourist tourist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTourist(Integer tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePercent) {
		// TODO Auto-generated method stub
		return null;
	}

}
