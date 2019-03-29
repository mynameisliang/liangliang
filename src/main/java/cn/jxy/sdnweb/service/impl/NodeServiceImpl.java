package cn.jxy.sdnweb.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.jxy.sdnweb.dao.INodeDao;
import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.service.INodeService;
import cn.jxy.sdnweb.util.PageCut;
/**
 * 节点业务层
 * @author Administrator
 *
 */
@Service
public class NodeServiceImpl implements INodeService {

	@Resource
	private INodeDao nodeDao;
	
	@Override
	public boolean add(Node node) {
		return nodeDao.add(node);
	}

	@Override
	public boolean delete(int id) {
		return nodeDao.delete(id);
	}

	@Override
	public boolean update(Node node) {
		return false;
	}

	@Override
	public Node findOne(String condition, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageCut<Node> finds(int curr, int size, String condition, Object... objects) {
		return nodeDao.finds(curr, size, condition, objects);
	}

	
}
