package web.sample;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** サーブレット実装クラス Delete
 **/
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** @see HttpServlet#HttpServlet()
     **/
    public Update() {
        super();
    }

    /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer upid = 0;
		if (request.getParameter("id") != null) {
			upid = Integer.valueOf(request.getParameter("id"));
		} else {
			return;
		}
		HibernateDao<ShohinMap> hdao = new HibernateDao<ShohinMap>();
		ShohinMap data = new ShohinMap();
		data = hdao.search(upid);
		request.setAttribute("updata", data);
		
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/edit.jsp");
		reqdispathcer.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HibernateDao<ShohinMap> hdao = new HibernateDao<ShohinMap>();
		ShohinMap data = new ShohinMap();

		data.setNumId(Integer.valueOf(request.getParameter("jid")));
		data.setShohinCode(Short.valueOf(request.getParameter("jnum")));
		data.setShohinName(request.getParameter("jname"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String daytime = formatter.format(java.time.LocalDateTime.now());
		data.setEditDate(BigDecimal.valueOf(Integer.valueOf(daytime.substring(0,8))));
		data.setEditTime(BigDecimal.valueOf(Integer.valueOf(daytime.substring(8))));
		data.setNote(request.getParameter("jnote"));
		hdao.update(data);
		List<ShohinMap> list = hdao.searchAll();
		request.setAttribute("reqlist", list);
		
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/show.jsp");
		reqdispathcer.forward(request, response);
		//doGet(request, response);
	}

}