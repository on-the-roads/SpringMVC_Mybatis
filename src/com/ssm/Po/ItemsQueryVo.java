package com.ssm.Po;

import java.util.List;

/**
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 */
public class ItemsQueryVo {
	
	
	private Items items;//商品信息
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;//单个商品信息
	
	
	private List<ItemsCustom> itemsCustomList;//批量商品信息
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsCustomList() {
		return itemsCustomList;
	}

	public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
		this.itemsCustomList = itemsCustomList;
	}
	
	

}
