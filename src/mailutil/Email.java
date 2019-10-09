package mailutil;

public class Email {

	private String myEmail;
	private String myPassword;
	private String sendToEmail;
	private String subject;
	private String text;

	public Email() {
	}

	public Email(String myEmail, String myPassword, String sendToEmail, String subject, String text) {
		this.myEmail = myEmail;
		this.myPassword = myPassword;
		this.sendToEmail = sendToEmail;
		this.subject = subject;
		this.text = text;
	}

	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}

	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}

	public String getSendToEmail() {
		return sendToEmail;
	}

	public void setSendToEmail(String sendToEmail) {
		this.sendToEmail = sendToEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
