package com.softserve.ita.dao.impl;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;
import com.softserve.ita.util.DbConnector;
import exception.DAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	private final static Logger logger = LoggerFactory.getLogger(DAOException.class);
	private DbConnector dbConnect = new DbConnector();
	private int login_system_id = 0;

	@Override
	public User getUserById(int id) throws DAOException {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM login_system WHERE id = ?";
		try (Connection conn = ds.getConnection()) {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			} else
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
	public boolean insertingWebStudentIntoUser(String name, String surname, String date, int login_system_id,
			int points_for_entry_id) {
		DataSource ds = dbConnect.getMySQLDataSource();
		PreparedStatement stmt = null;
		String query = "INSERT INTO user(name,surname,date_of_birth,login_system_id,points_for_entry_id) VALUES(?,?,?,?,?)";
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
	public boolean insertingWebStudentIntoPointsForEntry(int math, int language1, int language2, int certificate) {
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
		String query = "SELECT points_for_entry_id from user where name='"+name+"' and surname='"+surname+"' and login_system_id='"+login_system_id+"'";
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
}
