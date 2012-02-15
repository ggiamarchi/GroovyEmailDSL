package com.zenika.email.impl

import com.zenika.email.Options;
import com.zenika.email.EmailSender

/**
 * Stub for DSL Testing only
 */
class EmailSenderStub implements EmailSender {

	def setFrom(String from) {
		println "EmailSenderStub.setFrom     : ${from}"
	}

	def addTo(String recipient) {
		println "EmailSenderStub.addTo       : ${recipient}"
	}

	def addCc(String recipient) {
		println "EmailSenderStub.addCc       : ${recipient}"
	}

	def addBcc(String recipient) {
		println "EmailSenderStub.addBcc      : ${recipient}"
	}

	def setSubject(String subject) {
		println "EmailSenderStub.setSubject  : ${subject}"
	}

	def setBody(String body) {
		println "EmailSenderStub.setBody     : ${body}"
	}

	def addAttach(String file) {
		println "EmailSenderStub.addAttach   : ${file}"
	}

	def setOptions(Options options) {
		println "EmailSenderStub.setOptions  : ${options}"
	}
	
	def send() {
		println "EmailSenderStub.send"
	}

}
