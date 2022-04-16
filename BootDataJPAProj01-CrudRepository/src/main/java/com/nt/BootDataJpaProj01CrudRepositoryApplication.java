package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class BootDataJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
//		Get Access to IOC Container
		ApplicationContext ctx=SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);
//		Get Service class Object
		ICoronaVaccineMgmtService service=ctx.getBean("vaccineMgmtService",ICoronaVaccineMgmtService.class);
//		invoke methods
		try {
//			create Entity class Object
			CoronaVaccine vaccine=new CoronaVaccine(null, "covaxin", "Bharat-BioTech", "india", 900.3, 3);
//			call business method
			System.out.println(service.registerVaccine(vaccine));
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		close container
		((ConfigurableApplicationContext) ctx).close();
	}
}
