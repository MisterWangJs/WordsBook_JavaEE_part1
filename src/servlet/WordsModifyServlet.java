package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.IWordsDao;
import dao.impl.WordsDaoJDBCImpl;
import entity.ResultInfo;
import entity.Words;

@WebServlet("/word_modify")
public class WordsModifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	       
        response.setContentType("application/json; charset=utf-8");
        
		String wId = request.getParameter("wid");
		String word = request.getParameter("word");
		String pronounce = request.getParameter("pronounce");
		String description = request.getParameter("description");
		int wid = Integer.parseInt(wId);
		
		
		
		//3.创建实体对象
		Words words = new Words();
		words.setWord(word);
		words.setPronounce(pronounce);
		words.setDescription(description);
	
		
		
		//4.借助IWordsDao将信息添加到DB?
		IWordsDao wordDao = new WordsDaoJDBCImpl();
		int i = wordDao.Modifyword(wid, words);
		
		if(i == 1){
			 Gson gson = new Gson();
			 String result = gson.toJson(new ResultInfo(1, "修改成功！"));
			 response.getWriter().write(result);
	       
		}
        else {
       	 Gson gson = new Gson();
            String result = gson.toJson(new ResultInfo(0, "修改失败！"));
            response.getWriter().write(result);
       }
	
	}
}
