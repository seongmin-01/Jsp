package service;

import java.util.List;

import dao.User2DAO;
import dto.User2DTO;

public class User3Service {

	// 싱글톤
	private static final User3Service instance = new User3Service();
	
	public static User3Service getInstance() {
		return instance;
	}
	
	private User3Service() {}
	
	//DAO 호출
	private User2DAO dao = User2DAO.getInstance(); 
	
	// 기본 CRUD 
	public void registerUser2(User2DTO dto) {
		dao.insertUser2(dto);
	}
		
	public User2DTO findUser2(String uid) {
		return dao.selectUser2(uid);
	}
		
	public List<User2DTO> findAll() {
		return dao.selectAllUser2();
	}
		
	public void modifyUser2(User2DTO dto) {
		dao.updateUser2(dto);
	}
		
	public void removeUser2(String uid) {
		dao.deleteUser2(uid);
	}
		
}
