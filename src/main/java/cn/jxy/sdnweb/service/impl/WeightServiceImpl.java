package cn.jxy.sdnweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxy.sdnweb.dao.IWeightDao;
import cn.jxy.sdnweb.entity.NodeRelation;
import cn.jxy.sdnweb.service.IWeightService;
import cn.jxy.sdnweb.util.PageCut;
/***
 * 
 * @author Administrator
 * 路径业务层
 */
@Service
public class WeightServiceImpl implements IWeightService {

	@Resource
	private IWeightDao weightDao;
	
	@Override
	public boolean add(NodeRelation nodeRelation) {
		return weightDao.add(nodeRelation);
	}

	@Override
	public boolean delete(int id) {
		return weightDao.delete(id);
	}

	@Override
	public boolean update(NodeRelation nodeRelation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NodeRelation findOne(String condition, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageCut<NodeRelation> finds(int curr, int size, String condition, Object... objects) {
		return weightDao.finds(curr, size, condition, objects);
	}

	public IWeightDao getNodeDao() {
		return weightDao;
	}

	public void setNodeDao(IWeightDao nodeDao) {
		this.weightDao = nodeDao;
	}
	
	
}
