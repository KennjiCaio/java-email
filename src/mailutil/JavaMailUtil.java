package mailutil;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {	
	
	public static void sendMail(Email email) throws MessagingException {
		System.out.println("Preparing to send email");
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(email.getMyEmail(), email.getMyPassword());
			}
		});
		
		Message message = prepareMassage(session, email);
		
		Transport.send(message);
		System.out.println("Message sent successfully!");
	}

	private static Message prepareMassage(Session session, Email email) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getMyEmail()));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getSendToEmail()));
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			return message;
		}
		catch(Exception ex) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
