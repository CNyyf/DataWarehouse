package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMovieDimension {
	private String productid = "";
	private String timeid = "00000000";
	private String moviename = "";
	private String movieversion = "";
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getTimeid() {
		return timeid;
	}
	public void setTimeid(String timeid) {
		this.timeid = timeid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovieversion() {
		return movieversion;
	}
	public void setMovieversion(String movieversion) {
		this.movieversion = movieversion;
	}

	public void setMain(ResultSet rs) {
		try {
			this.productid = rs.getString("productid");
			this.timeid = rs.getString("timeid");
			this.moviename = rs.getString("moviename");
			this.movieversion = rs.getString("movieversion");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
