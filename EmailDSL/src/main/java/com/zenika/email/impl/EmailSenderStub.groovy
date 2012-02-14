package com.zenika.email.impl

import com.zenika.email.EmailSender;

class EmailSenderStub implements EmailSender {

	def setFrom(String from) {
		println "EmailSenderStub.setFrom()"
	}

	def addTo(String recipient) {
		println "EmailSenderStub.addTo()"
	}

	def addCc(String recipient) {
		println "EmailSenderStub.addCc()"
	}

	def addBcc(String recipient) {
		println "EmailSenderStub.addBcc()"
	}

	def setSubject(String subject) {
		println "EmailSenderStub.setSubject()"
	}

	def setBody(String body) {
		println "EmailSenderStub.setBody()"
	}

	def addAttach(String file) {
		println "EmailSenderStub.addAttach()"
	}

	def log() {
		println "EmailSenderStub.log()"
	}

	def send() {
		println "EmailSenderStub.send()"
	}

}
