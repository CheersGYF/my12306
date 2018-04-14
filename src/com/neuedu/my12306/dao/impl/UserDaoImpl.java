package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.my12306.dao.IUserDao;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.utils.DBUtil;

public class UserDaoImpl implements IUserDao{
	private Connection conn;
	/**
	 * 设置jdbc连接
	 * @param conn jdbc连接
	 */
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn = conn;
	}
	
	/**
	 * 使用基本数据类型，传递多个参数
	 * @param userName 用户名
	 * @param password 用户密码
	 * @return 返回User类型对象
	 */
	@Override
	public User findUserByPassword(String userName, String password) {
		User user = new User();
		PreparedStatement statement =null;
		ResultSet rSet = null;
		String sql = "select * from tab_user where userName = ? and password = ?";
		try {
			// 打开状态连接， PreparedStatement 可防止sql注入攻击
			statement = conn.prepareStatement(sql);
			// 如果有参数需要进行参数填充
			statement.setString(1, userName);
			statement.setString(2, password);
			
			rSet = statement.executeQuery();
			
			while(rSet.next()){ // next取出一行数据保存到rs中，并返回true ；如果娶不到数据直接返回false
				// 取出每一列数据，并封装到对象中 
				int id = rSet.getInt(1); // rSet 获取数据可以根据列号获取，注意列号的起始值为1
				// user.setId(rSet.getInt(1));
				String uName = rSet.getString("userName");
				String pword = rSet.getString("password");
				String rule = rSet.getString("rule");
				String sex = rSet.getString("sex");
				int city = rSet.getInt("city");
				String realName = rSet.getString("realName");
				int certType = rSet.getInt("cert_Type");
				String cert = rSet.getString("cert");
				Date birthday = rSet.getTimestamp("birthday"); // 使用TimeStamp时间戳，时间精度到毫秒级别；
				int userType = rSet.getInt("user_Type");
				String content = rSet.getString("content");
				String status = rSet.getString("status");
				String loginIp = rSet.getString("login_IP"); // oracle数据库列表对大小写不敏感
				String imagePath = rSet.getString("image_Path");
				user = new User(id,uName,pword,rule,sex,city,realName,
						certType,cert,birthday,userType,content,status,loginIp,imagePath);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			// 注意从小到大进行关闭
			DBUtil.colseAll(null, statement, rSet);
		}
		return user;
	}
	
	/**
	 * 使用对象类型，传递一个包装类型
	 * @param user User型用户对象
	 * @return 返回User类型对象
	 */
	@Override
	public User findUserByPassword(User user) {
		// TODO Auto-generated method stub
		ResultSet rSet = null;
		PreparedStatement statement = null;
		String sql = "select * from tab_user where userName = ? and password = ?";
		User user2 =null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				user2=new User();
				user2.setId(rSet.getInt("id"));
				user2.setUserName(rSet.getString("userName"));
				user2.setPassword(rSet.getString("password"));
				user2.setRule(rSet.getString("rule"));
				user2.setSex(rSet.getString("sex"));
				user2.setCity(rSet.getInt("city"));
				user2.setRealName(rSet.getString("realName"));
				user2.setCert(rSet.getString("cert")) ;
				user2.setCertType(rSet.getInt("cert_type"));
				user2.setBirthday(rSet.getTimestamp("birthday"));
				user2.setUserType(rSet.getInt("user_type"));
				user2.setContent(rSet.getString("content"));
				user2.setStatus(rSet.getString("status"));
				user2.setLoginIp(rSet.getString("login_IP"));
				user2.setImagePath(rSet.getString("image_Path"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.colseAll(null, statement, rSet);
		}
		return user2;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		// 声明结果集
		ResultSet rSet = null;
		// 声明preparedStatement对象
		PreparedStatement statement = null;
		// 创建sql语句字符串
		String sql = "select * from tab_user";
		// 声明一个空集合
		// 如果声明了null记得在获取数据是进行实例化，只有实例化的对象才能执行get/set方法
		List<User> list = new ArrayList<>(); 
		try {
			// 打开状态连接， PreparedStatement 可防止sql注入攻击
			statement = conn.prepareStatement(sql);
			// 执行sql语句，并将执行结果返回给rSet
			rSet = statement.executeQuery();
			 // next取出一行数据保存到rs中，并返回true；如果取不到数据直接返回false
			while(rSet.next()){
				// 取出每一列数据，并封装到对象中 
				int id = rSet.getInt(1); // rSet 获取数据可以根据列号获取，注意列号的起始值为1
				// user.setId(rSet.getInt(1));
				String uName = rSet.getString("userName");
				String pword = rSet.getString("password");
				String rule = rSet.getString("rule");
				String sex = rSet.getString("sex");
				int city = rSet.getInt("city");
				String realName = rSet.getString("realName");
				int certType = rSet.getInt("cert_Type");
				String cert = rSet.getString("cert");// 此转换方法已经封装到了工具类中
				// 使用TimeStamp时间戳，时间精度到毫秒级别；
				Date birthday = rSet.getTimestamp("birthday"); 
				int userType = rSet.getInt("user_Type");
				String content = rSet.getString("content");
				String status = rSet.getString("status");
				String loginIp = rSet.getString("login_IP"); // oracle数据库列表对大小写不敏感
				String imagePath = rSet.getString("image_Path");
				
				// 把数据封装到一个对象中
				User user = new User(id,uName,pword,rule,sex,city,realName,
						certType,cert,birthday,userType,content,status,loginIp,imagePath);
				// 把对象保存到一个集合中
				list.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			// 注意从小到大进行关闭
			DBUtil.colseAll(null, statement, rSet);
		}
		// 返回封装后的结果集
		return list;
	}

	@Override
	public List<User> findByPage(int page, int size) {
		// 声明结果集
		ResultSet rSet = null;
		// 声明preparedStatement对象
		PreparedStatement statement = null;
		// 创建sql语句字符串
		String sql = "select * "
				+ "from (select rownum rn, b.*"
				+ "from(select * from tab_user order by id) b)"
				+ "where rn <=? and rn>?";
		
		// 声明一个空集合
		// 如果声明了null记得在获取数据是进行实例化，只有实例化的对象才能执行get/set方法
		List<User> list = new ArrayList<>(); 
		try {
			// 打开状态连接， PreparedStatement 可防止sql注入攻击
			statement = conn.prepareStatement(sql);
			statement.setInt(1, page*size);
			statement.setInt(2, (page-1)*size);
			// 执行sql语句，并将执行结果返回给rSet
			rSet = statement.executeQuery();
			 // next取出一行数据保存到rs中，并返回true；如果取不到数据直接返回false
			while(rSet.next()){
				// 取出每一列数据，并封装到对象中 
				int id = rSet.getInt(1); // rSet 获取数据可以根据列号获取，注意列号的起始值为1
				// user.setId(rSet.getInt(1));
				String uName = rSet.getString("userName");
				String pword = rSet.getString("password");
				String rule = rSet.getString("rule");
				String sex = rSet.getString("sex");
				int city = rSet.getInt("city");
				String realName = rSet.getString("realName");
				int certType = rSet.getInt("cert_Type");
				String cert = rSet.getString("cert");// 此转换方法已经封装到了工具类中
				// 使用TimeStamp时间戳，时间精度到毫秒级别；
				Date birthday = rSet.getTimestamp("birthday"); 
				int userType = rSet.getInt("user_Type");
				String content = rSet.getString("content");
				String status = rSet.getString("status");
				String loginIp = rSet.getString("login_IP"); // oracle数据库列表对大小写不敏感
				String imagePath = rSet.getString("image_Path");
				
				// 把数据封装到一个对象中
				User user = new User(id,uName,pword,rule,sex,city,realName,
						certType,cert,birthday,userType,content,status,loginIp,imagePath);
				// 把对象保存到一个集合中
				list.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			// 注意从小到大进行关闭
			DBUtil.colseAll(null, statement, rSet);
		}
		// 返回封装后的结果集
		return list;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement statement =null;
		String sql = "insert into tab_user values(tab_user_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			//statement.setInt(1, user.getId());
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRule());
			statement.setString(4, user.getRealName());
			statement.setString(5, user.getSex());
			statement.setInt(6, user.getCity());
			statement.setInt(7, user.getCertType());
			statement.setString(8, user.getCert());
			// 存入年月日时分秒
			// statement.setTimestamp(10, new Timestamp(user.getBirthday().getTime()));
			// 存入年月日
			statement.setDate(9, new java.sql.Date(user.getBirthday().getTime()));
			statement.setInt(10, user.getUserType());
			statement.setString(11, user.getContent());
			statement.setString(12, user.getStatus());
			statement.setString(13, user.getLoginIp());
			statement.setString(14, user.getImagePath());
			if(statement.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}finally{
			DBUtil.colseAll(conn, null, null);
		}
	}

	@Override
	public boolean editUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement statement =null;
		boolean result = false;
		String sql=("update tab_user set userName=?,Password=?,Rule=?,"
				+ "RealName=?, Sex=?,City=?,Cert_Type=?,Cert=?,Birthday=?,User_Type=?,"
				+ "Content=?,Status=?,Login_Ip=?,Image_Path=?"
				+ "where id = ?");
			
		try {
			if (!user.equals(null)) {
				statement = conn.prepareStatement(sql);
				
				statement.setInt(15, user.getId());
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getRule());
				statement.setString(4, user.getRealName());
				statement.setString(5, user.getSex());
				statement.setInt(6, user.getCity());
				statement.setInt(7, user.getCertType());
				statement.setString(8, user.getCert());
				// 存入年月日时分秒
				// statement.setTimestamp(10, new Timestamp(user.getBirthday().getTime()));
				// 存入年月日
				statement.setDate(9, new java.sql.Date(user.getBirthday().getTime()));
				statement.setInt(10, user.getUserType());
				statement.setString(11, user.getContent());
				statement.setString(12, user.getStatus());
				statement.setString(13, user.getLoginIp());
				statement.setString(14, user.getImagePath());
				if(statement.executeUpdate()>0){
					result=true;
				}else{
					result= false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}finally{
			DBUtil.colseAll(null, statement, null);
		}
		return result;
	}
	
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		User user = null;
		PreparedStatement statement =null;
		ResultSet rSet = null;
		String sql = "select * from tab_user where id = ?";
		try {
			// 打开状态连接， PreparedStatement 可防止sql注入攻击
			statement = conn.prepareStatement(sql);
			// 如果有参数需要进行参数填充
			statement.setInt(1, id);
			
			rSet = statement.executeQuery();
			
			while(rSet.next()){ // next取出一行数据保存到rs中，并返回true ；如果娶不到数据直接返回false
				// 取出每一列数据，并封装到对象中 
				int uid = rSet.getInt(1); // rSet 获取数据可以根据列号获取，注意列号的起始值为1
				// user.setId(rSet.getInt(1));
				String uName = rSet.getString("userName");
				String pword = rSet.getString("password");
				String rule = rSet.getString("rule");
				String sex = rSet.getString("sex");
				int city = rSet.getInt("city");
				String realName = rSet.getString("realName");
				int certType = rSet.getInt("cert_Type");
				String cert = rSet.getString("cert");
				Date birthday = rSet.getTimestamp("birthday"); // 使用TimeStamp时间戳，时间精度到毫秒级别；
				int userType = rSet.getInt("user_Type");
				String content = rSet.getString("content");
				String status = rSet.getString("status");
				String loginIp = rSet.getString("login_IP"); // oracle数据库列表对大小写不敏感
				String imagePath = rSet.getString("image_Path");
				user = new User(uid,uName,pword,rule,sex,city,realName,
						certType,cert,birthday,userType,content,status,loginIp,imagePath);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			// 注意从小到大进行关闭
			DBUtil.colseAll(null, statement, rSet);
		}
		return user;
	}

	@Override
	public boolean deleteById(int[] ids) {
		PreparedStatement statement =null;
		boolean result =false;
		//一个线程安全的可变字符串 
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tab_user where id= ? ");
		try {
			// 打开状态连接， PreparedStatement 可防止sql注入攻击
			statement = conn.prepareStatement(sql.toString());
			//将一组参数添加到此 PreparedStatement 对象的批处理命令中。
			if (ids.length>0) {
				for(int id : ids){
					statement.setInt(1, id);
					statement.addBatch();
				}
				// 执行删除语句
				statement.executeBatch();
				result = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			// 注意从小到大进行关闭
			DBUtil.colseAll(null, statement, null);
		}
		return result;
	}

	@Override
	public List<User> searchUsers(User user) {
		// TODO Auto-generated method stub
		 PreparedStatement statement = null;
		 ResultSet rSet = null;
		 User user2=null;
		 List<User> list =new ArrayList<>();
		 
		 StringBuffer sql = new StringBuffer("select * from tab_user where 1 = 1");
		 //String regex = "^[A-Za-z0-9_]{6,30}$";
			 int paramCount = 0;// 设置一个变量用于记录搜索条件的个数
			
			 try {
				if (user.getUserName()!=null) {
					sql.append("and username = ?");
					// sql.append("and username = '"+uer.getUserName()+"'");
					// 可以把参数直接拼接到sql中会导致注入攻击
					paramCount++;
				}
				if(user.getPassword()!=null){ // 注意填充参数时，需要跟参数列表顺序--对应
					sql.append("and password=?");
					paramCount++;
				}
				if(user.getCertType()!=0){ // 注意填充参数时，需要跟参数列表顺序--对应
					sql.append("and certtype=?");
					paramCount++;
				}
				statement = conn.prepareStatement(sql.toString());
				// 如果有参数，需要进行参数填充
				if(user.getCertType()!= 0){
					statement.setInt(paramCount--,  user.getCertType());
				}
				if(user.getPassword()!=null){
					statement.setString(paramCount--, user.getPassword());
				}
				if(user.getUserName()!=null){
					statement.setString(paramCount--, user.getUserName());
				}
				rSet = statement.executeQuery();
				
				while(rSet.next()){ // next取出一行数据保存到rs中，并返回true ；如果娶不到数据直接返回false
					//user2.setId(rSet.getInt(1));
					
					int uid = rSet.getInt("id");
					String uName = rSet.getString("userName");
					String pword = rSet.getString("password");
					String rule = rSet.getString("rule");
					String sex = rSet.getString("sex");
					int city = rSet.getInt("city");
					String realName = rSet.getString("realName");
					int certType = rSet.getInt("cert_Type");
					String cert = rSet.getString("cert");
					Date birthday = rSet.getTimestamp("birthday"); // 使用TimeStamp时间戳，时间精度到毫秒级别；
					int userType = rSet.getInt("user_Type");
					String content = rSet.getString("content");
					String status = rSet.getString("status");
					String loginIp = rSet.getString("login_IP"); // oracle数据库列表对大小写不敏感
					String imagePath = rSet.getString("image_Path");
					user2 = new User(uid,uName,pword,rule,sex,city,realName,
							certType,cert,birthday,userType,content,status,loginIp,imagePath);
					list.add(user2);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				// 注意从小到大进行关闭
				DBUtil.colseAll(null, statement, rSet);
			}
		 return list;
	}

	@Override
	public List<User> searchUser(User user, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
