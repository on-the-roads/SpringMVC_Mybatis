package com.ssm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.Po.ItemsCustom;
import com.ssm.Service.ItemsService;

/**
 * 使用注解开发Handler（注意：注解映射器和注解适配器也要同时搭配使用）
 * 不用再实现接口，因此可以添加不止add()的其他方法
 */
@org.springframework.stereotype.Controller
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	// 商品查询列表
	//使用@RequestMapping来实现queryItems（）方法和url一一映射
	//一般建议将url和方法名称写成一样
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems() throws Exception {

		// 调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
}
