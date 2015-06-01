package com.zluo.jfinal.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.zluo.jfinal.interceptor.ActionInterceptor;
import com.zluo.jfinal.interceptor.ControllerInterceptor;
import com.zluo.jfinal.interceptor.ManagerInterceptor;
import com.zluo.jfinal.model.UserModel;
import com.zluo.jfinal.validator.UserValidator;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：UserController  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月31日 下午8:04:50  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月31日 下午8:04:50  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>	
 *
 */
@Before(ControllerInterceptor.class)
public class UserController extends Controller{

	private UserModel userModel = UserModel.getModel();
	
	/**
	 * 一个默认的方法
	 */
	@Before(ActionInterceptor.class)
	@ClearInterceptor	//删除上一级的拦截器
	public void index(){
		System.out.println("进入index方法");
		setAttr("message", "welcome to jfinal");
		setAttr("null", null);
		renderFreeMarker("index.html");
	}
	
	@Before({ManagerInterceptor.class, Tx.class, UserValidator.class})
	public void login(){
		String username = getPara("username");
		String password = getPara("password");
		setAttr("username", username);
		setAttr("password", password);
		renderFreeMarker("login.html");	
	}
	
	public void add(){
		UserModel user = getModel(UserModel.class);
		//如果页面不传值就这样设置
		user.set("id", 11);
		user.save();
		renderFreeMarker("login.html");
	}
	
	public void findAll(){
		List<UserModel> users = userModel.findAll();
		System.out.println(users.size());
		setAttr("users", users);
		renderFreeMarker("list.html");
	}
	
	public void findById(){
		UserModel user = userModel.findById(getPara("id"));
		setAttr("user", user);
		renderFreeMarker("individual.html");
	}
	
	public void findByPage(){
		Page<UserModel> pages = userModel.findByPage(1, 3, "*");
		setAttr("pages", pages);
		renderFreeMarker("page.html");
	}
}
