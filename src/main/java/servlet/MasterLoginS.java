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
import model.MasterLoginLogic;

@WebServlet("/MasterLoginS")
public class MasterLoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MasterLogin.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/masterLogin.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		// Loginインスタンスを生成
		Login login = new Login(userId, pass);
		
		// ログイン処理
		MasterLoginLogic memberLoginLogic = new MasterLoginLogic();
		boolean isLogic = memberLoginLogic.execute(login);
		
		// ログイン成功時の処理
		if (isLogic) {
			// userIdをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			// 管理者のmain画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/masterMain.jsp");
			dispatcher.forward(request, response);
		} else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "ログインできません。パスワードをご確認ください。");
			
			// 管理者ログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/masterLogin.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
