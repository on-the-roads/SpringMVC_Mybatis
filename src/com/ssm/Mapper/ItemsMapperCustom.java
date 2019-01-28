package com.ssm.Mapper;

import com.ssm.Po.Items;
import com.ssm.Po.ItemsCustom;
import com.ssm.Po.ItemsExample;
import com.ssm.Po.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
//	//根据id查询商品信息
//	public ItemsCustom fingItemById(Integer id)throws Exception;
//	//修改商品信息
//	public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;
}