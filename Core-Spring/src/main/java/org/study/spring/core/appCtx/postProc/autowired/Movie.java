package org.study.spring.core.appCtx.postProc.autowired;

import java.beans.ConstructorProperties;

public class Movie {

	private String name;
	private int year;
	private String language;
	
	@ConstructorProperties({"name", "year", "lang"})
	public Movie(String nm, int yr, String lang) {
		this.setName(nm);
		this.setYear(yr);
		this.setLanguage(lang);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "[Name=" + name + ",Year=" + year + ",Lang=" + language + "]";
	}
}
