package kr.co.jboard.dao;

import java.util.List;

import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.util.DBHelper;

public class ArticleDAO  extends DBHelper{
	
	private static final ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getinstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	public void insertArticle(ArticleDTO dto) {
		
	}
	
	public ArticleDAO selectArticle(int no) {
		return null;
	}
	
	public List<ArticleDTO> selectAllArticle() {
		return null;
	}
	
	public void updateArticle(ArticleDTO dto) {
		
	}
	
	public void deleteArticle(int no) {
		
	}
}
