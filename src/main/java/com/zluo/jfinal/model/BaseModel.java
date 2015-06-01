package com.zluo.jfinal.model;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.zluo.jfinal.util.SqlUtil;

@SuppressWarnings("rawtypes")
public class BaseModel<T extends Model> extends Model<T> {

	private static final long serialVersionUID = 1L;
	
	private T baseModel;
	
	public void setBaseModel(T baseModel){
		this.baseModel = baseModel;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return baseModel.find(SqlUtil.findAll(getTableName()));
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String orderBy, String orderParam){
		return baseModel.find(SqlUtil.findAll(getTableName(), orderBy, orderParam));
	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findByPage(int pageNumber, int pageSize, String... params){
		return baseModel.paginate(pageNumber, pageSize, SqlUtil.mergeParam(params), "from " + getTableName());
	}
	
	protected String getTableName(){
		String entityName = getEntityClass().getName(); 
		return entityName.substring(entityName.lastIndexOf(".") + 1).replace("Model", "").toLowerCase();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass(){
		return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
