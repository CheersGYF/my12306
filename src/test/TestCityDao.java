package test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.neuedu.my12306.dao.ICityDao;
import com.neuedu.my12306.dao.impl.CityDaoImpl;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.utils.DBUtil;



public class TestCityDao {
	private Logger logger = Logger.getRootLogger();
	// 注解语法 org.junit.Test是一个注解类
	@Test
	public void testFindCity(){
		// 注册驱动打开连接
		Connection connection = DBUtil.openConnection();
		
		ICityDao cityDao = new CityDaoImpl();
		cityDao.setConnection(connection);
		
		int id = 30;
		String provinceId ="410000";
		City city = cityDao.findCityById(id);
		List<City> list = cityDao.findByProvince(provinceId);
		if(city != null){
			logger.info("查询用户成功:"+city.getCity());
			logger.info("查询用户成功:"+list.size());
			Iterator<City> iterator = list.iterator();
			while(iterator.hasNext()){
				logger.info(iterator.next().getCity());
			}
					
		}else{
			logger.info("参数错误！");
		}
		
		
		// 关闭连接
		DBUtil.colseAll(connection, null, null);
	}
}
