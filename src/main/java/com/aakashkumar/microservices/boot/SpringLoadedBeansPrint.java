package com.aakashkumar.microservices.boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class SpringLoadedBeansPrint implements CommandLineRunner {

	private final Logger logger= LogManager.getLogger(SpringLoadedBeansPrint.class);
	
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void run(String... args) {
		List<String> applicationConfigBeans= new ArrayList<String>(), applicationBeans= new ArrayList<String>();
		
		List<String> configBeanNames= Arrays.asList(applicationContext.getBeanNamesForAnnotation(Configuration.class));
		for (String beanName : configBeanNames) {
			Object bean= applicationContext.getBean(beanName);
			if (bean.toString().startsWith("com.aakashkumar.microservices")) {
				applicationConfigBeans.add(bean.getClass().getName());
			}
		}
		List<String> beanNames= Arrays.asList(applicationContext.getBeanDefinitionNames());
		for (String beanName : beanNames) {
			Object bean= applicationContext.getBean(beanName);
			if (bean.toString().startsWith("com.aakashkumar.microservices")) {
				applicationBeans.add(bean.getClass().getName());
			}
		}		
		applicationBeans.removeAll(applicationConfigBeans);
		
		logger.info("\n########## APPLICATION PROFILES... ##########");
		List profiles= Arrays.asList(applicationContext.getEnvironment().getActiveProfiles());
		Collections.sort(profiles);
		for (Object p: profiles) {
			logger.info(p);
		}

		if(logger.isDebugEnabled()) {
		    logger.debug("\n########## APPLICATION ENVIRONMENT... ##########");
            Map<String, Object> envMap= ((ConfigurableEnvironment)applicationContext.getEnvironment()).getSystemEnvironment();
            List<String> keys= new ArrayList<String>(envMap.keySet());
            Collections.sort(keys);
            for (String k : keys) {
                logger.info("["+k+","+envMap.get(k)+"]");
            }
        }
		
		logger.info("\n########## APPLICATION LOADED CLASSES... ##########");
        Collections.sort(applicationConfigBeans); Collections.sort(applicationBeans);
		for (String beans : applicationConfigBeans) {
			logger.info(beans);
		}
		logger.info("");
		for (String beans : applicationBeans) {
			logger.info(beans);
		}	
		
		logger.info("\n########## JVM MEMORY Statistics ##########");
		Runtime runtime = Runtime.getRuntime(); int mb = 1024*1024;
		logger.info("Used Memory:" 
			+ (runtime.totalMemory() - runtime.freeMemory()) / mb+" (MB)");
		logger.info("Free Memory:" 
			+ runtime.freeMemory() / mb+" (MB)");
		logger.info("Total Memory:" 
			+ runtime.totalMemory() / mb+" (MB)");
		logger.info("Max Memory:" 
			+ runtime.maxMemory() / mb+" (MB)");		
		
		
	}
}
