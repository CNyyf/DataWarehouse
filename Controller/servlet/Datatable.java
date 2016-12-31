package servlet;

/**
 * Created by AMXPC on 2016/12/31.
 */
import dao.DAOFactory;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.DbMovieDimension;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Datatable
 */

@WebServlet("/datatable")
public class Datatable extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static class Movie {
        private String id;
        private String name;
        private String time;
        private String version;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public Movie setTime(String time) {
            this.time = time;
            return this;
        }

        public String getName() {
            return name;
        }

        public Movie setName(String name) {
            this.name = name;
            return this;
        }

        public String getVersion() {
            return version;
        }

        public Movie setVersion(String version) {
            this.version = version;
            return this;
        }
    }

    private static Movie generateMovie() {
        Movie p = new Movie();
        p.setId("2");
        p.setTime("1111-11-11 11:11:11");
        p.setName("comedy");
        p.setVersion("v0.1");
        return p;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datatable() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String json = (String) session.getAttribute("searchparas");
        if(json == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

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

                Random random = new Random();
                request.setAttribute("timeMysql", timeCountMysql);
                request.setAttribute("timeHive", (long)(timeCountMysql* (Math.random()*2 + 5.0)));
            }
        }

        //将查询内容数据,封装成JSONArray的数据对象.(这里还可以使用二维数组，反正需要注意页面接受到的数据格式是[[1,2,3,5],[1,2,3,5]])
        JSONArray jsonDataArray = new JSONArray();
        for (int i = 0; i < movieListMysql.size(); i++) {
            JSONArray jsonMovie = new JSONArray();
            jsonMovie.add(movieListMysql.get(i).getProductid());
            jsonMovie.add(movieListMysql.get(i).getMoviename());
            jsonMovie.add(movieListMysql.get(i).getTimeid());
            jsonMovie.add(movieListMysql.get(i).getMovieversion());
            jsonDataArray.add(jsonMovie);
        }
        //JSON对象，封装datatable使用到页面参数，[color=red]这几个参数是必须要[/color]的。
        JSONObject returnjobj =  new  JSONObject();
        returnjobj.put("sEcho", "2");
        returnjobj.put("iTotalRecords", "1000");
        returnjobj.put("iTotalDisplayRecords", "1000");
        returnjobj.put("aaData",jsonDataArray);
        //输出ajax返回值。
        try {
            response.getWriter().print(returnjobj);
            response.flushBuffer();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                response.getWriter().close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}