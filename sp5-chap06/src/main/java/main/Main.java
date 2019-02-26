package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spring.Client;
import spring.Client2;

public class Main {
	
	public static void main(String[] args) throws Exception{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client client = ctx.getBean(Client.class);
		Client client1 = ctx.getBean(Client.class);
		client.send();
		System.out.println("client == client1 : " + (client == client1));

		Client2 client2 = ctx.getBean(Client2.class);
		Client2 client3 = ctx.getBean(Client2.class);
		client2.send();
		System.out.println("client2 == client3" + (client2 == client3));

		client.destroy();
		client1.destroy();
		ctx.close();
	}

}
