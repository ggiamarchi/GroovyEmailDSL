package com.zenika.email

/**
 * Definition of an email sender
 */
interface EmailSender {
    def setFrom(String from)
	def addTo(String recipient)
	def addCc(String recipient)
	def addBcc(String recipient)
	def setSubject(String subject)
	def setBody(String body)
	def addAttach(String file)
	def log()
	def send()
}
