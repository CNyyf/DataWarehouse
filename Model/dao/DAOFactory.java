package dao;

public class DAOFactory {
	static public GetMoviesDAO getGetMoviesDAO() {
		return new GetMoviesDAO();
	}
	static public CountMoviesDAO getCountMoviesDAO() {
		return new CountMoviesDAO();
	}
}
