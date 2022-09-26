package com.renatol.seguranca.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "com.renatol.seguranca.model.global", entityManagerFactoryRef = "globalEMFactory")
public class GlobalDbConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "global.datasource")
	public DataSource globalDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean globalEMFactory(EntityManagerFactoryBuilder builder,	@Qualifier("globalDataSource") DataSource ds) {
		return builder.dataSource(ds).packages("com.renatol.seguranca.model.global").build();
	}

	
}
