package kr.co.tmon.socialnews.model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;



import kr.co.tmon.batch.news.model.SocialNewsDocument;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author yeseul23
 * 
 * 
 */
public class SocialNewsDocumentTest {

	private SocialNewsDocument socialNewDocument;

	@Before
	public void setup() throws JAXBException, FileNotFoundException, UnmarshalException, MalformedURLException {
		// URL url = new URL("http://10.5.220.81:8080/social/news.xml");
		JAXBContext context = JAXBContext.newInstance(SocialNewsDocument.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// socialNewDocument = (SocialNewsDocument) unmarshaller.unmarshal(url);

		// 1팀 서버가 닫혀있는 경우 dummy data로 test.
		socialNewDocument = (SocialNewsDocument) unmarshaller.unmarshal(new FileReader("./src/test/resources/dummyxml/dummy.xml"));

	}

	@Test
	public void 파싱테스트_회사() throws UnmarshalException {
		assertEquals("위메프", socialNewDocument.getParsedNewsList().get(0).getSocialName());
		assertEquals("쿠팡", socialNewDocument.getParsedNewsList().get(1).getSocialName());
	}

	@Test
	public void 파싱테스트_제목() throws UnmarshalException {
		assertEquals("[명지대 산학협력 기사] 나도 명화 예술가", socialNewDocument.getParsedNewsList().get(0).getTitle());
		assertEquals("하이원리조트, 6월 황금연휴 '골든위크 패키지' 출시", socialNewDocument.getParsedNewsList().get(1).getTitle());
	}

	@Test
	public void 파싱테스트_날짜() throws UnmarshalException {
		assertEquals("2014-05-27 10:02:00.0", socialNewDocument.getParsedNewsList().get(0).getDate());
		assertEquals("2014-05-25 12:28:00.0", socialNewDocument.getParsedNewsList().get(1).getDate());
	}

}
