package cn.jxy.sdnweb.service;


import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.util.PageCut;

public interface INodeService {
	
	public boolean add(Node node);
	
	public boolean delete(int id);
	
	public boolean update(Node node);
	
	public Node findOne(String condition,Object...objects);
	
	public PageCut<Node> finds(int curr,int size,String condition,Object...objects);
}
