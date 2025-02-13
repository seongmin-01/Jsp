package util;

public class SQL {
	
	// user1
	public static final String insert_user1 = "insert into `user1` values(?, ?, ?, ?)";
	
	public static final String select_user1 = "select * from `user1` where `uid` =? ";

	public static final String select_all_user1 = "select * from `user1`";
	
	public static final String update_user1 = "update `user1` set `name`=?,`hp`=?,`age`=? where `uid` = ?";
	
	public static final String delete_user1 = "delete from `user1` where `uid`=?";
}
