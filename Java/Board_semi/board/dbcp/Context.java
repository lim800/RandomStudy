package lim.board.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class Context {
	public BasicDataSource basicDataSource;

	public Context() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@192.168.0.121:1521:xe");
		basicDataSource.setUsername("denver");
		basicDataSource.setPassword("1234");
		basicDataSource.setInitialSize(4);
		basicDataSource.setMaxIdle(100);
		basicDataSource.setMinIdle(5);

	}

}
