package br.com.sast.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.EmailAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.sast.model.Email;

@RestController
@RequestMapping("api")
public class DocumentoController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	@PostMapping("/documentos")
	public ResponseEntity<?> enviaEmail(@ModelAttribute Email email) throws MessagingException, IOException{
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		
		helper.setFrom(email.getRemetente());
		helper.setTo(email.getDestinatarios().toArray(new String[email.getDestinatarios().size()]));
		helper.setSubject(email.getAssunto());
		helper.setText(email.getCorpo()); 
		
		for(MultipartFile anexo : email.getAnexo()) {
			
			helper.addAttachment(anexo.getOriginalFilename(), anexo);
		}
		
		javaMailSender.send(message);

		return ResponseEntity.ok("E-mail enviado com sucesso!");

	}
	
}
