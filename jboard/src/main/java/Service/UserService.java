package Service;

import java.util.List;


import kr.co.jboard.dao.UserDAO;

import kr.co.jboard.dto.UserDTO;

public enum UserService {
	instance;
	
	private UserDAO dao = UserDAO.getinstance();
	
	public void registerUser(UserDTO dto) {
		dao.insertUser(dto);
	}
	
	public UserDTO findUser(int no) {
		return dao.selectUser(no);
	}
	
	public UserDTO findUser(UserDTO dto) {
		return dao.selectUser(dto);
	}
	
	public List<UserDTO> findAllUser(String uid) {
		return dao.selectAllUser();
	}
	
	public void modifyUser(UserDTO dto) {
		dao.updateUser(dto);
	}
	
	public void deleteUser(int no) {
		dao.deleteUser(no);
	}
}
