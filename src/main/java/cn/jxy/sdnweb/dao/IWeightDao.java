package cn.jxy.sdnweb.dao;

import cn.jxy.sdnweb.entity.NodeRelation;
import cn.jxy.sdnweb.util.PageCut;

public interface IWeightDao {
	
	public boolean add(NodeRelation nodeRelation);
	
	public boolean delete(int id);
	
	public boolean update(NodeRelation nodeRelation);
	
	public NodeRelation findOne(String condition,Object...objects);
	
	public PageCut<NodeRelation> finds(int curr,int size,String condition,Object...objects);
}
