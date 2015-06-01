package com.zluo.jfinal.util;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：TestSqlUtil  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年6月1日 下午12:42:31  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年6月1日 下午12:42:31  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class SqlUtilTest {

	@Test
	public void testFindAll_01(){
		Assert.assertEquals("select * from user", SqlUtil.findAll("user"));
	}
	
	@Test
	public void testFinAll_02(){
		Assert.assertEquals("select * from user order by id desc", SqlUtil.findAll("user",
				"desc", "id"));
	}
	
	@Test
	public void testMergeParam(){
		Assert.assertEquals("select *", SqlUtil.mergeParam("*"));
	}
	
}
