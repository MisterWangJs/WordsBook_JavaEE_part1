package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import util.PageBeanMoHu;
@WebServlet("/mohu_find")
public class MohuFindServlet extends HttpServlet {
	private int pageSize;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String sPageSize = config.getInitParameter("pageSize");
		if(sPageSize != null){
			this.pageSize = Integer.parseInt(sPageSize);
		}else{
			this.pageSize = 100;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	
		String x = request.getParameter("x");
		request.setCharacterEncoding("utf-8");
		String sPageIndex = request.getParameter("pageIndex");
		if(sPageIndex == null)
			sPageIndex = "1";

		int pageIndex = Integer.parseInt(sPageIndex);
		
		IWordsDao wordDao = new WordsDaoJDBCImpl();
		
		int count = wordDao.MoHufindTotalCount(x);
		
		if (count==0){
			Gson gson = new Gson();
			String result = gson.toJson(new ResultInfo(0, "没有查到！"));
            response.getWriter().write(result);
		}else{
			List<Words> list = wordDao.MoHufindOnePage(x,pageIndex, this.pageSize); 
			
			PageBeanMoHu<Words> pageBeanMoHu = new PageBeanMoHu<Words>(pageIndex, count, this.pageSize, list);
	 		pageBeanMoHu.init();
	 		
	 		Gson gson = new Gson();
	 	    String json = gson.toJson(pageBeanMoHu);
	 	    response.getWriter().write(json);
		}
		
		
		
		
	}
}
