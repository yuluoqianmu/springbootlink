package com.maolin.linkshiro.utils;

import java.sql.*;


/**
 * 把数据表转换成java类的工具类
 * @author luyongzhao
 *
 */
public class Table2JavaTool {

	/**
	 * 获取从数据库反射生成的java类
	 * @param tableName
	 * @return
	 */
	public static String getJavaClassStr(String tableName, String paramType){
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		
		String sql = "SHOW FULL COLUMNS FROM "+tableName;
		String className = FieldsUtil.getJavaClassName(tableName, paramType);
		StringBuilder builder = new StringBuilder("");
		builder.append("@Data\n");
		builder.append("@ApiModel(value = \"").append(className).append("\", description = \"\")\n");
		builder.append("public class ").append(className).append("{\n\n");
		
		try {
			//驱动程序名
			String driver = "com.mysql.cj.jdbc.Driver";
			//URL指向要访问的数据库名mydata
			String url = "jdbc:mysql://localhost:3306/linkshiro?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&nullNamePatternMatchesAll=true";
			//MySQL配置时的用户名
			String user = "root";
			//MySQL配置时的密码
			String password = "root";
			conn = DriverManager.getConnection(url,user,password);
			stat = conn.prepareStatement(sql);
			result = stat.executeQuery();
			while(result.next()){
				String fieldName = result.getString("Field");
				String type = result.getString("Type");
				String comment = result.getString("Comment");
				/*添加注释*/
				builder.append("\t/*").append(comment).append("*/\n");
				//插入swagger注解
				builder.append("\t@ApiModelProperty(").append("\"").append(comment).append("\")\n");
				/*插入属性*/
				builder.append("\t").append("private ").append(FieldsUtil.getJavaTypeFromSqlType(type))
				.append(" ").append(FieldsUtil.getJavaClassAttr(fieldName)).append(";\n\n");
			}
			builder.append("}");
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally{
			close(result, stat, conn);
		}
		
		return builder.toString();
	}
	
	
	
	private static void close(ResultSet result, PreparedStatement stat, Connection conn) {

		try {
			if (result != null) {
				result.close();
				result = null;
			}

			if (stat != null) {
				stat.close();
				stat = null;
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void main(String args[]){
		
//		System.out.println(Table2JavaTool.getJavaClassStr("zu_ke"));
		System.out.println(Table2JavaTool.getJavaClassStr("permission", "resp"));
	}
}
