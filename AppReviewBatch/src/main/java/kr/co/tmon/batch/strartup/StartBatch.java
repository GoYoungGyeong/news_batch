package kr.co.tmon.batch.strartup;
/**
 * @author 고영경
 */
import kr.co.tmon.batch.appreview.controller.AppReviewDbBatchController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartBatch {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

		AppReviewDbBatchController appReviewDbBatchController = applicationContext.getBean("appReviewDbBatchController", AppReviewDbBatchController.class);
		appReviewDbBatchController.runAppReviewDbUpdateBatch();
	}
}
