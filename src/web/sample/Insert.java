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

/**- サーブレット実装クラスInsert
 **/
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** @see HttpServlet#HttpServlet()
     **/
    public Insert() {
        super();
    }

    /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if (request.getParameter("id") != null) {
			Integer upid = Integer.valueOf(request.getParameter("id"));
			request.setAttribute("requpid", upid);
		}
		HibernateDao<ShohinMap> hdao = new HibernateDao<ShohinMap>();
		List<ShohinMap> list;
		
		list = hdao.searchAll();
		request.setAttribute("reqlist", list);
		
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/show.jsp");
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

		data.setShohinCode(Short.valueOf(request.getParameter("jnum")));
		data.setShohinName(request.getParameter("jname"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String daytime = formatter.format(java.time.LocalDateTime.now());
		data.setEditDate(BigDecimal.valueOf(Integer.valueOf(daytime.substring(0,8))));
		data.setEditTime(BigDecimal.valueOf(Integer.valueOf(daytime.substring(8))));
		data.setNote(request.getParameter("jnote"));
		hdao.insert(data);

		doGet(request, response);
	}

}