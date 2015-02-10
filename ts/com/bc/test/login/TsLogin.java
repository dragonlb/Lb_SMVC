package com.bc.test.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bc.common.utils.SpringContextUtil;
import com.bc.excp.BusinessException;
import com.bc.frame.logger.Log4jManager;
import com.bc.sp.msg.BcMsg;
//import com.bc.sp.trade.login.Trade000901;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/applicationContext-common.xml")
public class TsLogin extends AbstractJUnit4SpringContextTests  {

	Logger logger = Log4jManager.get();
	
	@Test
	public void loginTs(){
//		Trade000901 login = (Trade000901) SpringContextUtil.getBean("trade000901");
//		BcMsg inMsg = new BcMsg();
//		BcMsg outMsg = null;
//		try {
//			outMsg = login.execute(inMsg);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(outMsg.getBody());
	}
}