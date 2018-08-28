package util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
	//private static ComboPooledDataSource dataSource;
	public final String dirver = "oracle.jdbc.driver.OracleDriver";
	public final String url = "jdbc:oracle:thin:@140.143.225.201:1521:orcl";
	public final String name = "scott";
	public final String pass = "w351565056";
	Class<T> clazz;
	//反射获得clazz
	/*static {
		try {
			dataSource = new ComboPooledDataSource();
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	@SuppressWarnings("unchecked")
	public BaseDao() {
		clazz = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	// 创建连接
	public Connection createConn() {
		Connection conn = null;
		try {
			// 1、加载驱动
			Class.forName(dirver);
			// 2、创建连接connection
			conn = DriverManager.getConnection(url, name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭一切
	public void closeAll(ResultSet rs, Statement stat, Connection conn) {
		// 6、关闭一切
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭一切
	public void closeAll(Statement stat, Connection conn) {
		// 6、关闭一切
		try {
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DML
	public int executeUpdate(String sql, Object[] obj) {
		Connection conn = null;
		PreparedStatement stat = null;
		int ret = 0;
		try {
			conn = createConn();
			// 3、创建传输对象statmemnt
			stat = conn.prepareStatement(sql);// ？不确定:类型、数量
			// 3+、绑定替换数据
			for (int i = 0; i < obj.length; i++) {
				stat.setObject(i + 1, obj[i]);
			}
			// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
			ret = stat.executeUpdate();
			// 5、如果返回rs类型的数据，需要将数据转换成list
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(stat, conn);
		}
		return ret;
	}
	// DQL
		public List<T> executeQuery(String sql, Object[] obj) {
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			List<T> list = new ArrayList<T>();
			try {
				conn = createConn();
				// 3、创建传输对象statmemnt
				stat = conn.prepareStatement(sql);// ？不确定:类型、数量
				// 3+、绑定替换数据
				for (int i = 0; i < obj.length; i++) {
					stat.setObject(i + 1, obj[i]);
				}
				// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
				rs = stat.executeQuery();//select count(*)
				// 5、如果返回rs类型的数据，需要将数据转换成list
				ResultSetMetaData rsmd = rs.getMetaData();//列名信息
				int columuCount = rsmd.getColumnCount();//列的数量
				while (rs.next()) {
					T t = (T) clazz.newInstance();//创建对象
					for (int i = 0; i < columuCount; i++) {//封装数据
						Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
						f.setAccessible(true);
						f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
					}
					list.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs,stat, conn);
			}
			return list;
		}
		// DQL
		public List<T> executeQuery(String sql) {
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			List<T> list = new ArrayList<T>();
			try {
				conn = createConn();
				// 3、创建传输对象statmemnt
				stat = conn.prepareStatement(sql);// ？不确定:类型、数量
				// 3+、绑定替换数据
				// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
				rs = stat.executeQuery();
				// 5、如果返回rs类型的数据，需要将数据转换成list
				ResultSetMetaData rsmd = rs.getMetaData();//列名信息
				int columuCount = rsmd.getColumnCount();//列的数量
				while (rs.next()) {
					T t = (T) clazz.newInstance();//创建对象
					for (int i = 0; i < columuCount; i++) {//封装数据
						Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
						f.setAccessible(true);
						f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
					}
					list.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs,stat, conn);
			}
			return list;
		}
}
