package kr.co.tmon.batch.news.controller;

import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;

import kr.co.tmon.batch.news.bo.RecordTodayNewsBO;
import kr.co.tmon.batch.news.bo.XmlParsingBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * @author 고영경
 */
@Controller
public class DataBatch {
	@Autowired
	private XmlParsingBO xmlParsingBO;
	
	@Autowired
	private RecordTodayNewsBO recordTodayNewsBO;
	
	public void runBatch() throws MalformedURLException, ParseException, JAXBException {
		xmlParsingBO.insertParsingNewsData();
		recordTodayNewsBO.recordTodayNewsCount();
	}
}
