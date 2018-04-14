package test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.neuedu.my12306.dao.IProvinceDao;
import com.neuedu.my12306.dao.impl.ProvinceDaoImpl;
import com.neuedu.my12306.model.Province;
import com.neuedu.my12306.utils.DBUtil;

public class TestProvince {
	private Logger logger = Logger.getRootLogger();
	// 注解语法 org.junit.Test是一个注解类
	@Test
	public void testFindAllProvince(){
		// 注册驱动打开连接
		Connection connection = DBUtil.openConnection();
		
		IProvinceDao provinceDao = new ProvinceDaoImpl();
		provinceDao.setConnection(connection);
		
		List<Province> list = provinceDao.findAllProvince();
		if(list != null){
			logger.info("查询用户成功:"+list.size());
			Iterator<Province> iterator = list.iterator();
			while(iterator.hasNext()){
				logger.info(iterator.next().getProvince());
			}
					
		}else{
			logger.info("参数错误！");
		}
		
		
		// 关闭连接
		DBUtil.colseAll(connection, null, null);
	}
}
