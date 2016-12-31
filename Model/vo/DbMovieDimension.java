package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMovieDimension {
	//From Table dwmovie.movie_dimension
	private String productid = "";
	private String timeid = "00000000";
	private String moviename = "";
	private String movieversion = "";
	//From Table dwmovie.time_dimension
	private String year = "0000";
	private String month = "00";
	private String day = "00";
	private String season = "0";
	private String dayofweek = "0";
	
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

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
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
	
	public void computeTime() {
		if(timeid != null && !timeid.equals("00000000") && timeid.length() == 8) {
			year = timeid.substring(0, 4);
			month = timeid.substring(4, 6);
			day = timeid.substring(6, 8);
			int y = Integer.parseInt(year);
			int m = Integer.parseInt(month);
			int d = Integer.parseInt(day);
			switch(m) {
			case 1:
			case 2:
			case 3:
				season = "1";
				break;
			case 4:
			case 5:
			case 6:
				season = "2";
				break;
			case 7:
			case 8:
			case 9:
				season = "3";
				break;
			case 10:
			case 11:
			case 12:
				season = "4";
				break;
			}
			if(m==1) {
				m=13;
				y--;
			}
			if(m==2) {
				m=14;
				y--;
			}
			dayofweek = Integer.toString((d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7 + 1);
		}
	}
}
