package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DsConfigWithProp {
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String jdbcUrl;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		// ....
		return ds;
	}
	

}
