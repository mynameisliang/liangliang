package cn.jxy.sdnweb.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jxy.sdnweb.base.BaseDao;
import cn.jxy.sdnweb.dao.IWeightDao;
import cn.jxy.sdnweb.entity.NodeRelation;
import cn.jxy.sdnweb.util.PageCut;

/**
 * 
 * @author Administrator
 *	路径数据层
 */
@Repository
public class WeightDaoImpl extends BaseDao<NodeRelation> implements IWeightDao {

	@Override
	public boolean add(NodeRelation nodeRelation) {
		this.saveEntity(nodeRelation);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if(id==0) {
			this.deleteAll("NodeRelation");
		}else {
			this.deleteEntity(id);
		}
		return true;
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
		if(condition.equals("all")) {
			String hql="from NodeRelation";
			int count= this.getEntityNum(hql);
			PageCut<NodeRelation> pc=new PageCut<>(curr, size, count);
			pc.setData(this.getEntityLimitList(hql, (curr-1)*size, size));
			return pc;
		}else if(condition.equals("search")) {
			StringBuilder hql=new StringBuilder("from NodeRelation n where n.node_A like '%")
					.append(objects[0]).append("%' or n.node_B like '%")
					.append(objects[0]).append("%' or n.weight like '%")					
					.append(objects[0]).append("%'");
			int count= this.getEntityNum(hql.toString());
			logger.info(hql.toString());
			PageCut<NodeRelation> pc=new PageCut<>(curr, size, count);
			pc.setData(this.getEntityLimitList(hql.toString(), (curr-1)*size, size));
			return pc;
		}
		
		return null;
	}

}
