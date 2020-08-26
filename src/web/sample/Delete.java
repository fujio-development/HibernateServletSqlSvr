package web.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**サーブレット実装クラス Delete
 **/
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** @see HttpServlet#HttpServlet()
     **/
    public Delete() {
        super();
    }

    /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer delid = 0;
		if (request.getParameter("id") != null) {
			delid = Integer.valueOf(request.getParameter("id"));
		}
		HibernateDao<ShohinMap> hdao = new HibernateDao<ShohinMap>();
		ShohinMap data = new ShohinMap();
		data = hdao.search(delid);
		hdao.delete(data);
		List<ShohinMap> list = hdao.searchAll();
		request.setAttribute("reqlist", list);
		
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/show.jsp");
		reqdispathcer.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}