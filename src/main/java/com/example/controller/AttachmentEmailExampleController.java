package com.example.controller;

import java.io.File;
import java.nio.file.spi.FileSystemProvider;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.MyConstants;

@Controller
public class AttachmentEmailExampleController {

	@Autowired
	public JavaMailSender emailSender;
	
	@ResponseBody
	@RequestMapping("/sendAttachmentEmail")
	public String sendAttachmentEmail() throws MessagingException{
		MimeMessage message = emailSender.createMimeMessage();
		boolean multipart = true;
		MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
		
		helper.setTo(MyConstants.FRIEND_EMAIL);
		helper.setSubject("Test email with attachments");
		
		helper.setText("Hello, Im tessting with attachment ");
		
		String path1 = "C:\\Users\\Minh\\Downloads\\file1.txt";
        String path2 = "C:\\Users\\Minh\\Downloads\\file2.txt";
        
        //attachment1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);
        //attachment2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("Readme", file2);
        
        emailSender.send(message);
        return "Email sent";
	}
}
