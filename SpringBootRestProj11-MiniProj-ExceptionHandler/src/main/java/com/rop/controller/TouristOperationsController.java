package com.rop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.entity.Tourist;
import com.rop.repo.ITouristRepo;
import com.rop.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist") //optional but recommended
public class TouristOperationsController {
	
	@Autowired
	private ITouristMgmtService touristService;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)throws Exception{
//		try {
////			use service
//			String resultMsg=touristService.registerTourist(tourist);
//			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED); //201 content created successfully
//		}catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Problem in Tourist Enrollment", HttpStatus.INTERNAL_SERVER_ERROR); //500 error
//		}
		String resultMsg=touristService.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED); //201 content created successfully
	}
	
		@GetMapping("/findAll")
		public ResponseEntity<?> displayTourist(){
//			try {
//				List<Tourist>list= touristService.fetchAllTourists();
//				return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
//			}catch(Exception e) {
//				e.printStackTrace();
//				return new ResponseEntity<String>("Problem in fetching Tourist",HttpStatus.INTERNAL_SERVER_ERROR); //500 error
//			}
			List<Tourist>list= touristService.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		}
		
		@GetMapping("/find/{id}")
		public ResponseEntity<Object> displayTouristById(@PathVariable("id")Integer id) throws Exception{
//			try {
//				Tourist tou= touristService.fetchTouristById(id);
//				return new ResponseEntity<Object>(tou,HttpStatus.OK);
//			}catch(Exception e) {
//				e.printStackTrace();
//				return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); //500 error
//			}
			Tourist tou= touristService.fetchTouristById(id);
			return new ResponseEntity<Object>(tou,HttpStatus.OK);
		}
		
			@PutMapping("/modify")
			public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) throws Exception{
//				try {
//					String msg=touristService.updateTouristDetails(tourist);
//					return new ResponseEntity<String>(msg, HttpStatus.OK);
//				}catch(Exception e) {
//					e.printStackTrace();
//					return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//				}
				String msg=touristService.updateTouristDetails(tourist);
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id ) throws Exception{
//				try {
//					//use service
//					String msg=touristService.deleteTourist(id);
//					return new ResponseEntity<String>(msg, HttpStatus.OK);
//				}catch(Exception e) {
//					e.printStackTrace();
//					return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//				}
				//use service
				String msg=touristService.deleteTourist(id);
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
			
			@PatchMapping("/budgetUpdate/{id}/{hike}")
			public ResponseEntity<String> ModifyTouristBudgetById(@PathVariable("id")Integer id,@PathVariable("hike")Float hikePercentage)throws Exception{
//				try {
//					//use serivce
//					String msg=touristService.updateTouristBudgetById(id, hikePercentage);
//					return new ResponseEntity<String>(msg,HttpStatus.OK);
//				}catch(Exception e) {
//					e.printStackTrace();
//					return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//				}
				//use serivce
				String msg=touristService.updateTouristBudgetById(id, hikePercentage);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			}
}
