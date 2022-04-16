package com.nt;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
public class BootProj04RealtimeDiAutoConfigurationApplication {

	public static void main(String[] args) {
//		reads input from endUser
		Scanner sc=new Scanner(System.in);
		System.out.println("Desgs Count::");
		int count=sc.nextInt();
		String desgs[]=null;
		if(count>=1)
			desgs=new String[count];
		else {
			System.out.println("Invalid desig count");
//			System.exit(0);
			return;
		}
		
//		read desg from end user
		for(int i=0;i<count;i++) {
			System.out.println("Enter desg "+(i+1));
			String desg=sc.next();     
			desgs[i]=desg;   // at the end we are array of desg
		}
//		get IOC Container
		ApplicationContext ctx =SpringApplication.run(BootProj04RealtimeDiAutoConfigurationApplication.class, args);
//		get Controller class object
		MainController controller=ctx.getBean("controller",MainController.class);
//		invoke business method
		try {
			List<EmployeeVO> listVO=controller.showEmpsByDesgs(desgs);
			System.out.println("Emp details having "+Arrays.toString(desgs));//Arrays is converting to String
			listVO.forEach(vo->{
				System.out.println(vo);
			});
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Some internal problem :"+e.getMessage());
//			close IOC Container
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
