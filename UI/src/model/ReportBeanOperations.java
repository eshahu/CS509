package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pstmt = conn.prepareStatement("select count(*) from inireport ");
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
			pstmt = conn.prepareStatement("select * from inireport limit ?,?");
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
	
	public boolean update(String logID, String key, String value) {
		boolean b=false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			String sql = "update inireport set "+ key + "='" + value 
					+ "' where ReportID='"+logID+"'";
			
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
	

	//----------update appeal-------------
	public boolean updateUser(String logID,String appeal) {
		return update(logID, "appeal", appeal);
	}
	
	public ReportBean getReport(String logID) {
		ReportBean ub = new ReportBean(); 
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from inireport where ReportID=" + logID);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ub.setLogNumber(rs.getInt(1));
				ub.setReporterFirst(rs.getString(2));
				ub.setReporterLast(rs.getString(3));
				ub.setReportPhone(rs.getString(4));
				ub.setReportAddr(rs.getString(5));
				ub.setVictimFirst(rs.getString(6));
				ub.setVictimLast(rs.getString(7));
				ub.setVictimPhone(rs.getString(8));
				ub.setVictimAddr(rs.getString(9));
				ub.setAbuserFirst(rs.getString(10));
				ub.setAbuserLast(rs.getString(11));
				ub.setAbuserPhone(rs.getString(12));
				ub.setAbuserAddr(rs.getString(13));
				break;
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return ub;
	}

	public boolean udpateReport(String logID, String reporterFirst, String reporterLast,
			String reporterPhone, String reporterAddr, String victimFirst,
			String victimLast, String victimPhone, String victimAddr,
			String abuserFirst, String abuserLast, String abuserPhone,
			String abuserAddr) {
		
		boolean b = update(logID, "ReporterFirst", reporterFirst) &&
				update(logID, "ReporterLast", reporterLast) &&
				update(logID, "ReportPhone", reporterPhone) &&
				update(logID, "ReporterAddr", reporterAddr) &&
				update(logID, "VictimFirst", victimFirst) &&
				update(logID, "VictimLast", victimLast) &&
				update(logID, "VictimAddr", victimAddr) &&
				update(logID, "VictimPhone", victimPhone) &&
				update(logID, "AbuserFirst", abuserFirst) &&
				update(logID, "AbuserLast", abuserLast) &&
				update(logID, "AbuserPhone", abuserPhone) &&
				update(logID, "AbuserAddr", abuserAddr);
		
		return b;
		
	}
	
	// ---------add report-----------------
		public boolean addReport(String rf, String rl, String rp, String ra,
				String vf, String vl, String vp, String va, String af, String al,
				String ap, String aa) {
			boolean b = false;
			try {
				// get Connection
				conn = DBUtil.getConnection();
				String sql = "insert into inireport values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rf);
				pstmt.setString(2, rl);
				pstmt.setString(3, rp);
				pstmt.setString(4, ra);
				pstmt.setString(5, vf);
				pstmt.setString(6, vl);
				pstmt.setString(7, vp);
				pstmt.setString(8, va);
				pstmt.setString(9, af);
				pstmt.setString(10, al);
				pstmt.setString(11, ap);
				pstmt.setString(12, aa);
				int num = pstmt.executeUpdate();
				if (num == 1) {
					// insert successfully
					b = true;
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
