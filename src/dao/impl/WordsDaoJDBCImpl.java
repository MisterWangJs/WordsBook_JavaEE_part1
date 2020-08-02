package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IWordsDao;
import entity.Words;
import util.JDBCUtil;



public class WordsDaoJDBCImpl implements IWordsDao {

	@Override
	public int add(Words word) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into words (word,pronounce,description)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, word.getWord());
			ps.setString(2, word.getPronounce());
			ps.setString(3, word.getDescription());
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	

	@Override
	public List<Words> findAll() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Words> wordList = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from words";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			

			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						wordList = new ArrayList<Words>();
						flag = false;
					}
					Words word = new Words();
					word.setWid(rs.getInt("wid"));
					word.setWord(rs.getString("word"));
					word.setPronounce(rs.getString("pronounce"));
					word.setDescription(rs.getString("description"));
					wordList.add(word);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}

	@Override
	public int findTotalCount() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) as totalcount from words";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	
			if(rs != null){
				while(rs.next()){
					n = rs.getInt("totalcount");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	public List<Words> findOnePage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Words> wordList = null;
		

		int startRecordNo = (pageIndex - 1) * pageSize;
		
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from words limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRecordNo);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			

			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						wordList = new ArrayList<Words>();
						flag = false;
					}
					Words word = new Words();
					word.setWid(rs.getInt("wid"));
					word.setWord(rs.getString("word"));
					word.setPronounce(rs.getString("pronounce"));
					word.setDescription(rs.getString("description"));
					wordList.add(word);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}

	@Override
	public int deleteByWId(int wid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from Words where wid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wid);
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	
	
	public int Modifyword(int wid, Words word) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update words set word=?,pronounce=?,description=? where wid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, word.getWord());
			ps.setString(2, word.getPronounce());
			ps.setString(3, word.getDescription());
			ps.setInt(4, wid);
			
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
/*
	@Override
	public Words findByWId(int wid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				Words word = null;
				try {
					conn = JDBCUtil.getConnection();
					String sql = "select * from words where wid = ?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, wid);
					
					rs = ps.executeQuery();
					

					if(rs != null){
						while(rs.next()){
							word = new Words();
							word.setWid(rs.getInt("wid"));
							word.setWord(rs.getString("word"));
							word.setPronounce(rs.getString("pronounce"));
							word.setDescription(rs.getString("description"));
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return word;
	}
*/
/**
 * 模糊查找
 * */
	
	@Override
	public List<Words> MoHufindAll() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Words> wordList = null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from words";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			

			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						wordList = new ArrayList<Words>();
						flag = false;
					}
					Words word = new Words();
					word.setWid(rs.getInt("wid"));
					word.setWord(rs.getString("word"));
					word.setPronounce(rs.getString("pronounce"));
					word.setDescription(rs.getString("description"));
					wordList.add(word);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}

	@Override
	public int MoHufindTotalCount(String x) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) as totalcount from words where word regexp ? or description regexp ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, x);
			ps.setString(2, x);
			rs = ps.executeQuery();	
			if(rs != null){
				while(rs.next()){
					n = rs.getInt("totalcount");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	public List<Words> MoHufindOnePage(String x,int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Words> wordList = null;
		

		int startRecordNo = (pageIndex - 1) * pageSize;
		
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from words where word regexp ? or description regexp ? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, x);
			ps.setString(2, x);
			ps.setInt(3, startRecordNo);
			ps.setInt(4, pageSize);
			rs = ps.executeQuery();
			

			if(rs != null){
				boolean flag = true;
				while(rs.next()){
					if(flag){
						wordList = new ArrayList<Words>();
						flag = false;
					}
					Words word = new Words();
					word.setWid(rs.getInt("wid"));
					word.setWord(rs.getString("word"));
					word.setPronounce(rs.getString("pronounce"));
					word.setDescription(rs.getString("description"));
					wordList.add(word);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}
}
