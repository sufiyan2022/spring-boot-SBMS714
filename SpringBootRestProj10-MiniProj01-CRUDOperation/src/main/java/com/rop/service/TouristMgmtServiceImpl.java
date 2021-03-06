package com.rop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rop.entity.Tourist;
import com.rop.exception.TouristNotFoundException;
import com.rop.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int id = touristRepo.save(tourist).getTid();
		return "Tourist is registered with id :" + id;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		Tourist tou = touristRepo.findById(tid)
				.orElseThrow(() -> new TouristNotFoundException(tid + " tourist not found"));
		return tou;
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tourist.getTid());
		if (opt.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid() + " Tourist is Updated";
		} else {
			throw new TouristNotFoundException(tourist.getTid() + " Tourist Not Found");
		}

	}

	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tid);
		if (opt.isPresent()) {
			touristRepo.deleteById(tid);
			return tid + " Tourist is deleted.";
		}
		throw new TouristNotFoundException(tid + " Tourist not found.");
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePercent) throws TouristNotFoundException {
		Optional<Tourist>opt= touristRepo.findById(id);
		if(opt.isPresent()) {
		   Tourist tourist=opt.get();
		   tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hikePercent/100));
		   touristRepo.save(tourist);
		   return "Tourist budget is Updated.";
		}else
		throw new TouristNotFoundException(id+ " Tourist not Found.");
	}

}
