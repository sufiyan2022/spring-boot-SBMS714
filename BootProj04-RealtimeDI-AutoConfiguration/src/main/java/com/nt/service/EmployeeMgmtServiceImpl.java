package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeDAO dao;
	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desg) throws Exception {
//		String cond=null;
//		Convert desgs[] into SQL IN clouse String condition ('CLERK','MANAGER','SALESMAN')
		
//		StringBuffer buffer=new StringBuffer("("); // this is synchronize
		StringBuilder builder=new StringBuilder("(");
		for(int i=0;i<desg.length;i++) {
			if(i==desg.length-1)   // for the last element of the array
				builder.append("'"+desg[i]+"')");
			else
				builder.append("'"+desg[i]+"',");
		}
		
//		Convert StringBuilder obj to String
		String cond=builder.toString();
//		use DAO
		List<EmployeeBO>listBO= dao.getEmpsByDesg(cond);
		
//		Convert listBO to listDTO
		List<EmployeeDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
//			Copy each BO class obj to each DTO class object
			BeanUtils.copyProperties(bo, dto); //property names and type must match in both java beans.
			dto.setSrNo(listDTO.size()+1);
//			add each obj of DTO class to listDTO
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}
