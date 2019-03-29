package cn.jxy.sdnweb.util;

import java.util.ArrayList;
import java.util.List;

import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.entity.NodeRelation;
/**
 * 
 * 下一步：重新生成路径工具类
 *
 */
public class NextRoutesUtil {
	
	//根据权值获得节点
	public static List<NodeRelation> getNodes(double max,List<NodeRelation> relations){
		List<NodeRelation> result=new ArrayList<>();
		for(int i=0;i<relations.size();i++) {
			if(relations.get(i).getWeight()==max) {
				result.add(relations.get(i));
			}
		}
		//去掉重复节点
		for(int i=result.size()-1;i>0;i--) {
			if(result.get(i).getNode_A().equals(result.get(i-1).getNode_B()) 
					&& result.get(i).getNode_B().equals(result.get(i-1).getNode_A())) {
				result.remove(i);
			}
		}
		return result;
	}
	
	//获得最大权值
	public static double getMaxWeight(List<NodeRelation> relations) {
		double max=0;
		for(int i=0;i<relations.size();i++) {
			for(int j=0;j<relations.size();j++) {
				if(relations.get(i).getWeight()>max) {
					max=relations.get(i).getWeight();            
				}
			}
		}
		return max;
	}
	
	//删除节点关系最大权值
	public static List<NodeRelation> deleteMaxWeight(double max,List<NodeRelation> relations) {

		for(int i=0;i<relations.size();i++) {
			
			if(relations.get(i).getWeight()==max) {
				relations.remove(i);
			}
		}
		return relations;
	}
	
	//删除最大权值，重置节点
	public static List<Node> resetNodes(double maxWeight,List<Node> nodes,List<NodeRelation> maxNodesRelation,String start,String end){
		for(int i=0;i<nodes.size();i++) {			
			for(int j=0;j<maxNodesRelation.size();j++) {
				if(nodes.get(i).getName().equals(maxNodesRelation.get(j).getNode_A()) 
						|| nodes.get(i).getName().equals(maxNodesRelation.get(j).getNode_B()) ) {
					for(int k=0;k<nodes.get(i).getRelationNodes().size();k++) {
						if(nodes.get(i).getRelationNodes().get(k).getName().equals(maxNodesRelation.get(j).getNode_A()) 
								|| nodes.get(i).getRelationNodes().get(k).getName().equals(maxNodesRelation.get(j).getNode_B())) {
							//不能删除开始节点到结束节点的关系权值
							if(!((nodes.get(i).getName().equals(start) 
									&& nodes.get(i).getRelationNodes().get(k).getName().equals(end))
									|| (nodes.get(i).getName().equals(end) 
											&& nodes.get(i).getRelationNodes().get(k).getName().equals(start)))) {
								nodes.get(i).getRelationNodes().remove(k);
								
								/*System.out.println("删除一个"
								+nodes.get(i).getName()+maxNodesRelation.get(j).getNode_A()
								+maxNodesRelation.get(j).getNode_B());*/
							}
							
						}
					}
				}
			}
			
		}
		
		return nodes;
	}
	
	public static void main(String[] args) {
		
		List<Node> nodes=NodesUtil.randomNodes(5);
		
		List<NodeRelation> relations=NodesUtil.getAllWeight(nodes);
		RoutesUtil.routess.clear();
		List<Routes> routess=RoutesUtil.getRoutes("A","B",nodes,relations);
		System.out.println("old****************");
		for(Node n:nodes) {
			System.out.println(n);
			System.out.println(n.relationNodes.size());
			for(Node n2:n.relationNodes)
				System.out.println(n2);
			System.out.println();
		}
		System.out.println("路径数："+routess.size());
		/*for(Routes r:routess)
			System.out.println(r);*/
		double maxWeight=NextRoutesUtil.getMaxWeight(relations);
		System.out.println("max="+maxWeight);
		List<NodeRelation> maxNodesRelation=NextRoutesUtil.getNodes(maxWeight, relations);
		
		List<Node> newNodes=NextRoutesUtil.resetNodes(maxWeight, nodes, maxNodesRelation,"A","B");
		
		
		for(NodeRelation r:maxNodesRelation)
			System.out.println(r);
		
		System.out.println("new****************");
		for(Node n:newNodes) {
			System.out.println(n);
			System.out.println(n.relationNodes.size());			
			for(Node n2:n.relationNodes)
				System.out.println(n2);
			System.out.println();
		}
			
		
		
		
	}
}
