package com.zenika.email.impl

import groovy.transform.ToString;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper

import com.zenika.email.Options;
import com.zenika.email.EmailSender

/**
 * Implementation using the Spring email API
 */
@ToString(
	includeNames=true,
	includeFields=true,
	excludes="sender, message, logEmailConsole"
)
class EmailSenderImpl implements EmailSender {

	private String from
	private def to = []
	private def cc = []
	private def bcc = []
	private String subject
	private String body
	private def attachedFile = []

	private JavaMailSender sender
	private MimeMessageHelper message
	
	private Options options
	
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
	
	def setFrom(String from) {
		this.from = from
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
		this.subject = subject
	}

	def setBody(String body) {
		this.body = body
	}

	def addAttach(String file) {
		attachedFile << file
	}

	def setOptions(Options options) {
		this.options = options
	}

	def send() {
		options?.headers.each {
			name, value -> message.mimeMessage.setHeader(name, value)
		}
		message.setText(body, options?.html ? options.html : false)
		if (options?.important) {
			message.setPriority(1)
		}
		message.setFrom(from)
		message.setSubject(subject)
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
	
	private void log() {
		println "from     : ${from}"
		println "to       : ${to}"
		println "cc       : ${cc}"
		println "bcc      : ${bcc}"
		println "subject  : ${subject}"
		println "body     : ${body}"
		println "attached : ${attachedFile}"
		println "optional : ${options}"
	}

}
