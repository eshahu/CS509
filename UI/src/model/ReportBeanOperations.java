package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReportBeanOperations {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int pageCount;//getPageCount()
	int pageSize=3;
	
	//-----get pageCount-----
	public int getPageCount() {
		try {
			int rowCount = 0; // total records --- based on table
			// retrieve rowCount
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from report ");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}

			// calculate pageCount
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.close();
		}
		return this.pageCount;
	}
	// ------paging function------
	// use arraylist to store resourses so that we can close resultset and
	// seperate the link with database
	public ArrayList<ReportBean> getResultByPage(int pageNow) {
		ArrayList<ReportBean> al = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from report limit ?,?");
			// give ? value, limit the number of records being showed
			pstmt.setInt(1, pageSize * (pageNow - 1));
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// put rs record encapsulate into UserBean
				ReportBean ub = new ReportBean();
				ub.setLogNumber(rs.getInt(1));
				ub.setReporter(rs.getString(2));
				ub.setVictim(rs.getString(3));
				ub.setAbuser(rs.getString(4));
				ub.setDescription(rs.getString(5));
				
				// put ub into arraylist
				al.add(ub);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}
	
	//----------update appeal-------------
	public boolean updateUser(String logNumber,String appeal) {
		boolean b=false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			String sql = "update report set appeal='"+appeal+"' where logNumber='"+logNumber+"'";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			int num = pstmt.executeUpdate();
			if(num==1) {
				//update successfully
				b=true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	
	//-----close resources-----
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}