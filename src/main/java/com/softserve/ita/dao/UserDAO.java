package com.softserve.ita.dao;

import com.softserve.ita.model.User;

public interface UserDAO {
	User getUserById(int id);

	boolean getUserByLoginAndPassword(String login, String password);

	boolean registerUser(String login, String password, String repeatedPassword);

	boolean insertingWebStudentIntoUser(String name, String surname, String date, int login_system_id, int points_for_entry_id);
	boolean insertingWebStudentIntoPointsForEntry(int math, int language1, int language2,int certificate);
    Integer getIdOfUser(String login,String password);
    int getIdOfPoints();
    int checkIdInUsers(String login, String password,int login_system_id);
}
