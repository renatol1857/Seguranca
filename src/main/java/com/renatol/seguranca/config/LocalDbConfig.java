package com.renatol.seguranca.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.renatol.seguranca.repositories.local", entityManagerFactoryRef = "localEMFactory", transactionManagerRef = "transationFactory")
public class LocalDbConfig {
	@Bean
	@ConfigurationProperties(prefix = "local.datasource")
	public DataSource localDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localEMFactory(EntityManagerFactoryBuilder builder, @Qualifier("localDataSource") DataSource ds) {
		return builder.dataSource(ds).packages("com.renatol.seguranca.model.local").build();
	}

	@Bean
	public PlatformTransactionManager transationFactory(@Qualifier("localEMFactory") LocalContainerEntityManagerFactoryBean transationFactory) {
		return new JpaTransactionManager(Objects.requireNonNull(transationFactory).getObject());
	}
}
