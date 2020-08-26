package web.sample;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**- サーブレット実装クラス Control
 **/
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** @see HttpServlet#HttpServlet()
     **/
    public Control() {
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
		List<ShohinMap> list = new ArrayList<ShohinMap>();
		
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
		//from web.sample.ShohinMap as sd where sd.ShohinCode < 1000
		String hql = request.getParameter("jhql");
		HibernateDao<ShohinMap> hdao = new HibernateDao<ShohinMap>();

		List<ShohinMap> list = hdao.GoQuery(hql);
		request.setAttribute("reqlist", list);
		RequestDispatcher reqdispathcer = request.getRequestDispatcher("/show.jsp");
		reqdispathcer.forward(request, response);
		//doGet(request, response);
	}

	@PostConstruct
	private void initialData() {
		HibernateDao<ShohinMap> hibdao = new HibernateDao<ShohinMap>();
		if (hibdao.getCount("select count(*) from web.sample.ShohinMap") > 0) {
			return;
		}

		ShohinMap syohindata = new ShohinMap();
		syohindata.setShohinCode((short)7500);
		syohindata.setShohinName("ｾﾄｳﾁﾚﾓﾝ");
		syohindata.setEditDate(BigDecimal.valueOf(20190417));
		syohindata.setEditTime(BigDecimal.valueOf(203145));
		syohindata.setNote("瀬戸内レモンです");
		hibdao.insert(syohindata);

		syohindata.setShohinCode((short)2840);
		syohindata.setShohinName("ﾘﾝｺﾞｼﾞｭｰｽ");
		syohindata.setEditDate(BigDecimal.valueOf(20050923));
		syohindata.setEditTime(BigDecimal.valueOf(102532));
		syohindata.setNote("果汁100%の炭酸飲料です");
		hibdao.insert(syohindata);

		syohindata.setShohinCode((short)1580);
		syohindata.setShohinName("ｶﾌｪｵﾚ");
		syohindata.setEditDate(BigDecimal.valueOf(20160716));
		syohindata.setEditTime(BigDecimal.valueOf(91103));
		syohindata.setNote("200ml増量です");
		hibdao.insert(syohindata);

		syohindata.setShohinCode((short)270);
		syohindata.setShohinName("ｳﾒｵﾆｷﾞﾘ");
		syohindata.setEditDate(BigDecimal.valueOf(20080825));
		syohindata.setEditTime(BigDecimal.valueOf(141520));
		syohindata.setNote("none");
		hibdao.insert(syohindata);
	}
}