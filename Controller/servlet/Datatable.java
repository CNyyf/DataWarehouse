package servlet;

/**
 * Created by AMXPC on 2016/12/31.
 */
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (int k = 0; k < 10; ++k)
            result.add(generateMovie());
        //将查询内容数据,封装成JSONArray的数据对象.(这里还可以使用二维数组，反正需要注意页面接受到的数据格式是[[1,2,3,5],[1,2,3,5]])
        JSONArray jsonDataArray = new JSONArray();
        for (int i = 0; i < result.size(); i++) {
/*            JSONObject jsonMovie = new JSONObject();
            jsonMovie.put("Product Id", result.get(i).getId());
            jsonMovie.put("Movie Name", result.get(i).getName());
            jsonMovie.put("Posted Time", result.get(i).getTime());
            jsonMovie.put("Version", result.get(i).getVersion());
            jsonDataArray.add(jsonMovie);*/
            JSONArray jsonMovie = new JSONArray();
            jsonMovie.add(result.get(i).getId());
            jsonMovie.add(result.get(i).getName());
            jsonMovie.add(result.get(i).getTime());
            jsonMovie.add(result.get(i).getVersion());
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