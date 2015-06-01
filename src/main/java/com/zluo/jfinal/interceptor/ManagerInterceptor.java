package com.zluo.jfinal.interceptor;

import com.jfinal.aop.InterceptorStack;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：ManagerInterceptor  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年6月1日 上午10:03:26  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年6月1日 上午10:03:26  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class ManagerInterceptor extends InterceptorStack {

	@Override
	public void config() {
		addInterceptors(new GlobalInterceptor(), new ControllerInterceptor(), new ActionInterceptor());
	}

}
