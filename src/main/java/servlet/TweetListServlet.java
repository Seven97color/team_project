package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TweetDAO;
import model.entity.TweetBean;

/**
 * Servlet implementation class TodoListServlet
 */
@WebServlet("/tweet-list")
public class TweetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TweetListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tweetリストを格納する変数
		List<TweetBean> tweetList = null;

		// TweetDAOクラスのインスタンス生成
		TweetDAO dao = new TweetDAO();

		try {
			// TweetDAOクラスのgetTweetListメソッド呼び出し、tweetリスト取得
			tweetList = dao.getTweetList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープにtweetリストをセット
		request.setAttribute("tweetList", tweetList);

		// tweet-list.jspのtweet一覧画面へ転送
		RequestDispatcher rd = request.getRequestDispatcher("tweet-list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
