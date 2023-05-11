package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.domain.EmpDomain;

public class EmpDAO {
	public List<EmpDomain> selectDeptEmp(int deptno) throws SQLException{
		
		List<EmpDomain> list  = new ArrayList<EmpDomain>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url, id, pass);
			StringBuilder selectEmp = new StringBuilder();
			
			selectEmp
			.append("  select empno, ename, job, mgr, hiredate, sal, comm   ")
			.append("  from emp ")
			.append("  where deptno=? ");
			
			pstmt=con.prepareStatement(selectEmp.toString());
			pstmt.setInt(1, deptno);
			
			rs=pstmt.executeQuery();
			
			EmpDomain ed = null;
			
			while(rs.next()) {
				ed = new EmpDomain( rs.getInt("empno"), rs.getInt("mgr"), rs.getInt("sal"), rs.getInt("comm"), deptno,
						rs.getString("ename"), rs.getString("job"), rs.getDate("hiredate"));
				list.add(ed);
			}//end while
			
		}finally {
			if(rs != null) { rs.close(); }
			if(con != null) { con.close(); }
			if(pstmt != null) { pstmt.close(); }
		}//end finally
		
		return list;
	}//selectDeptEmp

}
