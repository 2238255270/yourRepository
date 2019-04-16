package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.TestCase;
import com.model.TestCaseTotal;
import com.service.TestCaseDaoImpl;


public class JsonServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TestCaseDaoImpl testCaseDaoImpl=new TestCaseDaoImpl();
        List<TestCase> list=testCaseDaoImpl.getCaseAll();
        List<TestCase> list1 =new ArrayList<>();
        int size =list.size();
        TestCase testCase;
        for(int i=0;i<size;i++){
            testCase=new TestCase();
            testCase.setId(list.get(i).getId());
            testCase.setCaseName(list.get(i).getCaseName());
            testCase.setCaseDetail(list.get(i).getCaseDetail());
            list1.add(testCase);
            
        }
        
        String page = req.getParameter("page");
        // 将数据添加到数组
        List<TestCase> caselist = new ArrayList<TestCase>();
   
        //代码做分页
		
        if (page == null || page.equals("0")) {
            if(list1.size()>9){
                for(int i=0;i<10;i++){
                    caselist.add(list1.get(i));
                }
            }
            else{
                for(int i=0;i<list1.size();i++){
                    caselist.add(list1.get(i));
                }
            }
            
        }
        else {
            int caseSize=list1.size();
            int page1 =caseSize/10;
            
            int pageNum=Integer.parseInt(page);
            //String parm=Integer.toString(a);
            if(pageNum<page1){
                for(int i=10*pageNum;i<10*pageNum+10;i++){
                    caselist.add(list1.get(i));
                }
            }
            else{
                for(int i=10*pageNum;i<list1.size();i++){
                    caselist.add(list1.get(i));
                }
            }
            
        }
                
        TestCaseTotal nt = new TestCaseTotal(caselist.size(), caselist);
        // 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		
        
        Gson gson = new Gson();
        String json = gson.toJson(nt);

        // 输出到界面
        System.out.println(json);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("gb2312");
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.print(json);
        out.flush();
      
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
