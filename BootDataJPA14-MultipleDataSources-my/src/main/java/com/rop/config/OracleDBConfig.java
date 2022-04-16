package com.rop.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.rop.repo.prod",
											entityManagerFactoryRef = "oracleEMF",
											transactionManagerRef = "oracleTxMgnr")
public class OracleDBConfig {

	/*
	 * creating configuration class for two different db s/w having
	 * 
	 * @Bean methods creating DataSource, EntityManagerFactory, TransactionManager
	 * object
	 */

	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
	public DataSource createOracleDs() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oracleEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
//		create Map object having hibernate properties
		Map<String, Object> props = new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
//		create and ruturn LocalContainerEntityManagerFactoryBean class object which makes
//		EntityManagerFactory as the spring bean
		return builder.dataSource(createOracleDs()).packages("com.rop.model.prod").properties(props).build();
	}

	@Bean(name = "oracleTxMgnr")
	@Primary
	public PlatformTransactionManager createOracleTxMgr(@Qualifier("oracleEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
