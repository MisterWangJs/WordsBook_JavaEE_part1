package dao;

import java.util.List;


import entity.Words;

public interface IWordsDao {

	public int add(Words word);
	public List<Words> findAll();
	public int findTotalCount();
	public List<Words> findOnePage(int pageIndex, int pageSize);
	public int deleteByWId(int wid);
	public int Modifyword(int wid, Words word);
	public List<Words> MoHufindAll();
	public int MoHufindTotalCount(String x);
	public List<Words> MoHufindOnePage(String x,int pageIndex, int pageSize);

	
}
