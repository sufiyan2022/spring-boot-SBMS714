package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DESG="select EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN";
	@Autowired
	private DataSource ds;  //  (jdbc Templates gets datasource object through constructor process, JdbcTemplate template=new JdbcTemplate(dataSource))

	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		System.out.println("DataSource Object class Name: "+ds.getClass());
		List<EmployeeBO> listBO=null;
		try(
//				get pool jdbc connection
				Connection con=ds.getConnection();
				Statement st=con.createStatement(); //PreparedStatement can not be used here bcoz no of desg is dynamic here.
				) {
//			send and execute SQL Query in DB software
//			select empno,ename,job,sal,deptno,mgr from emp where job in('CLERK','MANAGER') order by job(this is query) 
			ResultSet rs=st.executeQuery(GET_EMPS_BY_DESG+cond+"ORDER BY JOB");
//			Convert RS object records to List of BO class obj;
			listBO=new ArrayList();
			EmployeeBO bo=null;
			while(rs.next()) {
//				copy each record of RS to a obect of EmployeeBO class
				 bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getDouble(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				
//				add each object of EmployeeBO to List Collection
				listBO.add(bo);
			}
		}catch(SQLException se) {
		se.printStackTrace();
		throw se; // for exception propagation
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}

	
}
