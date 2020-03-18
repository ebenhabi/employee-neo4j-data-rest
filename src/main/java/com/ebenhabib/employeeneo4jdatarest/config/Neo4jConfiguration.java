package com.ebenhabib.employeeneo4jdatarest.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.ebenhabib.employeeneo4jdatarest.repository")
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class Neo4jConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(configuration(), "com.ebenhabib.employeeneo4jdatarest.domain");
	}
	
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
			.uri(environment.getProperty("spring.data.neo4j.uri"))
			.credentials(environment.getProperty("spring.data.neo4j.username"), environment.getProperty("spring.data.neo4j.password"))
			.build();
		
		return configuration;
	}

	/* to use embedded
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		ConfigurationSource properties = new ClasspathConfigurationSource("application.properties");
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties)
				.credentials("spring.data.neo4j.username", "spring.data.neo4j.password")
				.build();

		return configuration;
	}
	*/

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
}
