package hospital.HospitalWebApp2.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${email.from-address}")
    private String fromEmail;
    
    public void sendAppointmentDeniedEmail(String toEmail, String patientName, String doctorName) {
        String subject = "Good Morning Sir";
        String body = "Sir, mee teaching style chala clear ga untundi. Concepts easy ga ardham avutunnayi. Mee explanation valla subject meeda interest kuda perigindi. Mee patience tho explain cheyyadam chala inspiring ga untundi. Thank you so much, Sir.";
                     
        System.out.println(fromEmail);
        System.out.println(toEmail);
        System.out.println(patientName);
        System.out.println(doctorName);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom(fromEmail);

        mailSender.send(message);
    }
}

