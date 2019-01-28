package com.ssm.Service;

import java.util.List;

import com.ssm.Po.ItemsCustom;
import com.ssm.Po.ItemsQueryVo;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	//根据id查询商品信息
	public ItemsCustom fingItemById(Integer id)throws Exception;
	//修改商品信息
	public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;
}
