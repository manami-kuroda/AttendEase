package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginS")
public class LoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		// Loginインスタンスを生成
		Login login = new Login(userId, pass);
		
		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogic = loginLogic.execute(login);
		
		// ログイン成功時の処理
		if (isLogic) {
			// userIdをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			// mainの打刻画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "ログインできません。パスワードをご確認ください。");
			
			// indexにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
				
	}

}
