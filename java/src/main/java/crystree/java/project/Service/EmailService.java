package crystree.java.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
      @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail,  Long user_id , String user_name) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(toEmail);
        message.setTo(toEmail);
        message.setSubject("Set your password");
        message.setText("Please click the link below to set your password for Crystal on user "+ user_name + ""
                + "https://erp.ortholink.in/pass/"+user_id);
        mailSender.send(message);
    }
}
