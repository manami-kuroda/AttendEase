package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Record;

@WebServlet("/TimeStamping")
public class TimeStamping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 現在の日時を取得
		LocalDateTime currentTime = LocalDateTime.now();
		
		// セッションスコープの取得
		HttpSession session = request.getSession();
		
		// リクエストパラメータの取得
		String action = request.getParameter("action");
		
		// 勤怠記録の初期化
        List<Record> monthRecord = (List<Record>) session.getAttribute("monthRecord");
        if (monthRecord == null) {
            monthRecord = new ArrayList<>();
        }
		
        // どの時間が設定されているかを確認
        LocalDate workDate = LocalDate.now(); // 今日の日付
        LocalDateTime workIn = (LocalDateTime) session.getAttribute("workIn");
        LocalDateTime breakIn = (LocalDateTime) session.getAttribute("breakIn");
        LocalDateTime breakOut = (LocalDateTime) session.getAttribute("breakOut");
        LocalDateTime workOut = (LocalDateTime) session.getAttribute("workOut");

        
		if ("出勤".equals(action)) {
			// 出勤時間をセッションスコープに保存
			session.setAttribute("workIn", currentTime);
		} else if ("休入".equals(action)) {
			// 休憩入り時間をセッションスコープに保存
			session.setAttribute("breakIn", currentTime);
		} else if ("休終".equals(action)) {
			// 休憩終わり時間をセッションスコープに保存
			session.setAttribute("breakOut", currentTime);
		} else if ("退勤".equals(action)) {
			// 退勤時間をセッションスコープに保存
			session.setAttribute("workOut", currentTime);
		}
		
        // 出勤と退勤が揃った場合に月ごとの記録を作成
        if (workIn != null && workOut != null) {
            monthRecord.add(new Record(workDate, workIn, breakIn, breakOut, workOut));
            session.setAttribute("monthRecord", monthRecord);
            // すべての時間をリセット
            session.removeAttribute("workIn");
            session.removeAttribute("breakIn");
            session.removeAttribute("breakOut");
            session.removeAttribute("workOut");
        }
		
		// mainの打刻画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
