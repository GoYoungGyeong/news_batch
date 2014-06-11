package kr.co.tmon.socialnews.dao;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import kr.co.tmon.batch.news.dao.RemoteGetNewsDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class RemoteGetNewsDAOTest {
	@Autowired
	private RemoteGetNewsDAO remoteGetNewsDAO;

	@Test
	public void 파싱한_데이터를_정상적으로_넘겨주는지_여부_테스트() throws MalformedURLException, JAXBException {
		assertNotNull(remoteGetNewsDAO.getSocialNewsDocument());
	}

}
