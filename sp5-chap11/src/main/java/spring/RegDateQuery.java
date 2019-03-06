package spring;

public class RegDateQuery {
	
	private String query;
	private static final String testQuery = "select * from MEMBER where REGDATE between ? and ? order by REGDATE desc";
	
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return query;
	}
	
	public static String getTestQuery() {
		return testQuery;
	}

}
