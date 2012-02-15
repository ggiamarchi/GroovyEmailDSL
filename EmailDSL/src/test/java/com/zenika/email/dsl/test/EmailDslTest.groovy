package com.zenika.email.dsl.test

import groovy.util.GroovyTestCase

import com.zenika.email.EmailSenderProvider
import com.zenika.email.dsl.Email

class EmailDslTest extends GroovyTestCase {

	/**
	 * Test DSL only (stub mode)
	 */
	void testEmailDslOnly() {
		EmailSenderProvider.setStub(true) // Stub mode enabled. Will not send an email.
		Email.send {
			from "foo.bar@free.fr"
			to "guillaume.giamarchi@gmail.com"
			to "guillaume.giamarchi@free.fr"
			subject "Ouaiiis !!! Un mail envoyé via un DSL en Groovy"
			body "Pas grand chose à dire..."
			attach "file:/E:/file1.txt"
			attach "file:/E:/file2.txt"
		}
	}

	void testEmailDslOnlyWithOptionalBlock() {
		EmailSenderProvider.setStub(true) // Stub mode enabled. Will not send an email.
		Email.send {
			optional(
				html:false,
				important:false,
				headers:[
					"Reply-To":"bar.foo@free.fr"	
				]
			)
			from "foo.bar@free.fr"
			to "guillaume.giamarchi@gmail.com"
			to "guillaume.giamarchi@free.fr"
			subject "Ouaiiis !!! Un mail envoyé via un DSL en Groovy"
			body "Pas grand chose à dire..."
		}
	}
	
	/**
	 * Test DSL + email sending
	 */
	void testSendEmail() {
		EmailSenderProvider.setStub(false) // Stub mode disabled. An email will be send.
		Email.send {
			from "foo.bar@free.fr"
			to "guillaume.giamarchi@gmail.com"
			to "guillaume.giamarchi@free.fr"
			subject "Ouaiiis !!! Un mail envoyé via un DSL en Groovy"
			body "Pas grand chose à dire..."
			attach "file:/E:/file1.txt"
			attach "file:/E:/file2.txt"
		}
	}
	
	/**
	* Test DSL + email sending
	*/
	void testSendEmailWithOptionalBlock() {
		EmailSenderProvider.setStub(false) // Stub mode disabled. An email will be send.
		Email.send {
			optional(
				html:true,
				important:true,
				headers:[
					"Reply-To":"bar.foo@free.fr"
				]
			)
			from "foo.bar@free.fr"
			to "guillaume.giamarchi@gmail.com"
			to "guillaume.giamarchi@free.fr"
			subject "Ouaiiis !!! Un mail envoyé via un DSL en Groovy"
			body "<h1>Pas grand chose à dire...</h1>"
			attach "file:/E:/file1.txt"
			attach "file:/E:/file2.txt"
		}
	}

}
