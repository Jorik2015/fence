package com.abner.model;

import java.util.LinkedList;

public class Stock {
	private String stockNo;
	private String name;
	private double price;

	private LinkedList<Double> hisPrice = new LinkedList<Double>();

	public String getStockNo() {
		return stockNo;
	}

	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LinkedList<Double> getHisPrice() {
		return hisPrice;
	}

	public void setHisPrice(LinkedList<Double> hisPrice) {
		this.hisPrice = hisPrice;
	}
}
