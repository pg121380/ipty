package com.ipty.www.service;
import java.util.List;
import com.ipty.www.pojo.User;

import com.ipty.www.entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<User> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(User user);
	
	
	/**
	 * 修改
	 */
	public void update(User user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public User findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(User user, int pageNum,int pageSize);
	
}
