package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtxClient {
	
	/*@Bean
	Client client() {
		Client client = new Client();
		client.setHost("123456");
		return client;
	}*/
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("1234");
		return client2;
	}


}
