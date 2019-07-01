package com.softserve.ita.model;

import java.util.Objects;

/**
 * POJO(Java Bean)
 */
public class User {
	private int id;
	private String login;
	private String password;
	private String name;
	private String date;
	private int idOfUser;
	private int idOfPoints;
	private String typeOfUser;
	private String surname;
	private double points;
	private String faculty;
	private double subject1;
	private double subject2;
	private double subject3;
	private double certificate;

	public double getSubject1() {
		return subject1;
	}

	public void setSubject1(int subject1) {
		this.subject1 = subject1;
	}

	public double getSubject2() {
		return subject2;
	}

	public void setSubject2(int subject2) {
		this.subject2 = subject2;
	}

	public double getSubject3() {
		return subject3;
	}

	public void setSubject3(int subject3) {
		this.subject3 = subject3;
	}

	public double getCertificate() {
		return certificate;
	}

	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public User() {

	}

	public User(int id, double subject1, double subject2, double subject3, double certificate) {
		this.id = id;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.certificate = certificate;

	}

	public User(int id, String name, String surname, String date, int idOfUser, int idOfPoints) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.idOfUser = idOfUser;
		this.idOfPoints = idOfPoints;
	}

	public User(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public User(int id, String login, String password, String typeOfUser) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.typeOfUser = typeOfUser;
	}

	public User(String name, String surname, String date, int idOfUser, int idOfPoints) {
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.idOfUser = idOfUser;
		this.idOfPoints = idOfPoints;
	}

	public User(String name, String surname, double points, String faculty) {
		this.name = name;
		this.surname = surname;
		this.points = points;
		this.faculty = faculty;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdOfUser() {
		return idOfUser;
	}

	public void setIdOfUser(int idOfUser) {
		this.idOfUser = idOfUser;
	}

	public int getIdOfPoints() {
		return idOfPoints;
	}

	public void setIdOfPoints(int idOfPoints) {
		this.idOfPoints = idOfPoints;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "name=" + name + ", surname='" + surname + '\'' + ", date='" + date + '\'' + ", idOfUser='"
				+ idOfUser + '\'' + ",idOfPoints='" + idOfPoints + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, password);
	}
}
