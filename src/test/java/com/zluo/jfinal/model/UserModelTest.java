package com.zluo.jfinal.model;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：UserModelTest  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年6月1日 下午12:10:32  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年6月1日 下午12:10:32  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class UserModelTest {

	@Test
	public void testGetTableName(){
		Assert.assertEquals("user", UserModel.getModel().getTableName());
	}
	
}
