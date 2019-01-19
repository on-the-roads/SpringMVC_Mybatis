package com.ssm.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.Mapper.ItemsMapperCustom;
import com.ssm.Po.ItemsCustom;
import com.ssm.Po.ItemsQueryVo;
import com.ssm.Service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
