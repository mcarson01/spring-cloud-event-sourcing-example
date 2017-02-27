package demo;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
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
