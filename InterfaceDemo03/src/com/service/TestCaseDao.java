package com.service;

import java.util.List;

import com.model.TestCase;

/*
 * 基础数据写到接口里面
 * 
 */
public interface TestCaseDao {
	public List<TestCase> getCaseAll();
	public boolean addCase(TestCase testCase);
	public boolean deleteCase(int id);
	public boolean updateCase(TestCase testCase);
	
}
