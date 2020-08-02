	package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.IWordsDao;
import dao.impl.WordsDaoJDBCImpl;
import entity.ResultInfo;
import entity.Words;
import util.PageBeanWords;
@WebServlet("/words_list")
public class WordsListServlet extends HttpServlet {
	private int pageSize;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String sPageSize = config.getInitParameter("pageSize");
		if(sPageSize != null){
			this.pageSize = Integer.parseInt(sPageSize);
		}else{
			this.pageSize = 5;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
		//1.设置请求参数编码
		request.setCharacterEncoding("utf-8");
		
		//2.获得请求参数 - 请求参数就是要显示的 页码pageIndex
		String sPageIndex = request.getParameter("pageIndex");
		
		//3.对参数要进行判断
		if(sPageIndex == null)
			sPageIndex = "1";
		
		//4.将参数由字符串类型转换为 int类型
		int pageIndex = Integer.parseInt(sPageIndex);
		
		//5.构造分页对象PageBean
		IWordsDao wordDao = new WordsDaoJDBCImpl();
		int count = wordDao.findTotalCount();
		List<Words> list = wordDao.findOnePage(pageIndex, this.pageSize); 
		PageBeanWords<Words> pageBeanWords = new PageBeanWords<Words>(pageIndex, count, this.pageSize, list);
 		pageBeanWords.init();
 		Gson gson = new Gson();
 	    String json = gson.toJson(pageBeanWords);
 	    response.getWriter().write(json);
 	
		
		
	}
}