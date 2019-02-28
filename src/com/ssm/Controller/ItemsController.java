package com.ssm.Controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.Controller.validation.validationGroup1;
import com.ssm.Po.ItemsCustom;
import com.ssm.Po.ItemsQueryVo;
import com.ssm.Service.ItemsService;
/**
 * 使用注解开发Handler（注意：注解映射器和注解适配器也要同时搭配使用）
 * 不用再实现接口，因此可以添加不止add()的其他方法
 */
@org.springframework.stereotype.Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	// 商品查询列表
	//使用@RequestMapping来实现queryItems（）方法和url一一映射
	//一般建议将url和方法名称写成一样
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {

		// 调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
	
	//查询商品信息，输出json数据（利用RESTful架构完成）
	//@PathVariable作用：将url模板请求的变量映射到方法的参数。若模板变量和方法参数名称一致，则可以不用@PathVariable
	//使用RESTful支持注意要将web.xml中的前端控制器为'/'，同时也要在springmvc.xml中配置静态资源解析方法
	@RequestMapping(value="/findItems/{id}")
	public @ResponseBody ItemsCustom findItems(@PathVariable("id")Integer id) throws Exception {
		ItemsCustom itemsCustom=itemsService.fingItemById(id);
		return itemsCustom;
	}
	
	//商品修改页面展示
	//@RequestMapping("/editItem.action")
	//限制http请求路径方法为get和post
	@RequestMapping(value="/editItem.action" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView editItem(Integer id)throws Exception {
		
		// 调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.fingItemById(id);
	
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//商品信息放入Model
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		// View指定视图
		modelAndView.setViewName("items/editItems");
		
		return modelAndView;
	}
	//提交修改页面
	//如果不使用@RequestParam，要求request传入参数名称和controller方法的形参名称一致，方可绑定成功。
	//如果使用@RequestParam，不用限制request传入参数名称和controller方法的形参名称一致。
	//校验：在需要校验的pojo前面加上@Validated,后面加上BindingResult bindingResult，其中bindingResult用于接收错误信息。
	//分组校验：添加分组，则只校验pojo所属分组的方法。eg：@Size(min=1,max=30,message="{items.name.length.err}",groups={validationGroup1.class})则只显示字符长度的错误
	@RequestMapping("/editItemsSubmit.action")
	public String editItemSubmit(Model model,@RequestParam(value="id",required=true)Integer Itemsid,@Validated(value={validationGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,MultipartFile items_pic)throws Exception {
		//在controller中将错误信息传到页面
		if(bindingResult.hasErrors())
		{
			List<ObjectError> errList=bindingResult.getAllErrors();
			for(ObjectError error:errList){
				System.err.println(error.getDefaultMessage());
			}
			model.addAttribute("errList", errList);
			//出错则重新定位到商品编辑页面
			return "items/editItems";
		}
		//上传图片
		String originalFilename=items_pic.getOriginalFilename();
		if(items_pic!=null&&originalFilename!=null&&originalFilename.length()>0)
		{
			//存储图片的物理路径
			String picPath="G:\\works\\picture\\temp\\";
			//新的图片名称
			String new_picName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile= new File(picPath+new_picName);
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			//将新的图片写入itemsCustom中
			itemsCustom.setPic(new_picName);
		}
		itemsService.updateItems(Itemsid, itemsCustom);
		return "successEdit";
	}
	
	//批量修改页面
	@RequestMapping("/deleteItems.action")
	public String deleteItems(Integer[] items_id) throws Exception{
		
		itemsService.deleteItems(items_id);
		return "successDelete";
	}
	
	//批量编辑页面展示
	@RequestMapping("/editItemsAll.action")
	public ModelAndView editItemsAll(ItemsQueryVo itemsQueryVo) throws Exception{
		
		// 调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		modelAndView.setViewName("items/editItemsAll");

		return modelAndView;
	}
	
	//批量编辑提交
	@RequestMapping("/editItemsAllSubmit.action")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		for(ItemsCustom itemsCustom:itemsQueryVo.getItemsCustomList()){
			Integer Itemsid=itemsCustom.getId();
	     	itemsService.updateItems(Itemsid, itemsCustom);
		}
		return "successEdit";
	}
}
