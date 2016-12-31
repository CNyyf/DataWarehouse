package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import dbc.DatabaseConnection;

public class ATest {

	public static int getTypes() {
		DatabaseConnection dbconn = null;
		try {
			dbconn = new DatabaseConnection();
			Connection conn = dbconn.getConnection();
			String sql = "SELECT * FROM dwmovie.type_dimension";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					System.out.println(rs.getString("typename"));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				dbconn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static int count_time_test_by_state(String state) {
		DatabaseConnection dbconn = null;
		try {
			dbconn = new DatabaseConnection();
			Connection conn = dbconn.getConnection();
			String sql = "call test.time_count_test_by_state(?,?)";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, state);
			cstmt.registerOutParameter(2, Types.BIGINT);
			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			if(rs != null) {
				System.out.println("state_count:");
				while(rs.next()) {
					System.out.println(state + "\t" + rs.getString("count(*)"));
				}
			}
			System.out.println("time count (microsecond):" + cstmt.getLong(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				dbconn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		getTypes();
		/*ArrayList<Long> timeCountList = new ArrayList<Long>();
		ArrayList<Long> movieCountList = new ArrayList<Long>();
		ArrayList<DbMovieDimension> movieList = new ArrayList<DbMovieDimension>();
		String in_moviename = null;//"In the Name of the King: A Dungeon Siege Tale";
		String in_year = null;//"0000";
		String in_month = null;//"00";
		String in_day = null;//"00";
		String in_season = null;//"0";
		String in_dayofweek = null;//"0";
		String in_typename = null;//"Fantasy";
		String in_directorname = null;//"20th Century Fox";
		String in_starname = "Will Ryan";//"Jason Statham";
		String in_actorname = null;//"Aaron Pearl";
		int resultGet = DAOFactory.getGetMoviesDAO().getMoviesByRand(timeCountList, movieList, in_moviename, in_year, in_month, in_day, in_season, in_dayofweek, in_typename, in_directorname, in_starname, in_actorname);
		System.out.println("Get:\nmessage:\t" + resultGet + "\ntime:\t" + ((timeCountList.size()>0) ? timeCountList.get(0):(-1)));
		int resultCount = DAOFactory.getCountMoviesDAO().countMoviesByRand(timeCountList, movieCountList, in_moviename, in_year, in_month, in_day, in_season, in_dayofweek, in_typename, in_directorname, in_starname, in_actorname);
		System.out.println("Count:\nmessage:\t" + resultCount + "\ntime:\t" + ((timeCountList.size()>0) ? timeCountList.get(0):(-1)) + "\ncount:\t" + ((movieCountList.size()>0) ? movieCountList.get(0):(-1)));*/
		/*String[] in_moviename = {null, "In the Name of the King: A Dungeon Siege Tale"};
		String[] in_year = {null, "2010"};
		String[] in_month = {null, "06"};
		String[] in_day = {null, "10"};
		String[] in_season = {null, "2"};
		String[] in_dayofweek = {null, "4"};
		String[] in_typename = {null, "Fantasy"};
		String[] in_directorname = {null, "20th Century Fox"};
		String[] in_starname = {null, "Jason Statham"};
		String[] in_actorname = {null, "Aaron Pearl"};
		try {
			for(int m = 530; m != 1024; m++) {
				BufferedWriter output = new BufferedWriter(new FileWriter("F:/同济大学/数据仓库技术/课程设计/data/testProcedure", true));
				JSONObject json = new JSONObject();
				int j = m%2;
				int i = (m>>1)%2;
				int h = (m>>2)%2;
				int g = (m>>3)%2;
				int f = (m>>4)%2;
				int e = (m>>5)%2;
				int d = (m>>6)%2;
				int c = (m>>7)%2;
				int b = (m>>8)%2;
				int a = (m>>9)%2;
				json.put("in_moviename", a);
				json.put("in_year", b);
				json.put("in_month", c);
				json.put("in_day", d);
				json.put("in_season", e);
				json.put("in_dayofweek", f);
				json.put("in_typename", g);
				json.put("in_directorname", h);
				json.put("in_starname", i);
				json.put("in_actorname", j);
				json.put("input", "[1]" + a + " [2]" + b + " [3]" + c + " [4]" + d + " [5]" + e + " [6]" + f + " [7]" + g + " [8]" + h + " [9]" + i + " [10]" + j);
				int resultGet = DAOFactory.getGetMoviesDAO().getMoviesByRand(timeCountList, movieList, in_moviename[a], in_year[b], in_month[c], in_day[d], in_season[e], in_dayofweek[f], in_typename[g], in_directorname[h], in_starname[i], in_actorname[j]);
				json.put("getTimeCount", ((timeCountList.size()>0) ? timeCountList.get(0):(-1)));
				json.put("getMovieCount", movieList.size());
				json.put("getResult", resultGet);
				int resultCount = DAOFactory.getCountMoviesDAO().countMoviesByRand(timeCountList, movieCountList, in_moviename[a], in_year[b], in_month[c], in_day[d], in_season[e], in_dayofweek[f], in_typename[g], in_directorname[h], in_starname[i], in_actorname[j]);
				json.put("countTimeCount", ((timeCountList.size()>0) ? timeCountList.get(0):(-1)));
				json.put("countMovieCount", ((movieCountList.size()>0) ? movieCountList.get(0):(-1)));
				json.put("countResult", resultCount);
				output.write(json.toString() + "\n");
				System.out.println(m);
				output.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.print("");
	}

}
