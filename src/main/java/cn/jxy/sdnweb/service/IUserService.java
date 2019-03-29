package cn.jxy.sdnweb.service;

import java.util.List;

import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.util.PageCut;



public interface IUserService {
	
	public boolean add(User user);
	
	public boolean delete(int id);
	
	public boolean update(User user);
	
	public User findOne(String condition,Object...objects);
	
	public PageCut<User> finds(int curr,int size,String condition,Object...objects);
	
	
}
