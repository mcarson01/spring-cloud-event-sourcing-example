package demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationGuard implements InitializingBean {

   @Value("${eureka.client.serviceUrl.defaultZone}")
   private String eurekaZone;

   /**
    * ONLY needed if there is some crude default handling for missing values!!!!
    *
    * So try it first without this method (and without implements InitializingBean)
    */
   public void afterPropertiesSet() {
	   System.out.println("mcarson eurekaZone: "+this.eurekaZone);
	   
//	  if (this.myHomeValue == null || this.myHomeValue.equals("${my.home}")) {
//          throw new IllegalArgumentException("${my.home} must be configured");
//      }
   }

}