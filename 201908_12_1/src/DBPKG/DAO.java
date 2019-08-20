package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ExamDTO;

public class DAO {
	private DAO() {};
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return conn;
		
	}
	public boolean bunChech(int bun) throws Exception{
		boolean bool = false;
		
		String sql = "select count(*) from table_01 where stubun="+bun;
		Connection conn =getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(rs.getInt(1)==0)
				bool = true;
		}
		return bool;
	}
	public List<ExamDTO> getGrade() throws Exception{
		List<ExamDTO> list = new ArrayList<ExamDTO>();
		String sql ="select s.stubun,s.stuname,s.stubirth,g.kor,g.eng,g.mat from table_01 s, table_02 g where s.stubun = g.stubun order by g.kor+g.eng+g.mat desc" ;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			ExamDTO vo = new ExamDTO();
			vo.setStubun(rs.getInt(1));
			vo.setStuname(rs.getString(2));
			vo.setStubirth(rs.getDate(3).toString());
			vo.setKor(rs.getInt(4));
			vo.setEng(rs.getInt(5));
			vo.setMath(rs.getInt(6));
			list.add(vo);
		}
		return list;
	}
	public ExamDTO getSelf(String num) throws Exception{
		ExamDTO vo = new ExamDTO();
		String sql = "select * from table_01 where stubun = "+num;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			vo.setStubun(rs.getInt("stubun"));
			vo.setStuname(rs.getString("stuname"));
			vo.setStuphone(rs.getString("stuphone"));
			vo.setStubirth(rs.getDate("stubirth").toString());
			vo.setStuaddr(rs.getString("stuaddr"));
		}
		
		
		return vo;
		
		
	}
	public int edit(ExamDTO vo) throws Exception{
		int row = 0;
		String sql = "update table_01 set stuname = ?, stuphone = ?, stubirth = ?, stuaddr = ? where stubun = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getStuname());
		pstmt.setString(2, vo.getStuphone());
		pstmt.setString(3, vo.getStubirth());
		pstmt.setString(4, vo.getStuaddr());
		pstmt.setInt(5, vo.getStubun());

		row = pstmt.executeUpdate();
		return row;
		
	}
	public int insert(ExamDTO vo) throws Exception{
		String sql = "insert into table_01 values(?,?,?,?,?)";
		

		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getStubun());
		pstmt.setString(2,vo.getStuname());
		pstmt.setString(3,vo.getStuaddr());
		pstmt.setString(4, vo.getStuphone());
		pstmt.setString(5,vo.getStubirth());
		int row = pstmt.executeUpdate();
		return row;
		
	}
	public List<ExamDTO> getVO() throws Exception {

		String sql = "select * from table_01";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ExamDTO> list = new ArrayList<ExamDTO>();
		
		while(rs.next()) {
			ExamDTO vo = new ExamDTO();
			vo.setStubun(rs.getInt("stubun"));
			vo.setStuname(rs.getString("stuname"));
			vo.setStuphone(rs.getString("stuphone"));
			vo.setStubirth(rs.getDate("stubirth").toString());
			vo.setStuaddr(rs.getString("stuaddr"));
			list.add(vo);
		
		}

		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
