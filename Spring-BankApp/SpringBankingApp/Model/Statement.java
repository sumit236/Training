package model;

import java.util.Date;

public class Statement {

	private Date date;
	private String content;

	/**
	 * @param date
	 * @param content
	 */
	public Statement(String content) {
		this.date = new Date();
		this.content = content;
	}

	/**
	 * @return the date.
	 */
	public Date getDate() {
		return new Date();
	}

	/**
	 * @return the content.
	 */
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Statement [date=" + date + ", content=" + content + "]";
	}

}