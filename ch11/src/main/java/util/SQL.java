package util;

public class SQL {
	
	// shop
	public static final String insert_customer = "insert into `customer` values(?, ?, ?, ?, NOW())";
	
	public static final String select_user1 = "select * from `user1` where `uid` =? ";

	public static final String select_all_user1 = "select * from `user1`";
	
	public static final String update_user1 = "update `user1` set `name`=?,`hp`=?,`age`=? where `uid` = ?";
	
	public static final String delete_user1 = "delete from `user1` where `uid`=?";
	
	//order
	
	//product
	
}	
