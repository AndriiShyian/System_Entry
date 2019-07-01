package com.softserve.ita.dao;

import java.util.List;

import com.softserve.ita.model.User;

public interface UserDAO {
	
	boolean getUserByLoginAndPassword(String login, String password);

	boolean registerUser(String login, String password, String repeatedPassword);

	boolean insertingStudentIntoUser(String name, String surname, String date, int login_system_id,
			int points_for_entry_id);

	boolean insertingStudentIntoPointsForEntry(int math, int language1, int language2, int certificate);

	Integer getIdOfUser(String login, String password);

	int getIdOfPoints();

	int checkIdInUsers(String login, String password, int login_system_id);

	User gettingUserByIdFromUser(int login_system_id);

	boolean insertIntoUserHasFaculty(int entrantId, int facultyId);

	int findingIdOfInstitute(String faculty);

	boolean checkOnDulicatesInUserHasFaculty(int entrantId, int facultyId);

	int idOfUserByIdOfLoginSystem(int login_system_id);
	
	int idOfInstitute(int idOfUserFromUserHasFaculty);
	
	boolean insertingoInResult(double points, int entrantId, int entrantLoginSystemId, int entrant_points_for_entry_id, int facultiesId);
	
	int findPointsInResults(int entrant_login_system_id);
	
	List<User> allFromLoginSystem();
	
	User getUserByIdFromLoginSystem(int id);
	
	boolean updateLoginSystemId(int id,String login, String password, String typeOfUser);
	
	boolean deleteFromLoginSystem(int id);
	
	boolean deleteFromUserHasFaculties(int idOfUser);
	
	boolean deleteUserFromResults(int id);
	
	boolean deleteUserFromEntrant(int id);
	
	int idOfPoints(int id);
	
	boolean deleteFromPoints(int id);
	
	List<User> seeAllEntrantsOnWeb();
	
	List<User> seeAllEntrantsOnMath();
	
	List<User> seeAllEntrantsOnEconomy();
	
	List<User> seeAllEntrantsOnChemistry();
	
	List<User> seeAllEntrantsOnLaw();
	
	List<User> seeAllEntrantsOnForeignLanguage();
	
	List<User> seeAllEntrantsOnComputerScience();

	
}
