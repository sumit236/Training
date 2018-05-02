

import java.util.Date;

public class Statement {
	private Date date;
	private String content;

	public Statement(String content) {
		this.date = new Date();
		this.content = content;
	}

	public Date getDate() {
		return new Date();
	}

	@Override
	public String toString() {
		return "Statement [date=" + date + ", content=" + content + "]";
	}

	public String getContent() {
		return content;
	}

}