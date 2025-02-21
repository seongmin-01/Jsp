package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class ArticleDAO  extends DBHelper{
	
	private static final ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getinstance() {
		return instance;
	}
	private ArticleDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleDTO dto) {
		int no = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.insert_article);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			
			// 글번호 조회 쿼리 실행
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.select_max_no);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}
	
	public ArticleDAO selectArticle(int no) {
		return null;
	}
	
	public List<ArticleDTO> selectAllArticle() {
		
		List<ArticleDTO> list = new ArrayList<ArticleDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.selectAll_article);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setWdate(rs.getString(4));;
				dto.setHit(rs.getInt(5));
				
				list.add(dto);
			}
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void updateArticle(ArticleDTO dto) {
		
	}
	
	public void deleteArticle(int no) {
		
	}
}
