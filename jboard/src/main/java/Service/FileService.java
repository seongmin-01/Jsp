package Service;

import java.util.List;


import kr.co.jboard.dao.FileDAO;

import kr.co.jboard.dto.FileDTO;

public enum FileService {
	instance;
	
	private FileDAO dao = FileDAO.getinstance();
	
	public void registerFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	public FileDTO findFile(int no) {
		return dao.selectFile(no);
	}
	
	public List<FileDTO> findAllFile() {
		return dao.selectAllFile();
	}
	
	public void modifyFile(FileDTO dto) {
		dao.updateFile(dto);
	}
	
	public void deleteFile(int no) {
		dao.deleteFile(no);
	}
}
