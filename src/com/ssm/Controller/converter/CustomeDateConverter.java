package com.ssm.Controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomeDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			return simpleDateFormat.parse(source);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
