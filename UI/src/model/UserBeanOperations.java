package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//control UserBean which is the mapping of users table

public class UserBeanOperations {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	int pageCount; // total pages --- based on calculation
	int pageSize=3;//set pageSize

	
    public static void main(String[] args) {
    }
	
	//------------insert user--------------
	public boolean addUser(String firstName, String lastName, String email, String password) {
		boolean b=false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			String sql = "insert into supervisor values(NULL,'"+firstName+"','"+lastName+"','"+email+"','"+password+"')";
			  
			pstmt = conn.prepareStatement(sql);
			int num = pstmt.executeUpdate();
			if(num==1) {
				//insert successfully
				b=true;
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	
	//-----------update user-------------
	public boolean updateUser(String id, String p, String e, String g) {
		boolean b=false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			String sql = "update supervisor set password='"+p+"' ,email= '"+e+"',grade='"+g+"' where userID='"+id+"'";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			int num = pstmt.executeUpdate();
			if(num==1) {
				//delete successfully
				b=true;
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
	
	// ------------delete user------------
	public boolean delUser(String id) {
		boolean b=false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			String sql = "delete from supervisor where userID='"+id+"'";
			pstmt = conn.prepareStatement(sql);
			int num = pstmt.executeUpdate();
			if(num==1) {
				//delete successfully
				b=true;
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	// ------return pageCount----pageCount will be calculated by calling paging
	// function
	public int getPageCount() {
		try {
			int rowCount = 0; // total records --- based on table
			// retrieve rowCount
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from supervisor ");
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
	public ArrayList<UserBean> getResultByPage(int pageNow) {
		ArrayList<UserBean> al = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from supervisor limit ?,?");
			// give ? value, limit the number of records being showed
			pstmt.setInt(1, pageSize * (pageNow - 1));
			pstmt.setInt(2, pageSize);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// put rs record encapsulate into UserBean
				UserBean ub = new UserBean();
				ub.setSupID(rs.getInt(1));
				ub.setSupName(rs.getString(2));
				ub.setSupPW(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setGrade(rs.getInt(5));

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

	// ------identify user-----
	public boolean checkUser(String email, String password) {
		boolean b = false;
		try {
			// get Connection
			conn = DBUtil.getConnection();
			pstmt = conn
					.prepareStatement("select SupPassword from supervisor where SupEmail=? limit 1");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			//judge user through result
			if (rs.next()) {
				//indicate username exists
				String userPassword = rs.getString(1);
				if (userPassword.equals(password)) {
					//legal user
					b = true;
				}//wrong password
			}//wrong username
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	// close resources
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
