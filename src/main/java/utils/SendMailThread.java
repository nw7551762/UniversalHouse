package utils;

import java.util.Date;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import regist.MemberBean;

public class SendMailThread extends Thread{
//    Logger log = Logger.getLogger(SendMailThread.class);

    private MemberBean user=null;
    public SendMailThread(MemberBean user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            Properties p = new Properties();
            p.setProperty("mail.host", "smtp.mail.yahoo.com");
            p.setProperty("mail.smtp.auth", "true");//認證登錄
            Session session = Session.getDefaultInstance(p, new Authenticator() {
		
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("menc86652","uzbshzjzlderssof");
                }
            });

            session.setDebug(true);//以debug方式(應答方式)進行通訊

            //準備郵件///////有問題
            MimeMessage msg = new MimeMessage(session); //從session中創建郵件
            msg.setFrom( new InternetAddress("menc86652@yahoo.com.tw") );
            msg.setRecipient(RecipientType.TO, new InternetAddress( user.getEmail() ) );////※※※
            msg.setSubject("賬號激活郵件,城院公司歡迎你!");
            String info = "激活:<a href='http://127.0.0.1:8080/mailWeb1602/ActiveServlet?acode="+user.getMemberId()+"'>激活</a>";
            info = info + "<br/>如果激活未成功，請把地址複製到瀏覽器進行手動請求以進行激活:http://127.0.0.1:8080/mailWeb1602/ActiveServlet?acode="+user.getMemberId();

            msg.setContent(info, "text/html;charset=utf-8");
            msg.setSentDate( new Date() );
            //發送郵件
            Transport.send(msg);
//            log.info("郵件成功發送到:"+user.getEmail());
        } catch (Exception e) {
//            log.error("郵件發送失敗,郵箱地址爲:"+user.getEmail());
            e.printStackTrace();
        }
    }
}
