package crystree.java.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
      @Autowired
    private JavaMailSender mailSender;
   

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendUserIdByEmail(String toEmail, Long userId) {
        if (toEmail == null || toEmail.isEmpty()) {
            throw new RuntimeException("User does not have a registered email.");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your User ID Information");
        message.setText("Dear User,\n\nYour User ID is: " + userId + " " +"http://localhost:3000/reset-password/"+userId);

        mailSender.send(message);
    }
    // public void sendVerificationEmail(String toEmail,  Long user_id , String user_name) {
    //     SimpleMailMessage message = new SimpleMailMessage();
    //     System.out.println(toEmail);
    //     message.setTo(toEmail);
    //     message.setSubject("Set your password");
    //     message.setText("Please click the link below to set your password for Crystal on user "+ user_name + ""
    //             + "https://erp.ortholink.in/pass/"+user_id);
    //     mailSender.send(message);
    // }
}
