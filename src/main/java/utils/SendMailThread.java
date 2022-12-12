package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import regist.MemberBean;

public class SendMailThread extends Thread{
//    Logger log = Logger.getLogger(SendMailThread.class);

    private MemberBean user=null;
    public SendMailThread(MemberBean user) {
        this.user = user;
    }

    @Override
    public void run() {
        
        	 String from = "nw755162";
             String pass = "knvmardwpikvwlbz";
             //String[] to = { "nw755162@gmail.com" }; // list of recipient email addresses
             Date date = new Date();
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             String subject = "UniversalHouse - 電子信箱驗證信";
             String body = "<h1>Welcome to UniversalHouse! " + now +"</h1><br>" ;
             
        	
        	Properties props = System.getProperties();
             String host = "smtp.gmail.com";
             props.put("mail.smtp.starttls.enable", "true");
             props.put("mail.smtp.host", host);
             props.put("mail.smtp.user", from);
             props.put("mail.smtp.password", pass);
             props.put("mail.smtp.port", "587");
             props.put("mail.smtp.auth", "true");
             Session session = Session.getDefaultInstance(props);
             MimeMessage message = new MimeMessage(session);
             
             try {
                 message.setFrom(new InternetAddress(from));
                 InternetAddress toAddress = new InternetAddress(user.getEmail());

                 // To get the array of addresses
                 toAddress =  new InternetAddress( user.getEmail() );
                 message.addRecipient(Message.RecipientType.TO, toAddress);

                 message.setSubject(subject);
//                 message.setText(body);
                 
                 
                 
                 MimeBodyPart textPart = new MimeBodyPart();
                 StringBuffer html = new StringBuffer();
                 html.append(body);
                 html.append("<h3>點擊下列連結驗證</h3><br>");
                 String a= "<a href=\"http://localhost:8080/Topic2/utils/VerifyServlet.do?"+ "memberId="+ user.getMemberId() +  "\">verify your account</a><br>";
                 html.append(a);
//                 html.append("<img src='cid:image'/><br>");
                 textPart.setContent(html.toString(), "text/html; charset=UTF-8");

                 // 圖檔部份，注意 html 用 cid:image，則header要設<image>
//                 MimeBodyPart picturePart = new MimeBodyPart();
//                 FileDataSource fds = new FileDataSource("YourPictureFile.jpg");
//                 picturePart.setDataHandler(new DataHandler(fds));
//                 picturePart.setFileName(fds.getName());
//                 picturePart.setHeader("Content-ID", "<image>");

                 Multipart email = new MimeMultipart();
                 email.addBodyPart(textPart);
//                 email.addBodyPart(picturePart);

                 message.setContent(email);
                 
                 
                 
                 
                 
                 
                 
                 
                 Transport transport = session.getTransport("smtp");
                 transport.connect(host, from, pass);
                 transport.sendMessage(message, message.getAllRecipients());
                 transport.close();
             }
             catch (AddressException ae) {
                 ae.printStackTrace();
             }
             catch (MessagingException me) {
                 me.printStackTrace();
             }
        	
    }
}
