package com.zenika.email.dsl;

import com.zenika.email.EmailSender
import com.zenika.email.EmailSenderProvider

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Email {

	private EmailSender sender = EmailSenderProvider.getSender()

    def static send(Closure closure) {
		Email email = new Email()
		closure.delegate = email
		closure.call()
		email.send()
    }

    def from(String from) {
		sender.setFrom(from)
	}
	
	def to(String recipient) {
		sender.addTo(recipient)
	}
	
	def cc(String recipient) {
		sender.addCc(recipient)
	}
	
	def bcc(String recipient) {
		sender.addBcc(recipient)
	}
	
	def subject(String subject) {
		sender.setSubject(subject)
	}
	
	def body(String body) {
		sender.setBody(body)
	}
	
	def attach(String uri) {
		sender.addAttach(uri)
	}
	
	def log() {
		sender.log()
	}
	
	def send() {
		sender.send()
	}

}
