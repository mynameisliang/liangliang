package cn.jxy.sdnweb.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jxy.sdnweb.base.BaseDao;
import cn.jxy.sdnweb.dao.INodeDao;
import cn.jxy.sdnweb.dao.IWeightDao;
import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.entity.NodeRelation;
import cn.jxy.sdnweb.util.PageCut;
/**
 * 节点数据层
 * @author Administrator
 *
 */
@Repository
public class NodeDaoImpl extends BaseDao<Node> implements INodeDao {

	@Override
	public boolean add(Node node) {
		this.saveEntity(node);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if(id==0) {
			this.deleteAll("Node");
		}else {
			this.deleteEntity(id);
		}
		return true;
	}

	@Override
	public boolean update(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node findOne(String condition, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageCut<Node> finds(int curr, int size, String condition, Object... objects) {
		if(condition.equals("all")) {
			String hql="from Node";
			if(curr==0 && size==0) {
				PageCut<Node> pc=new PageCut<>();
				pc.setData(this.getEntityList(hql));
				return pc;
			}else {
				int count= this.getEntityNum(hql);
				PageCut<Node> pc=new PageCut<>(curr, size, count);
				pc.setData(this.getEntityLimitList(hql, (curr-1)*size, size));
				return pc;
			}
			
		}else if(condition.equals("search")) {
			StringBuilder hql=new StringBuilder("from Node n where n.name like '%")
					.append(objects[0]).append("%' or n.x like '%")
					.append(objects[0]).append("%' or n.y like '%")					
					.append(objects[0]).append("%'");
			int count= this.getEntityNum(hql.toString());
			logger.info(hql.toString());
			PageCut<Node> pc=new PageCut<>(curr, size, count);
			pc.setData(this.getEntityLimitList(hql.toString(), (curr-1)*size, size));
			return pc;
		}
		
		return null;
	}

}
