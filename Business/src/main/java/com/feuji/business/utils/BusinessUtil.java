package com.feuji.business.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class BusinessUtil 
{
	@Value("${environment}")
	private String environment;
	
	@Value("${dev-url}")
	private String devUrl;
	
	@Value("${prod-url}")
	private String prodUrl;
	
	public String getUrl()
	{
		
		if("dev".equals(environment))
		{
			return devUrl;
		}
		else
		{
			return prodUrl;
		}
	}
}
