package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 编写数据库工具类
 * 
 */
public class DBconn {

	static String url = "jdbc:mysql://localhost:3306/test?useunicuee=true& characterEncoding=utf8";
	static String username ="root";
	static String password ="root";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	
	//SQL驱动程序初始化
	public static void init() throws Exception{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				System.out.println("init [SQL驱动程序初始化失败！]");
				e.printStackTrace();
			}	
		
	}
	
	//sql数据库增删改异常
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql数据库增删改查异常");
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	//SQL数据库查询异常
	public static ResultSet selectSql(String sql){
	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("SQL数据库查询异常");
			e.printStackTrace();
		}
		
		return rs;	
	}
	
	//sql数据库关闭异常
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}	
	}
	
}
