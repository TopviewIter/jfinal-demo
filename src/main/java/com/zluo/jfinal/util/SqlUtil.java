package com.zluo.jfinal.util;

/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：SqlUtil  <br>
 * 类描述：  用于协助生成sql语句<br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年6月1日 下午12:14:57  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年6月1日 下午12:14:57  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class SqlUtil {

	public static String findAll(String tableName){
		return "select * from " + tableName;
	}
	
	public static String findAll(String tableName, String orderType, String orderParam){
		return "select * from " + tableName + " order by " + orderParam + " " + orderType;
	}
	
	public static String mergeParam(String... params){
		if(params != null && params.length > 1){
			String fromString = "select ";
			for(String s : params){
				fromString += s + " ";
			}
			return fromString;
		}else if(params.length == 1){
			return "select " + params[0];
		}else{
			return "select *";
		}
	}
	
}
