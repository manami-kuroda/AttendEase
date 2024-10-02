package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MonthRecord")
public class MonthRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションから月ごとの記録を取得
        HttpSession session = request.getSession();
        List<Record> monthRecord = (List<Record>) session.getAttribute("monthRecord");

        // 月ごとの記録をリクエストにセット
        request.setAttribute("monthRecord", monthRecord);
        
        // monthRecord.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/monthRecord.jsp");
        dispatcher.forward(request, response);
	}
}
