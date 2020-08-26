package web.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import web.sample.LastException;

/**
 * サーブレット実装クラス OriginalUncaughtException
 */
@WebServlet("/OriginalUncaughtException")
public class OriginalUncaughtException extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OriginalUncaughtException() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//例外の内容やトレース内容をLogに出力したい場合やユーザーに画面出力したい場合にここへ書きます。
		
		String title = request.getAttribute("javax.servlet.error.exception_type").toString();
		String place = request.getAttribute("javax.servlet.error.request_uri").toString();
		String param = request.getAttribute("javax.servlet.error.status_code").toString();
		String message = request.getAttribute("javax.servlet.error.message").toString();
		Throwable t = (Throwable)request.getAttribute("javax.servlet.error.exception");
		var sw = new StringWriter();
		try(var pw = new PrintWriter(sw);) {
			t.printStackTrace(pw);
			pw.flush();
			//String st = sw.toString();
		}
		//LastException.SetLastException(title, place, param, message);
		
		request.setAttribute("title", title);
		request.setAttribute("uri", place);
		request.setAttribute("code", param);
		request.setAttribute("msg", message);
		request.setAttribute("trace", sw.toString());
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/ExceptionMsg.jsp");
		reqdispathcer.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}