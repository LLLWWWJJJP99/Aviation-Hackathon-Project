package util;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {
	
	private static DataSource dataSource;
	
	static{
		try{
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			dataSource = factory.createDataSource(props);
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
}
