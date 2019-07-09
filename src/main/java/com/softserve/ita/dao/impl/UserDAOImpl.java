package com.softserve.ita.dao.impl;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;
import com.softserve.ita.util.DbConnector;
import exception.DAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private final static Logger logger = LoggerFactory.getLogger(DAOException.class);
	private DbConnector dbConnect = new DbConnector();
	private int login_system_id = 0;

	@Override
	public boolean getUserByLoginAndPassword(String login, String password) throws DAOException {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM login_system WHERE login='" + login + "' AND password='" + password + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean registerUser(String login, String password, String repeatedPassword) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM login_system where login=?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
			if (rs.next() || login.trim().length() == 0 || password.trim().length() == 0
					|| repeatedPassword.trim().length() == 0 || !password.equals(repeatedPassword)) {
				return false;
			} else {
				query = "insert into login_system(login,password) values(?,?)";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, login);
				stmt.setString(2, password);
				stmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		}
	}

	@Override
	public boolean insertingStudentIntoUser(String name, String surname, String date, int login_system_id,
			int points_for_entry_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		String query = "INSERT INTO entrant(name,surname,date_of_birth,login_system_id,points_for_entry_id) VALUES(?,?,?,?,?)";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, surname);
			stmt.setString(3, date);
			stmt.setInt(4, login_system_id);
			stmt.setInt(5, points_for_entry_id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		}
	}

	@Override
	public boolean insertingStudentIntoPointsForEntry(int math, int language1, int language2, int certificate) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		String query = "INSERT INTO points_for_entry(subject1,subject2,subject3,certificate) VALUES(?,?,?,?)";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, math);
			stmt.setInt(2, language1);
			stmt.setInt(3, language2);
			stmt.setInt(4, certificate);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		}
	}

	@Override
	public Integer getIdOfUser(String login, String password) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select id from login_system where login='" + login + "' AND password='" + password + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				login_system_id = rs.getInt(1);
			}
			return login_system_id;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int getIdOfPoints() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idOfPoints = 0;
		String query = "SELECT MAX(id) from points_for_entry";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOfPoints = rs.getInt(1);
			}
			return idOfPoints;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int checkIdInUsers(String name, String surname, int login_system_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idOfPointsForEntry = 0;
		String query = "SELECT points_for_entry_id from entrant where name='" + name + "' and surname='" + surname
				+ "' and login_system_id='" + login_system_id + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOfPointsForEntry = rs.getInt(1);
			}
			return idOfPointsForEntry;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public User gettingUserByIdFromUser(int login_system_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * from entrant where login_system_id='" + login_system_id + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
			}
			return new User();
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean insertIntoUserHasFaculty(int entrantId, int facultyId) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "INSERT INTO entrant_has_faculties VALUES (?,?)";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, entrantId);
			stmt.setInt(2, facultyId);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int findingIdOfInstitute(String faculty) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idOfFaculty = 0;
		String query = "SELECT id FROM faculties where faculty = ?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, faculty);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOfFaculty = rs.getInt(1);
			}
			return idOfFaculty;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean checkOnDulicatesInUserHasFaculty(int entrantId, int facultyId) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM entrant_has_faculties where entrant_id = ? and faculties_id=?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, entrantId);
			stmt.setInt(2, facultyId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int idOfUserByIdOfLoginSystem(int login_system_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idOfUser = 0;
		String query = "SELECT id FROM entrant where login_system_id = ?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, login_system_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOfUser = rs.getInt(1);
			}
			return idOfUser;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int idOfInstitute(int idOfEntrantFromEntrantHasFaculty) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int zero = 0;
		String query = "SELECT faculties_id FROM entrant_has_faculties where entrant_id = ?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, idOfEntrantFromEntrantHasFaculty);
			rs = stmt.executeQuery();

			if (rs.next()) {
				zero = rs.getInt(1);
			}
			return zero;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean insertingoInResult(double points, int entrantId, int entrantLoginSystemId,
			int entrant_points_for_entry_id, int facultiesId) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "INSERT INTO results(points, Entrant_Id, Entrant_login_system_id, Entrant_points_for_entry_id, faculties_Id) VALUES(?,?,?,?,?)";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setDouble(1, points);
			stmt.setInt(2, entrantId);
			stmt.setInt(3, entrantLoginSystemId);
			stmt.setInt(4, entrant_points_for_entry_id);
			stmt.setInt(5, facultiesId);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int findPointsInResults(int entrant_login_system_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT points from results where entrant_login_system_id = ?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setDouble(1, entrant_login_system_id);
			rs = stmt.executeQuery();
			int points = 0;
			if (rs.next()) {
				points = rs.getInt(1);
			}
			return points;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public List<User> allFromLoginSystem() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT * FROM login_system";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public User getUserByIdFromLoginSystem(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM login_system WHERE id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			return null;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean updateLoginSystemId(int id, String login, String password, String typeOfUser) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "UPDATE login_system SET login=?,password=?,type_of_user=? WHERE id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, typeOfUser);
			ps.setInt(4, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean deleteFromLoginSystem(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "DELETE FROM login_system where id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean deleteFromUserHasFaculties(int idOfUser) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "DELETE FROM entrant_has_faculties where entrant_id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, idOfUser);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean deleteUserFromResults(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "DELETE FROM results where Entrant_id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean deleteUserFromEntrant(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "DELETE FROM entrant where id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public int idOfPoints(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idOfPoints = 0;
		String query = "SELECT points_for_entry_id from entrant where id=?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				idOfPoints = rs.getInt(1);
			}
			return idOfPoints;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	public boolean deleteFromPoints(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "DELETE FROM points_for_entry where id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public List<User> seeAllEntrantsOnWeb() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"web development\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	@Override
	public List<User> seeAllEntrantsOnMath() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"math\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	@Override
	public List<User> seeAllEntrantsOnEconomy() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"economy\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	
	@Override
	public List<User> seeAllEntrantsOnChemistry() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"chemistry\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	@Override
	public List<User> seeAllEntrantsOnLaw() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"law\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	
	@Override
	public List<User> seeAllEntrantsOnForeignLanguage() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"foreign language\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	@Override
	public List<User> seeAllEntrantsOnComputerScience() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT name, surname, points, Faculty\r\n" + 
				"FROM entrant AS en\r\n" + 
				"INNER JOIN results AS re ON en.id = re.Entrant_id\r\n" + 
				"INNER JOIN faculties fac ON re.faculties_id = fac.id\r\n" + 
				"WHERE Faculty =  \"computer science\"\r\n" + 
				"GROUP BY points DESC";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public List<User> allFromEntrant() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT * FROM entrant";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
	
	@Override
	public User gettingUserByIdOfUserFromUser(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * from entrant where id='" + id + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
			}
			return new User();
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean updateEntrant(int id, String name, String surname, String date) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "UPDATE entrant SET name=?,surname=?, date_of_birth=? WHERE id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, date);
			ps.setInt(4, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public List<User> allFromPoints() {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String query = "SELECT * FROM points_for_entry";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
			}
			return list;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public User gettingPointsById(int id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * from points_for_entry where id='" + id + "'";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt(1),rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
			}
			return new User();
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}

	@Override
	public boolean updatePoints(int id, double subject1, double subject2, double subject3, double certificate) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "UPDATE points_for_entry SET Subject1=?,Subject2=?, Subject3=?, Certificate=? WHERE id=?";
		try (Connection con = ds.getConnection()) {
			ps = con.prepareStatement(query);
			ps.setDouble(1, subject1);
			ps.setDouble(2, subject2);
			ps.setDouble(3, subject3);
			ps.setDouble(4, certificate);
			ps.setInt(5, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Error while retrieving user from database", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				logger.error("Error while RS and PreparedStatement close");
			}
		}
	}
}
