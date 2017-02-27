package demo;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * The {@link UserApplication} is a cloud-native Spring Boot application that manages
 * a bounded context for @{link User}, @{link Account}, @{link CreditCard}, and @{link Address}
 *
 * @author Kenny Bastani
 * @author Josh Long
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@EnableEurekaClient
@EnableHystrix
public class UserApplication {
	public static Logger log = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext config = SpringApplication.run(UserApplication.class, args);
    	
        String[] profiles = config.getEnvironment().getActiveProfiles();
        for (String profile : profiles) {
            log.error("mcarson - profile: "+profile);			
		}
        log.error("mcarson - defaultZone: "+ config.getEnvironment().getProperty("eureka.client.serviceUrl.defaultZone"));
        log.error("mcarson - reg with eureka: "+ config.getEnvironment().getProperty("eureka.client.registerWithEureka"));

        log.error("mcarson env vars");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            log.error("mcarson - key: "+envName +" value: "+env.get(envName));
        }
        log.error("mcarson properties");
        Properties props = System.getProperties();
        for (Object key : props.keySet()) {
            log.error("mcarson - key: "+(String)key +" value: "+(String)props.getProperty((String)key));
		}
    
        
    }

    @Component
    public static class CustomizedRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.setBasePath("/api");
        }
    }
}
