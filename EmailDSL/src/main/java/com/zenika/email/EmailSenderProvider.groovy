package com.zenika.email;

import com.zenika.email.EmailSender
import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

class EmailSenderProvider {
	
	private static final String SPRING_CONTEXT_XML_FILE = "com/zenika/email/beans.xml"
	private static final BeanFactory ctx = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML_FILE)
	private static boolean stub = false

	def static synchronized setStub(boolean stub) {
		this.stub = stub
	}
	
	static EmailSender getSender() {
		if (stub) {
			ctx.getBean("emailSenderStub")
		}
		else {
			ctx.getBean("emailSender")
		}
	}

}
