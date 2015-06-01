package com.zluo.jfinal.model;


/**
 * 
 * 项目名称：jfinal-demo <br> 
 * 类名称：User  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月31日 下午10:36:56  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月31日 下午10:36:56  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class UserModel extends BaseModel<UserModel>{

	private static final long serialVersionUID = 1L;
	
	private static UserModel dao = new UserModel();
	
	public void setBaseModel(){
		super.setBaseModel(dao);
	}
	
	public static UserModel getModel(){
		return dao;
	}
}
