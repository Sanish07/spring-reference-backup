package com.sanish.spring_boot_intro;

import com.sanish.spring_boot_intro.pojo.FirstBean;
import com.sanish.spring_boot_intro.pojo.ReadSysProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootIntroApplication.class, args);
		FirstBean bean = context.getBean(FirstBean.class);
		System.out.println(bean.greet());

		ReadSysProperties sys = context.getBean(ReadSysProperties.class);
		System.out.println("OS Name : "+sys.getOSVersion());
		System.out.println("Java Version : "+sys.getJavaVersion());
		System.out.println("Project Name : "+sys.getProjectName());
		System.out.println("Project Version : "+sys.getProjectVersionFromCustomFile());
	}

}
