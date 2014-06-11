package kr.co.tmon.batch.strartup;
/**
 * @author 고영경
 */
import kr.co.tmon.batch.news.controller.DataBatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartBatch {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

		DataBatch dataBatch = applicationContext.getBean("dataBatch", DataBatch.class);
		dataBatch.runBatch();
	}
}
