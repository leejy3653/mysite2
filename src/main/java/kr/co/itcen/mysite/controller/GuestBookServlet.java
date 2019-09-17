package kr.co.itcen.mysite.controller;

import java.io.IOException;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.itcen.mysite.dao.GuestBookDao;
import kr.co.itcen.mysite.vo.GuestBookVo;
import kr.co.itcen.web.WebUtils;

@WebServlet("/guestbook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("a");
		if ("add".equals(action)) {

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("contents");

			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);

			new GuestBookDao().insert(vo);
			// response.sendRedirect(request.getContextPath() + "/guestbook");
			WebUtils.redirect(request, response, request.getContextPath() + "/guestbook");
		} else if ("deleteform".equals(action)) {

			// forwarding
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			// rd.forward(request, response);
			WebUtils.forward(request, response, "/WEB-INF/views/guestbook/deleteform.jsp");

		} else if ("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");

			GuestBookVo Vo = new GuestBookVo();
			Vo.setNo(Long.parseLong(no));
			Vo.setPassword(password);

			new GuestBookDao().delete(Vo);
			// response.sendRedirect(request.getContextPath() + "/guestbook");
			WebUtils.redirect(request, response, request.getContextPath() + "/guestbook");
		} else {
			/* index(list) */
			List<GuestBookVo> list = new GuestBookDao().getList();
			request.setAttribute("list", list);

			// RequestDispatcher rd =
			// request.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			// rd.forward(request, response);
			WebUtils.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
