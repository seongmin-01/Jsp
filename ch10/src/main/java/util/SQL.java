package util;

public class SQL {
	
	// user1
	public static final String insert_user1 = "insert into `user1` values(?, ?, ?, ?)";
	
	public static final String select_user1 = "select * from `user1` where `uid` =? ";

	public static final String select_all_user1 = "select * from `user1`";
	
	public static final String update_user1 = "update `user1` set `name`=?,`hp`=?,`age`=? where `uid` = ?";
	
	public static final String delete_user1 = "delete from `user1` where `uid`=?";
	
	
	//user2
	public static final String insert_user2 = "insert into `user2` values(?, ?, ?, ?)";
	
	public static final String select_user2 = "select * from `user2` where `uid` =? ";

	public static final String select_all_user2 = "select * from `user2`";
	
	public static final String update_user2 = "update `user2` set `name`=?,`birth`=?,`addr`=? where `uid` = ?";
	
	public static final String delete_user2 = "delete from `user2` where `uid`=?";
	
	
	//user3
	public static final String insert_user3 = "insert into `user3` values(?, ?, ?, ?, ?) ";
	
	public static final String select_user3 = "select * from `user3` where `uid`=?";
	
	public static final String select_all_user3 = "select * from `user3`";
	
	public static final String update_user3 = "update `user3` set `name`=?, `birth`=?, `hp`=?, `addr` =?";

	public static final String delete_user3 = "delete from `user3` where `uid`=?";
}
