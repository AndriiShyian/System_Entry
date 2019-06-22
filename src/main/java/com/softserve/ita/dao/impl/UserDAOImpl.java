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
}
