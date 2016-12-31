package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import dbc.DatabaseConnection;

public class CountMoviesDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;
	
	static public final int EXCEPTION = -1;
	static public final int SUCCESS = 1;
	static public final int FAILED = -2;

	public CountMoviesDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int countMoviesByRand(ArrayList<Long> timeCountList, ArrayList<Long> movieCountList, String in_moviename, String in_year, String in_month, String in_day, String in_season, String in_dayofweek, String in_typename, String in_directorname, String in_starname, String in_actorname) {
		int message = FAILED;
		try {
			dbconn = new DatabaseConnection();
			conn = dbconn.getConnection();
			String sql = "call dwmovie.count_movies_by_rand(?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, Types.BIGINT);
			if(in_moviename == null) cstmt.setNull(2, Types.VARCHAR);
			else cstmt.setString(2, in_moviename);
			if(in_year == null) cstmt.setNull(3, Types.CHAR);
			else cstmt.setString(3, in_year);
			if(in_month == null) cstmt.setNull(4, Types.CHAR);
			else cstmt.setString(4, in_month);
			if(in_day == null) cstmt.setNull(5, Types.CHAR);
			else cstmt.setString(5, in_day);
			if(in_season == null) cstmt.setNull(6, Types.CHAR);
			else cstmt.setString(6, in_season);
			if(in_dayofweek == null) cstmt.setNull(7, Types.CHAR);
			else cstmt.setString(7, in_dayofweek);
			if(in_typename == null) cstmt.setNull(8, Types.VARCHAR);
			else cstmt.setString(8, in_typename);
			if(in_directorname == null) cstmt.setNull(9, Types.VARCHAR);
			else cstmt.setString(9, in_directorname);
			if(in_starname == null) cstmt.setNull(10, Types.VARCHAR);
			else cstmt.setString(10, in_starname);
			if(in_actorname == null) cstmt.setNull(11, Types.VARCHAR);
			else cstmt.setString(11, in_actorname);
			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			movieCountList.clear();
			if(rs != null) {
				if(rs.next()) {
					movieCountList.add(rs.getLong(1));
				}
			}
			if(movieCountList.size() == 0) {
				movieCountList.add((long) 0);
			}
			timeCountList.clear();
			timeCountList.add(Math.abs(cstmt.getLong(1)));
			message = SUCCESS;
		} catch (Exception e) {
			message = EXCEPTION;
			e.printStackTrace();
		}
		finally {
			try {
				dbconn.close();
			} catch (Exception e) {
				message = EXCEPTION;
				e.printStackTrace();
			}
		}
		return message;
	}
}
