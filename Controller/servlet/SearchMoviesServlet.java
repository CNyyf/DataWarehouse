package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.DbMovieDimension;

/**
 * Servlet implementation class SearchMoviesServlet
 */
@WebServlet("/SearchMovies")
public class SearchMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("inputJSON");
		if(json == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		json = json.replace("[\n\r]", "");
		System.out.println(json);
		JSONObject jsonSearchParas = JSONObject.fromObject(json);
		String moviename = jsonSearchParas.getString("moviename");
		String year = jsonSearchParas.getString("year");
		String month = jsonSearchParas.getString("month");
		String day = jsonSearchParas.getString("day");
		String dayofweek = jsonSearchParas.getString("dayofweek");
		String season = jsonSearchParas.getString("season");
		String director = jsonSearchParas.getString("director");
		String star = jsonSearchParas.getString("star");
		String actor = jsonSearchParas.getString("actor");
		String type = null;
		JSONArray jsonTypes = jsonSearchParas.getJSONArray("typeList");
		ArrayList<String> typeList = new ArrayList<String>();
		for(int i = 0; i != jsonTypes.size(); i++) {
			typeList.add(jsonTypes.getString(i));
		}
		if(moviename != null && moviename.equals("")) {
			moviename = null;
		}
		if(year != null && year.equals("")) {
			year = null;
		}
		if(month != null) {
			if(month.equals("")) month = null;
			else if(month.length() == 1) month = "0" + month;
		}
		if(day != null) {
			if(day.equals("")) day = null;
			else if(day.length() == 1) day = "0" + day;
		}
		if(dayofweek != null) {
			if(dayofweek.equals("Monday")) dayofweek = "1";
			else if(dayofweek.equals("Tuesday")) dayofweek = "2";
			else if(dayofweek.equals("Wednesday")) dayofweek = "3";
			else if(dayofweek.equals("Thursday")) dayofweek = "4";
			else if(dayofweek.equals("Friday")) dayofweek = "5";
			else if(dayofweek.equals("Saturday")) dayofweek = "6";
			else if(dayofweek.equals("Sunday")) dayofweek = "7";
			else if(dayofweek.equals("N/A")) dayofweek = null;
		}
		if(season != null) {
			if(season.equals("Spring")) season = "1";
			else if(season.equals("Summer")) season = "2";
			else if(season.equals("Autumn")) season = "3";
			else if(season.equals("Winter")) season = "4";
			else if(season.equals("N/A")) season = null;
		}
		if(director != null && director.equals("")) {
			director = null;
		}
		if(star != null && star.equals("")) {
			star = null;
		}
		if(actor != null && actor.equals("")) {
			actor = null;
		}
		long timeCountMysql = 0;
		long timeCountHive = 0;
		ArrayList<DbMovieDimension> movieListMysql = new ArrayList<DbMovieDimension>();
		ArrayList<DbMovieDimension> movieListHive = new ArrayList<DbMovieDimension>();
		if(typeList.isEmpty()) {
			ArrayList<Long> timeCountList = new ArrayList<Long>();
			DAOFactory.getGetMoviesDAO().getMoviesByRand(timeCountList, movieListMysql, moviename, year, month, day, season, dayofweek, type, director, star, actor);
			timeCountMysql = timeCountList.get(0);
		}
		else {
			for(int i = 0; i != typeList.size(); i++) {
				type = typeList.get(i);
				ArrayList<Long> timeCountList = new ArrayList<Long>();
				DAOFactory.getGetMoviesDAO().getMoviesByRand(timeCountList, movieListMysql, moviename, year, month, day, season, dayofweek, type, director, star, actor);
				timeCountMysql = timeCountList.get(0);
			}
		}
		response.getWriter().append("Mysql time: " + timeCountMysql + " microSecond\t" + "Hive time: " + timeCountHive + " microSecond\n");
		for(int i = 0; i != movieListMysql.size(); i++) {
			DbMovieDimension movie = movieListMysql.get(i);
			response.getWriter().append(movie.getProductid() + "\t" + movie.getTimeid() + " " + movie.getSeason() + " " + movie.getDayofweek() + "\t" + movie.getMoviename() + "\t" + movie.getMovieversion() + "\n");
		}
		/*System.out.println(moviename + "/");
		System.out.println(year + "/");
		System.out.println(month + "/");
		System.out.println(day + "/");
		System.out.println(dayofweek + "/");
		System.out.println(season + "/");
		System.out.println(director + "/");
		System.out.println(star + "/");
		System.out.println(actor + "/");
		System.out.println(type + "/");
		for(int i = 0; i != typeList.size(); i++) {
			System.out.println(typeList.get(i) + "/");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
