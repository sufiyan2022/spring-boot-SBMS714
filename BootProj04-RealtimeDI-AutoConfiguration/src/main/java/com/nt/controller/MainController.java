package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	@Autowired
	EmployeeMgmtServiceImpl service;
	
	public List<EmployeeVO> showEmpsByDesgs(String desgs[]) throws Exception{
//		Use service
		List<EmployeeDTO> listDTO=service.fetchEmpsByDesgs(desgs);
//		Convert listDTO to listVO
		List<EmployeeVO> listVO=new ArrayList();
		listDTO.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()))  ; //Integet to String use valueOf();
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			listVO.add(vo);
		});
		
		return listVO;
	}
}
