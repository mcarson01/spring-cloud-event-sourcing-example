package demo;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationGuard extends PropertySourcesPlaceholderConfigurer
		implements InitializingBean {

	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String eurekaZone;

	@Autowired
	private ConfigurableEnvironment myEnv;

	/**
	 * ONLY needed if there is some crude default handling for missing
	 * values!!!!
	 *
	 * So try it first without this method (and without implements
	 * InitializingBean)
	 */
	public void afterPropertiesSet() {

		try {
			System.out.println("Spring props: ");
			Properties props = super.mergeProperties();
	        Set keys = props.keySet();
	        for (Object key : keys) {
	            System.out.format("%s=%s%n", (String)key , props.getProperty((String)key));			
			}
			System.out.println("Spring props end ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("mcarson eurekaZone: "+this.eurekaZone);

		// if (this.myHomeValue == null ||
		// this.myHomeValue.equals("${my.home}")) {
		// throw new IllegalArgumentException("${my.home} must be configured");
		// }
	}

}