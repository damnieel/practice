package com.cvc.provider;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class ProviderApplication {
	public static void main(String[] args) throws IOException {
	      SpringApplication.run(ProviderApplication.class, args);
	      System.out.println("服务端启动成功！！！");
	      
	      try {
	         System.in.read();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
}
