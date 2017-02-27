package demo;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixApplication {

	
    public static void main(String[] args) {
    	ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(HystrixApplication.class, args);

    	System.out.println("mcarson - spring.cloud.config.uri: "+configurableApplicationContext.getEnvironment().getProperty("spring.cloud.config.uri"));
    	
    	System.out.println("mcarson - eureka.client.serviceUrl.defaultZone: "+configurableApplicationContext.getEnvironment().getProperty("eureka.client.serviceUrl.defaultZone"));

    		    	  
    		    	  
        System.out.println("mcarson env vars");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
        System.out.println("mcarson properties");
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for (Object key : keys) {
            System.out.format("%s=%s%n", (String)key , props.getProperty((String)key));			
		}
    
    
        System.out.println("mcarson properties end");

    }
}
