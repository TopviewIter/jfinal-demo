package com.zluo.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：UserInterceptor  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年6月1日 上午9:37:54  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年6月1日 上午9:37:54  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class GlobalInterceptor implements Interceptor{

	public void intercept(ActionInvocation ai) {
		System.out.println("全局拦截器开始");
		ai.invoke();
		System.out.println("全局拦截器结束");
	}
	
}
