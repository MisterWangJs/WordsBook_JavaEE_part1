package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.IWordsDao;
import dao.impl.WordsDaoJDBCImpl;
import entity.ResultInfo;

@WebServlet("/word_delete")
public class WordsDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	       
        response.setContentType("application/json; charset=utf-8");
       
		
		String wId = request.getParameter("wid");
		int wid = Integer.parseInt(wId);
		
		IWordsDao wordDao = new WordsDaoJDBCImpl();
		int i = wordDao.deleteByWId(wid);
	
		if(i == 1){
				 Gson gson = new Gson();
				 String result = gson.toJson(new ResultInfo(1, "删除成功！"));
				 response.getWriter().write(result);
		       
			}
	         else {
	        	 Gson gson = new Gson();
	             String result = gson.toJson(new ResultInfo(0, "删除失败！"));
	             response.getWriter().write(result);
	        }
	}
}
