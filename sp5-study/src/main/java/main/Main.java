package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxClient;
import spring.Client;
import spring.Client2;

public class Main {
	
	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxClient.class);
	/*	
		Client client = ctx.getBean(Client.class);
		
		client.send();
		ctx.close();
	*/
		
		Client2 client2 = ctx.getBean(Client2.class);
		client2.send();
		ctx.close();
	}

}
