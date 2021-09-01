package com.fresure;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fresure" })
@EntityScan(basePackages = { "com.fresure" })
public class FresureDeliverApp implements CommandLineRunner
{

  public static void main(String[] args) {
    SpringApplication.run(FresureDeliverApp.class, args);
  }

  @Override
  public void run (String... args) throws Exception
  {

  }
}