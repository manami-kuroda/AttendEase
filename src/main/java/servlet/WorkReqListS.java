package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.WorkReq;

@WebServlet("/WorkReqListS")
public class WorkReqListS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("WEB-INF/jsp/workReqList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String workReqDateString = request.getParameter("workReqDate"); // 受け取った文字列
	    LocalDateTime workReqDate = LocalDateTime.parse(workReqDateString); // 文字列をLocalDateTimeに変換
	    String workReqWork = request.getParameter("workReqWork");
	    String workReqReason = request.getParameter("workReqReason");
	    String workReqNote = request.getParameter("workReqNote");
	    
	    // アプリケーションスコープの取得
		ServletContext application = this.getServletContext();
		
		// 申請一覧の初期化
        List<WorkReq> workReqList = (List<WorkReq>) application.getAttribute("workReqList");
        if (workReqList == null) {
        	workReqList = new ArrayList<>();
        	application.setAttribute("workReqList", workReqList);
        }
        
        // WerkReqを作成
        WorkReq workReq = new WorkReq();
        workReq.setName(name);
        workReq.setWorkReqDate(workReqDate);
        workReq.setWorkReqWork(workReqWork);
        workReq.setWorkReqReason(workReqReason);
        workReq.setWorkReqNote(workReqNote);
        
        // リストに追加
        workReqList.add(0, workReq);
        
		// 申請成功時の処理
		// 申請成功のメッセージをリクエストスコープに保存
		request.setAttribute("successMsg", "申請しました");
        
        // workReq.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/workReq.jsp");
        dispatcher.forward(request, response);
        
	}

}
