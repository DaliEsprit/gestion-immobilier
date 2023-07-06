package tn.esprit.immobilier.utils;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    private final JavaMailSender javaMailSender;
   public void sendMail(String to,String subject,String text){
       SimpleMailMessage message = new SimpleMailMessage();
       message.setTo(to);
       message.setSubject(subject);
       message.setFrom("nouri.mohamedali@esprit.tn");
       message.setText(text);
       javaMailSender.send(message);
   }
}
