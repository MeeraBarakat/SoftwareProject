package mymain;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class WebEmailService {
public void sendEmail(String to,List<Home> result2) throws IOException, MessagingException {
	
	String from = "meera.gh.barakat@gmail.com";
	
	StringBuilder buffer=new StringBuilder();
	for(Home h:result2) {
		buffer.append(h.toString()+"\n \n");  
		
	   }
    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();

    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("meera.gh.barakat@gmail.com", "mysocial2000meera");

        }

    });
      
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject("Dear client this is the list of your spec");

        Multipart multipart = new MimeMultipart();

        MimeBodyPart attachmentPart = new MimeBodyPart();

        MimeBodyPart textPart = new MimeBodyPart();


            File f =new File("icons8-stormtrooper-100.png");

            attachmentPart.attachFile(f);
            textPart.setText(buffer.toString());
            multipart.addBodyPart(textPart);

        message.setContent(multipart);
        Transport.send(message);
 
}

	
}

