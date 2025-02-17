package Service;

import java.util.List;


import kr.co.jboard.dao.CommentDAO;
import kr.co.jboard.dto.CommentDTO;



public enum CommentService {

	instance;
		
	private CommentDAO dao = CommentDAO.getinstance();
	
	public void registerComment(CommentDTO dto) {
		dao.insertComment(dto);
	}
		
	public CommentDTO findArticle(int no) {
		return dao.selectComment(no);
	}
		
	public List<CommentDTO> findAllArticle() {
		return dao.selectAllComment();
	}
		
	public void modifyArticle(CommentDTO dto) {
		dao.updateComment(dto);
	}
		
	public void deleteArticle(int no) {
		dao.deleteComment(no);
	}
}
