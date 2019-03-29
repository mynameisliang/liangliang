package cn.jxy.sdnweb.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.sdnweb.dao.IUserDao;
import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.service.IUserService;
import cn.jxy.sdnweb.util.PageCut;

/**
 * 
 * @author Administrator
 * 人员管理业务层
 */
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	@Override
	public boolean add(User user) {
		return userDao.add(user);
	}

	@Override
	public boolean delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public User findOne(String condition,Object...objects) {
		return userDao.findOne(condition,objects);
	}
	
	@Override
	public PageCut<User> finds(int curr, int size, String condition, Object... objects) {
		
		return userDao.finds(curr, size, condition, objects);
	}

	

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	
	
}
