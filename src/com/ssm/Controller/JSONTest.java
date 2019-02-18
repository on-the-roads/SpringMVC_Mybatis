package com.ssm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.Po.ItemsCustom;

@Controller
public class JSONTest {
@RequestMapping (value="/requestJson.action")
public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
	
	return itemsCustom;
}
@RequestMapping (value="/responseJson.action")
public @ResponseBody ItemsCustom responseJson( ItemsCustom itemsCustom) {
	
	return itemsCustom;
}
}
