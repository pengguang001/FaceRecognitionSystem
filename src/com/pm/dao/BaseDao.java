package com.pm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.pm.utils.ConfigManager;

/**
 * 这个类用于获取数据库连接，给实现类继承使用
 * 
 * @ClassName DishesType
 * @Description: 菜系类型标示
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47
 * @version 1.0
 */
public class BaseDao {
	protected Connection con; // 数据库连接
	protected Statement cst = null;
	protected PreparedStatement pst; // 数据库表达式(PreparedStatement接口,继承了Statement)
	protected ResultSet rs; // 结果集
	protected static String TAG = "BaseDao";
	//protected static Logger logger = Logger.getLogger(TAG);
    /*logger.debug("This is debug message");

    logger.info("This is info message");

    logger.warn("This is warn message");

    logger.fatal("This is fatal message");

    logger.error("This is error message");*/
	/**
	 * 获取数据库连接
	 * 
	 * @return boolean(true or false)
	 * @exception ClassNotFoundException
	 *                SQLException
	 */
	public boolean getConnection() {

		// 读出ConfigManager类的配置信息
		String driver = ConfigManager.getInstance().getString("jdbc.driver");
		String url = ConfigManager.getInstance().getString(
				"jdbc.connection.url");
		String username = ConfigManager.getInstance().getString(
				"jdbc.connection.username");
		String password = ConfigManager.getInstance().getString(
				"jdbc.connection.password");
		try {
			// 加载JDBC驱动
			Class.forName(driver);
			// 与数据库存建立连接
			con = DriverManager.getConnection(url, username, password);
			System.out.println("加载驱动名称：" + driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void createTables2(String userTableSql, String deviceTableSql) {
		if (getConnection()) {
			try {
				cst = con.createStatement();
				boolean i1 = cst.execute(userTableSql);
			    boolean i2 = cst.execute(deviceTableSql);
				//pst = con.prepareStatement(userTableSql);
				//pst = con.prepareStatement(deviceTableSql);
				if (i1) {
					System.out.println("用户表创建成功！"+i1);
				}else{
					System.out.println("用户表创建失败！"+i1);
				}
				if(i2) {
					System.out.println("设备表创建成功！"+i2);
				}else {
					System.out.println("设备表创建失败！"+i2);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResource();
			}
		}
	}
	public void createTables(String userTableSql, String deviceTableSql) {
		if (getConnection()) {
			try {
				pst = con.prepareStatement(userTableSql);
				boolean b1 = pst.execute();
				pst = con.prepareStatement(deviceTableSql);
			    boolean b2 = pst.execute();
				//pst = con.prepareStatement(userTableSql);
				//pst = con.prepareStatement(deviceTableSql);
			    
				if (b1) {
					System.out.println("用户表创建成功！");
				}else{
					System.out.println("用户表创建失败！");
				}
				if(b2) {
					System.out.println("设备表创建成功！");
				}else {
					System.out.println("设备表创建失败！");
				}

			} catch (SQLException e) {
				System.out.println("e:"+e);
				e.printStackTrace();
			} finally {
				closeResource();
			}
		}
	}

	/**
	 * 增加，删除，修改 增 删 改 delete from 表 where id=? and name=?
	 * 
	 * @param sql
	 * @param params
	 * @return int
	 * @exception SQLException
	 */
	public int executeUpdate_a(String sql, Object... params) {
		int updateRows = 0;

		if (getConnection()) {
			try {
				pst = con.prepareStatement(sql);// 通过连接后，进行sql语句查询结果
				// 填充占位符
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						pst.setObject(i + 1, params[i]);
					}
				}
				updateRows = pst.executeUpdate();// 增，删，改所受影响的行
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResource();
			}
		}
		return updateRows;
	}

	/**
	 * 增加，删除，修改 增 删 改 delete from 表 where id=? and name=?
	 * 
	 * @param sql
	 * @param params
	 * @return int
	 * @exception SQLException
	 */
	public int executeUpdate(String sql, Object... params) {
		int updateRows = 0;
		if (getConnection()) {
			try {
				pst = con
						.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// 通过连接后，进行sql语句查询结果
				con.setAutoCommit(false);
				// 填充占位符
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						pst.setObject(i + 1, params[i]);
					}
				}
				// updateRows = pst.executeUpdate();// 增，删，改所受影响的行
				pst.executeUpdate();
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					updateRows = rs.getInt(1);
					// System.out.println(rs.getInt(1));
				}
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResource();
			}
		}
		return updateRows;
	}

	/**
	 * 获取新生成定单记录的主键 静态SQL模式，获取新增记录的主键
	 * 
	 * @param sql
	 * @param params
	 * @return int
	 * @exception SQLException
	 */
	public int insertWithStaticSQL(String sql, Object... params) {
		int id = 0;
		if (getConnection()) {
			try {
				pst = con
						.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pst.executeUpdate();
				// 检索由于执行此 Statement 对象而创建的所有自动生成的键
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					// 知其仅有一列，故获取第一列
					id = rs.getInt(1);
					System.out.println("-----静态SQL模式-----id = " + id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResource();
			}
		}
		return id;
	}

	/**
	 * 查询结果
	 * 
	 * @param sql
	 * @param params
	 * @return resultset 返回结果集
	 * @exception SQLException
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		if (getConnection()) {
			try {
				pst = con.prepareStatement(sql); // 通过连接后，进行sql语句查询结果
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						pst.setObject(i + 1, params[i]);
					}
					rs = pst.executeQuery(); // 结果集查询方法

					System.out.println("====rs" + rs.toString());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;// 返回结果集
	}

	/**
	 * 关闭资源
	 * 
	 * @return boolean(true or false)
	 * @exception SQLException
	 */
	public boolean closeResource() {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if(cst !=null)
				cst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
