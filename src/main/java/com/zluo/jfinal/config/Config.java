package com.zluo.jfinal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.zluo.jfinal.controller.UserController;
import com.zluo.jfinal.interceptor.GlobalInterceptor;
import com.zluo.jfinal.model.UserModel;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：Config  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月31日 下午5:32:33  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月31日 下午5:32:33  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants c) {
		loadPropertyFile("a_little_config.txt");
		c.setDevMode(getPropertyToBoolean("devMode", true));
		c.setViewType(ViewType.FREE_MARKER);
	}

	@Override
	public void configHandler(Handlers h) {
		h.add(new ContextPathHandler("contextPath"));
	}

	@Override
	public void configInterceptor(Interceptors i) {
		//配置全局拦截器
		i.add(new GlobalInterceptor());
	}

	@Override
	public void configPlugin(Plugins p) {
		// 配置Druid数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		p.add(druidPlugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		p.add(arp);
		arp.addMapping("user", UserModel.class);
		
	}

	@Override
	public void configRoute(Routes r) {
		r.add("/", UserController.class);
	}
	
}
