package com.zenika.email.dsl

import com.zenika.email.EmailSender
import com.zenika.email.EmailSenderProvider

import groovy.transform.EqualsAndHashCode

/**
 * DSL Implementation
 */
@EqualsAndHashCode
class Email {

	/**
	 * Delegate responsible of sending emails
	 */
	private EmailSender sender = EmailSenderProvider.getSender()

	/**
	 * Unique entry point of this DSL
	 * @param closure
	 * @return
	 */
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
