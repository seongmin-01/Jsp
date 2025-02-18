package kr.co.jboard.util;

public class SQL {
	

	// terms
	public static final String select_terms = "select * from `terms` where `no`=?";
	
	
	// user
	public static final String select_user = "select * from `user` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String insert_user = "insert into `user` set"
				+ "`uid`=?,"
				+ "`pass`=SHA2(?, 256),"
				+ "`name`=?,"
				+ "`nick`=?,"
				+ "`email`=?,"
				+ "`hp`=?,"
				+ "`zip`=?,"
				+ "`addr1`=?,"
				+ "`addr2`=?,"
				+ "`regip`=?,"
				+ "`regDate`=NOW()";
	
	
}	
