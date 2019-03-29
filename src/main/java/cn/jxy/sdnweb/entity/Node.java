package cn.jxy.sdnweb.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * 节点类
 *
 */
@Entity
@Table(name = "tb_node")
public class Node implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length=10)
	private String name;
	@Column(length=5)
	private int x;
	@Column(length=5)
	private int y;	
	@Transient
	public List<Node> relationNodes = new ArrayList<Node>();  
	
	public Node() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public List<Node> getRelationNodes() {
		return relationNodes;
	}
	
	@JsonBackReference
	public void setRelationNodes(List<Node> relationNodes) {
		this.relationNodes = relationNodes;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", x=" + x + ", y=" + y +"]";
	}
	
}
