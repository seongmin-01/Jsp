package Service;

import java.util.List;


import kr.co.jboard.dao.TermsDAO;

import kr.co.jboard.dto.TermsDTO;

public enum TermsService {
	
	instance;
	private TermsDAO dao = TermsDAO.getinstance();
	
	public void registerTerms(TermsDTO dto) {
		dao.insertTerms(null);
	}
	
	public TermsDTO findTerms(int no) {
		return dao.selectTerms(no);
	}
	
	public List<TermsDTO> findAllTerms() {
		return dao.selectAllTerms();
	}
	
	public void modifyTerms(TermsDTO dto) {
		dao.updateTerms(dto);
	}
	
	public void deleteTerms(int no) {
		dao.deleteTerms(no);
	}
}
