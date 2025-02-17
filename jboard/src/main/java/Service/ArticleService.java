package Service;

import java.util.List;

import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dto.ArticleDTO;

public enum ArticleService {
	instance;
	
	private ArticleDAO dao = ArticleDAO.getinstance();
	
	public void registerArticle(ArticleDTO dto) {
		dao.insertArticle(dto);
	}
	
	public ArticleDAO findArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public List<ArticleDTO> findAllArticle() {
		return dao.selectAllArticle();
	}
	
	public void modifyArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	}
	
	public void deleteArticle(int no) {
		dao.deleteArticle(no);
	}
}
