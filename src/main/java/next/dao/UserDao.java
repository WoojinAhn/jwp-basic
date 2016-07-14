package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import core.jdbc.InsertJdbcTemplate;
import core.jdbc.UpdateJdbcTemplate;
import next.model.User;

public class UserDao {
	public void insert(User user) throws SQLException {
		InsertJdbcTemplate insertJdbcTemplate = new InsertJdbcTemplate();
		insertJdbcTemplate.insert(user, new UserDao());
	}

	public String createQueryForInsert() {
		return "INSERT INTO USERS VALUES (?, ?, ?, ?)";
	}

	public void update(User user) throws SQLException {
		UpdateJdbcTemplate updateJdbcTemplate = new UpdateJdbcTemplate();
		updateJdbcTemplate.update(user, new UserDao());
	}

	public String createQueryForUpdate() {
		return "UPDATE USERS SET password = ?, name = ?, email = ? WHERE userId = ?";
	}

	public PreparedStatement setValuesForInsert(User user, Connection con, String sql) throws SQLException {
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		return pstmt;
	}

	public PreparedStatement setValuesForUpdate(User user, Connection con, String sql) throws SQLException {
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getUserId());
		return pstmt;
	}

	public List<User> findAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> userArrayList = new ArrayList<>();
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT * FROM USERS";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				user = new User(
						rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
				userArrayList.add(user);
			}
			return userArrayList;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public User findByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				user = new User(
						rs.getString("userId"), 
						rs.getString("password"), 
						rs.getString("name"),
						rs.getString("email"));
			}

			return user;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
