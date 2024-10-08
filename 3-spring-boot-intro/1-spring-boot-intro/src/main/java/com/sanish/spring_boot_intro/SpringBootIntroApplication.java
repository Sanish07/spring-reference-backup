package com.sanish.spring_boot_intro;

import com.sanish.spring_boot_intro.pojo.FirstBean;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootIntroApplication.class, args);
		FirstBean bean = context.getBean("firstBean", FirstBean.class);
		System.out.println(bean.greet());
	}

}
