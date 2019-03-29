package cn.jxy.sdnweb.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 路径类
 *
 */
public class Routes implements Serializable{
	private int id;//路径编号
	private String route; //路径
	private List<Double> weights=new ArrayList<>();//路径上节点间权值
	private double length;//路径长度
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public List<Double> getWeights() {
		return weights;
	}
	public void setWeights(List<Double> weights) {
		this.weights = weights;
	}
	public double getLength() {
		BigDecimal bg = new BigDecimal(length);  
		return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();		
	}
	public void setLength(double length) {
		this.length = length;
	}
	@Override
	public String toString() {
		BigDecimal bg = new BigDecimal(length);  
		return "Routes [id=" + id + ", route=" + route + ", weights=" + weights + ", length=" 
				+ bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "]";
	}
	
}
