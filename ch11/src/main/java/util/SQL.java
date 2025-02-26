package util;

public class SQL {
	
	// shop
	public static final String insert_customer = "insert into `customer` values(?, ?, ?, ?, NOW())";
	
	public static final String select_customer = "select * from `customer` where `uid` =? ";

	public static final String select_all_customer = "select * from `customer`";
	
	public static final String update_customer = "update `customer` set `name`=?,`hp`=?,`addr`=? where `uid` = ?";
	
	public static final String delete_customer = "delete from `customer` where `uid`=?";
	
	//order
	
	//product
	
}	
