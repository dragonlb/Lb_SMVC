package com.bc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bc.frame.logger.Log4jManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/applicationContext-*.xml")
public class LogTs extends AbstractJUnit4SpringContextTests  {

	Logger logger = Log4jManager.get();
	
	@Test
    public void saveTest() {
		logger.info("...start test...");
		System.out.println(".. ok ..");
	}
	
}
