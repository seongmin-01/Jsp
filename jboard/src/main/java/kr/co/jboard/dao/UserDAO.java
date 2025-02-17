package kr.co.jboard.dao;

import java.util.List;

import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.util.DBHelper;



public class UserDAO extends DBHelper{

	private static final UserDAO instance = new UserDAO();
	public static UserDAO getinstance() {
		return instance;
	}
	
	private UserDAO() {}
	
	public void insertUser(UserDTO dto) {
		
	}
	
	public UserDTO selectUser(int uid) {
		return null;
	}
	
	public List<UserDTO> selectAllUser() {
		return null;
	}
	
	public void updateUser(UserDTO dto) {
		
	}
	
	public void deleteUser(int uid) {
		
	}
}
