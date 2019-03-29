package cn.jxy.sdnweb.dao;


import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.util.PageCut;


public interface IUserDao {
	
	public boolean add(User user);
	
	public boolean delete(int id);
	
	public boolean update(User user);
	
	public User findOne(String condition,Object...objects);
	
	public PageCut<User> finds(int curr,int size,String condition,Object...objects);
	
}
