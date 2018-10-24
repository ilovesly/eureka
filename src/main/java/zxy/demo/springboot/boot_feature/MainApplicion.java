package zxy.demo.springboot.boot_feature;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// MyBatis 支持
@MapperScan("zxy.demo.springboot.boot_feature.dao")
// filter 支持
@ServletComponentScan(basePackages = "zxy.demo.springboot.boot_feature.web")
@EnableEurekaServer
@SpringBootApplication
public class MainApplicion extends SpringBootServletInitializer{
	static {

		try {

			// 初始化log4j

//			String log4jPath = MainApplicion.class.getClassLoader().getResource("").getPath() + "log4j.properties";
//			
////			InputStream log4jPath =  MainApplicion.class.getClassLoader().getResourceAsStream("log4j.properties");
//
//			System.out.println("初始化Log4j。。。。");
//
//			System.out.println("path is " + log4jPath);
//
//			PropertyConfigurator.configure(log4jPath);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(MainApplicion.class);
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplicion.class, args);
	}

}