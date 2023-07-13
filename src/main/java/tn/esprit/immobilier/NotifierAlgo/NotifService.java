package tn.esprit.immobilier.NotifierAlgo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import tn.esprit.immobilier.entities.Notification;
import tn.esprit.immobilier.entities.enums.RolesTypes;
import tn.esprit.immobilier.repositories.INotification;

@Service
public class NotifService {
	
	 private static final Logger logger = LoggerFactory.getLogger(NotifService.class);

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private INotification notifRepo;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	
	public void notifier(int input,String title, String message) {
		
//		CASES [0 -> 5]
		// SELLER : ybi3 VENDEUR  || BUYER : chari 
		// case 0 : ROLE_SELLER || case 1 : ROLE_ADMIN
		// case 2 : ROLE_BUYER || case 3 : ROLE_AGENT
		
		// case 4 : ROLE_SELLER(VENDEUR) +  ROLE_AGENT
		// case 5 : ROLE_SELLER +  ROLE_ADMIN
		
		 
		switch (input) {
		case 0:
			Notification notif0 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_SELLER));
			
			messagingTemplate.convertAndSend("/topic/push/notif/0", notif0);
			 logger.info("Received notification: {}", notif0);
			notifRepo.save(notif0);
			break;
		case 1:
			Notification notif1 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_ADMIN));
			
			messagingTemplate.convertAndSend("/topic/push/notif/1" , notif1);
			logger.info("Received notification: {}", notif1);
			notifRepo.save(notif1);
			
			break;
			
		case 2:
			Notification notif2 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_BUYER));
			
			messagingTemplate.convertAndSend("/topic/push/notif/2" , notif2);
			logger.info("Received notification: {}", notif2);
			notifRepo.save(notif2);
			
			break;
			
		case 3:
			Notification notif3 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_AGENT));
			messagingTemplate.convertAndSend("/topic/push/notif/3" , notif3);
			logger.info("Received notification: {}", notif3);
			notifRepo.save(notif3);
			
			break;
		
		case 4:
			Notification notif4 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_SELLER,RolesTypes.ROLE_AGENT));
			messagingTemplate.convertAndSend("/topic/push/notif/4" , notif4);
			logger.info("Received notification: {}", notif4);
			notifRepo.save(notif4);
			break;
			
		case 5:
			Notification notif5 = new Notification(title, message,
			        Arrays.asList(RolesTypes.ROLE_SELLER,RolesTypes.ROLE_ADMIN));
			messagingTemplate.convertAndSend("/topic/push/notif/5" , notif5);
			logger.info("Received notification: {}", notif5);
			notifRepo.save(notif5);
			break;
		}
		
		
		
		
	}
	
	
	// Notification par MAIL
	public void sendSimpleEmail(String toEmail , String subject,String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("emnah39@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
		System.out.println("Mail Sent...");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
