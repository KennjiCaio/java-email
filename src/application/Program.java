package application;

import java.util.Scanner;

import javax.mail.MessagingException;

import mailutil.Email;
import mailutil.JavaMailUtil;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("########## Sistema de Envio de E-mail ##########");
			System.out.println("------------------------------------------------");
			System.out.println("**********         Seus dados         **********");
			System.out.print("Insira seu email: ");
			String myEmail = sc.nextLine();
			System.out.print("Insira sua senha: ");
			String myPassword = sc.nextLine();
			System.out.println("------------------------------------------------");
			System.out.println("**********   Dados do usuário/email   **********");
			System.out.print("Insira o email do usuário:");
			String emailUsuario = sc.nextLine();
			System.out.print("Insira o assunto: ");
			String assunto = sc.nextLine();
			System.out.print("Insira o texto: ");
			String texto = sc.nextLine();
			
			Email email = new Email(myEmail, myPassword, emailUsuario, assunto, texto);
			
			System.out.println(email.getMyEmail());
			System.out.println(email.getMyPassword());
			System.out.println(email.getSendToEmail());
			System.out.println(email.getSubject());
			System.out.println(email.getText());
			
			JavaMailUtil.sendMail(email);
			
		}
		catch(MessagingException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
