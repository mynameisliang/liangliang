package cn.jxy.sdnweb.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jxy.sdnweb.base.BaseDao;
import cn.jxy.sdnweb.dao.IUserDao;
import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.util.PageCut;

/**
 * 
 * @author Administrator
 * 用户管理数据层
 */
@Repository
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	@Override
	public boolean add(User user) {		
		return this.saveEntity(user);
	}

	@Override
	public boolean delete(int id) {
		return this.deleteEntity(id);
	}

	@Override
	public boolean update(User user) {
		return this.updateEntity(user);
	}

	@Override
	public User findOne(String condition,Object...objects) {
		if(condition.equals("login")) {
			String hql="from User user where user.username=? and user.password=? ";
			return (User)this.uniqueResult(hql,objects);
		}else if(condition.equals("id")) {
			return (User)this.getEntity((int)objects[0]);
		}else if(condition.equals("only")) {
			String hql="from User user where user.username=? ";
			return (User)this.uniqueResult(hql,objects);
		}
		return null;
	}

	

	@Override
	public PageCut<User> finds(int curr, int size, String condition, Object... objects) {
		if(condition.equals("all")) {
			String hql="from User";
			int count= this.getEntityNum(hql);
			PageCut<User> pc=new PageCut<>(curr, size, count);
			pc.setData(this.getEntityLimitList(hql, (curr-1)*size, size));
			return pc;
		}else if(condition.equals("search")) {
			StringBuilder hql=new StringBuilder("from User u where u.username like '%")										
					.append(objects[0]).append("%' or u.type like '%")
					.append(objects[0]).append("%'");
			int count= this.getEntityNum(hql.toString());
			logger.info(hql.toString());
			PageCut<User> pc=new PageCut<>(curr, size, count);
			pc.setData(this.getEntityLimitList(hql.toString(), (curr-1)*size, size));
			return pc;
		}
		
		return null;
	}

}
