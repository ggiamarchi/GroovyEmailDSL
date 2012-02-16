package com.zenika.email.dsl.test

import groovy.util.GroovyTestCase

import com.zenika.email.EmailSenderProvider
import com.zenika.email.dsl.Email

class EmailDslTest extends GroovyTestCase {

	/**
	 * Test DSL + email sending
	 */
	void testSendEmail() {
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
