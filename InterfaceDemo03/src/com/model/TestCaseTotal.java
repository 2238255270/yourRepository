package com.model;

import java.util.List;

/*
 *新建一个分页实体类，以便后期数据做分页
 * 
 */
public class TestCaseTotal {

	private int total;
	private List<TestCase> rows;

	public TestCaseTotal() {
		super();
	}
	public TestCaseTotal(int total, List<TestCase> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<TestCase> getRows() {
		return rows;
	}
	public void setRows(List<TestCase> rows) {
		this.rows = rows;
	}
		
}
