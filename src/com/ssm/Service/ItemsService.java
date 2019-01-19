package com.ssm.Service;

import java.util.List;

import com.ssm.Po.ItemsCustom;
import com.ssm.Po.ItemsQueryVo;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}
