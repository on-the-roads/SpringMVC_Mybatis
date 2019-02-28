## 商品后台管理系统
整合Spring+SpringMVC+MyBatis框架，搭建了一个简单的商品后台管理系统，实现了对商品信息的查询、修改及其他批量操作。  

## 功能实现
  version0: 搭建框架，创建基本的controller层，service层和model层    
  version1: 添加商品查询功能（实现pojo类型绑定）  
  version2: 添加商品修改功能（简单数据类型绑定）   
  version3: 添加商品批量删除功能（通过多选商品id实现，实现数组绑定）  
  version4: 添加商品批量修改功能和批量提交功能（实现LIst集合绑定）    
  version5.1: 添加校验功能，使用hibernate的校验框架validation    
  version5.2: 添加异常处理功能（自定义异常，全局异常处理器）     
  version5.3: 添加上传图片功能(controller层以及jsp)以及进行json数据交互功能测试     
  version5.4: 添加RESTful支持，添加根据商品id查询商品信息的方法，利用RESTful的url风格进行验证。Controller层添加方法，在web.xml中配置支持RESTful的前端控制器，同时在springmvc.xml中添加处理例如css、img...的静态资源的方法。

