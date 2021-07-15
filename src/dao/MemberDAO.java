package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MainService;
import util.JDBCUtil;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberDAO() {
	}

	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	public int update(Map<String, Object> member) {
		String sql = "UPDATE MEMBER SET MEMBER_ID = ?, MEMBER_LOGINID =?, MEMBER_PASS =?, "
				+ "MEMBER_NAME =?, MEMBER_AGE =?, MEMBER_TELNUM =?, MEMBER_AUTHORITY =?, MEMBER_MILEAGE = ? WHERE MEMBER_ID=?";
		List<Object> p = new ArrayList<>();
		String[] key = { "MEMBER_ID", "MEMBER_LOGINID", "MEMBER_PASS", "MEMBER_NAME", "MEMBER_AGE", "MEMBER_TELNUM",
				"MEMBER_AUTHORITY", "MEMBER_MILEAGE" };
		for (int i = 0; i < key.length; i++) {
			p.add(member.get(key[i]));
		}
		p.add(member.get("MEMBER_ID"));
		return jdbc.update(sql, p);

	}

	public int delete() {
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("MEMBER_ID"));

		return jdbc.update(sql, param);
	}

	public int insertMember(Map<String, Object> param) {
		String sql = "INSERT INTO MEMBER" + "	VALUES(?,?,?,?,?,?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("MEMBER_ID"));
		p.add(param.get("MEMBER_LOGINID"));
		p.add(param.get("MEMBER_PASSWORD"));
		p.add(param.get("MEMBER_NAME"));
		p.add(param.get("MEMBER_AGE"));
		p.add(param.get("MEMBER_TELNUM"));
		p.add(param.get("MEMBER_AUTHORITY"));
		p.add(param.get("MEMBER_MILEAGE"));
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectMember(String memberLoginId, String pass) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_LOGINID = ?" + "AND MEMBER_PASSWORD = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberLoginId);
		param.add(pass);

		return jdbc.selectOne(sql, param);
	}

	public int updatePass(Map<String, Object> member) {
		String sql = "UPDATE MEMBER\r\n" + "SET\r\n" + "MEMBER_PASS = ?;\r\n";

		List<Object> p = new ArrayList<>();
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectMemberSearchAccount(String memberLoginId, String age) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_LOGINID = ?" + "AND MEMBER_AGE = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberLoginId);
		param.add(age);

		return jdbc.selectOne(sql, param);
	}
}
