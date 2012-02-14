package com.zenika.email.impl

import org.springframework.mail.MailException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper

import com.zenika.email.EmailSender

/**
 * Implementation using the Spring email API
 */
class EmailSenderImpl implements EmailSender {

	private def to = []
	private def cc = []
	private def bcc = []
	private def attachedFile = []

	private JavaMailSender sender
	private MimeMessageHelper message
	
	/**
	 * Whether the email will be logged on stdout or not before it will be send
	 */
	private boolean logEmailConsole = false

	def setSender(def sender) {
		this.sender = sender
	}
	
	def setMessage(def message) {
		this.message = message
	}
	
	def setLogEmailConsole(def logEmailConsole) {
		this.logEmailConsole = logEmailConsole
	}
	
	def send() {
		message.setTo(to as String[])		
		message.setBcc(bcc as String[])
		message.setCc(cc as String [])
		attachedFile.each {
			File file = new File(new URI(it))
			message.addAttachment(file.getName(), file)
		}
		if (logEmailConsole) {
			log()
		}
		try{
			sender.send(message.getMimeMessage())
		}
		catch(MailException ex) {
			throw new RuntimeException(ex)
		}
	}

	def setFrom(String from) {
		message.setFrom(from)
	}

	def addTo(String recipient) {
		to << recipient
	}

	def addCc(String recipient) {
		cc << recipient
	}

	def addBcc(String recipient) {
		bcc << recipient
	}

	def setSubject(String subject) {
		message.setSubject(subject)
	}

	def setBody(String body) {
		message.setText(body)
	}

	def addAttach(String file) {
		attachedFile << file
	}

	def log() {
		println "from     : ${message.mimeMessage.from}"
		println "to       : ${to}"
		println "cc       : ${cc}"
		println "bcc      : ${bcc}"
		println "subject  : ${message.mimeMessage.subject}"
		println "body     : ${message.mimeMultipart.getBodyPart(0).content}"
		println "attached : ${attachedFile}"
	}

}
