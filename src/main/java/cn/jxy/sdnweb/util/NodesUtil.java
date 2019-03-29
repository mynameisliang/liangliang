package cn.jxy.sdnweb.util;

import java.util.ArrayList;
import java.util.List;

import cn.jxy.sdnweb.entity.Node;
import cn.jxy.sdnweb.entity.NodeRelation;
/**
 * 
 * 生成节点和节点关系工具类
 *
 */
public class NodesUtil {
	
	
	//随机生产num个节点
	public static  List<Node>  randomNodes(int num) {
		List<Node> nodes=new ArrayList<Node>();
		for(int i=0;i<num;i++) {
			Node node=new Node();
			node.setName(String.valueOf((char)('A'+i)));
			node.setX((new Double(Math.random()*600)).intValue());
			node.setY((new Double(Math.random()*600)).intValue());
			if(isExist(nodes, node)) {
				i--;
			}else {
				nodes.add(node);
			}			
		}
		return nodes;
	}
	
	//判断该节点是否已经生成
	public static boolean isExist(List<Node> list,Node node) {
		boolean bool=false;
		for(Node n:list) {
			if(n.getX()==node.getX() && n.getY()==node.getY()) {
				bool=true;
				break;
			}
		}
		return bool;
	}
	
	//获得图的邻接点的权值
	public static List<NodeRelation> getAllWeight(List<Node> nodes){
		List<NodeRelation> list=new ArrayList<>();
		for(int i=0;i<nodes.size();i++) {
			for(int j=0;j<nodes.size();j++) {
				if(!nodes.get(i).getName().equals(nodes.get(j).getName())) {
					if(isAbut(nodes.get(i), nodes.get(j), nodes)) {
						nodes.get(i).getRelationNodes().add(nodes.get(j));
						NodeRelation nodeRelation=new NodeRelation();
						nodeRelation.setNode_A(nodes.get(i).getName());
						nodeRelation.setNode_B(nodes.get(j).getName());
						nodeRelation.setWeight(distance(nodes.get(i), nodes.get(j)));						
						list.add(nodeRelation);
					}
				}
			}
		}
		
		//for(int i=0;i<)
		
		return list;
	}
	
	//判断两点是否是邻接点(根据第三点C到两点A、B间距离的和是否等于AB间距离)
	public static boolean isAbut(Node A,Node B,List<Node> nodes) {
		boolean bool=true;		
		Node C=null;
		Double distanceOfAC=0.0,distanceOfBC=0.0,distanceOfAB=0.0;
		for(int i=0;i<nodes.size();i++) {
			C=nodes.get(i);
			if(!( C.getName().equals(A.getName()) || C.getName().equals(B.getName()))) {
				distanceOfAC=distance(A, C);
				distanceOfBC=distance(B, C);
				distanceOfAB=distance(A, B);
				
				if(Math.abs(distanceOfAB-(distanceOfAC+distanceOfBC))<Math.pow(10, -6)) {
					bool=false;					
				}
			}
		}
		return bool;
	}
	
	//获得两点间距离
	public static Double distance(Node A,Node B) {
		Double distance=0.0;
		distance=Math.sqrt(square(A.getX()-B.getX())+square(A.getY()-B.getY()));
		return distance;
		
	}
	
	//n的平方
	public static int square(int n) {
		return n*n;
	}
	
	//获得两节点权值
	public static double getWeight(Node A,Node B,List<NodeRelation> relations) {
		for(int i=0;i<relations.size();i++) {
			if( (A.getName().equals(relations.get(i).getNode_A()) 
					&& B.getName().equals(relations.get(i).getNode_B()) )
						|| ( B.getName().equals(relations.get(i).getNode_A()) 
							&& A.getName().equals(relations.get(i).getNode_B()) ) ){
				return relations.get(i).getWeight();
			}
					 
		}
		
		return 0.0;
	}
	
	//根据节点名称获得节点
	public static Node getNodeByName(String name,List<Node> nodes) {
		for(int i=0;i<nodes.size();i++) {
			if(name.equals(nodes.get(i).getName()))
				return nodes.get(i);
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		/*Node A=new Node("A",1,1);
		Node B=new Node("C",3,3);
		Node C=new Node("B",6,6);
		List<Node> nodes=new ArrayList<>();
		nodes.add(A);
		nodes.add(B);
		nodes.add(C);
		System.out.println(isAbut(B, C, nodes));*/
		
		List<Node> nodes=NodesUtil.randomNodes(5);
		List<NodeRelation> relations=NodesUtil.getAllWeight(nodes);
		System.out.println(NodesUtil.getWeight(nodes.get(0), nodes.get(2), relations));
		
		//List<NodeRelation> relations2=NodesUtil.getAllWeight(nodes);
		System.out.println(NodesUtil.getAllWeight(nodes).size());
		
		
	}
	
	
}
