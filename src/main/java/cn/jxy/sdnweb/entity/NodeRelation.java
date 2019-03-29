package cn.jxy.sdnweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * 节点关系类
 *
 */
@Entity
@Table(name = "tb_node_relation")
public class NodeRelation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length=10)
	private String node_A;
	@Column(length=10)
	private String node_B;	
	@Column(length=5)
	private Double weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNode_A() {
		return node_A;
	}
	public void setNode_A(String node_A) {
		this.node_A = node_A;
	}
	public String getNode_B() {
		return node_B;
	}
	public void setNode_B(String node_B) {
		this.node_B = node_B;
	}
	public Double getWeight() {
		BigDecimal bg = new BigDecimal(weight);  
		return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public void setWeight(Double weight) {		  
		this.weight = weight;
	}
	@Override
	public String toString() {
		BigDecimal bg = new BigDecimal(weight);
		return "NodeRelation [id=" + id + ", node_A=" + node_A + ", node_B=" + node_B + ", weight=" 
				+ bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "]";
	}	
	
}
