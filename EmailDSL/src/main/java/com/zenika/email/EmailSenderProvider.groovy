package com.zenika.email

import com.zenika.email.EmailSender
import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Provides a {@link EmailSender} implementation from the Spring context
 */
class EmailSenderProvider {
	
	private static final String SPRING_CONTEXT_XML_FILE = "com/zenika/email/beans.xml"
	private static final BeanFactory ctx = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML_FILE)
	private static boolean stub = false

	/**
	 * Whether the stub mode is enabled or disabled
	 * @param stub
	 */
	def static setStub(boolean stub) {
		this.stub = stub
	}

	/**
	 * Get a new instance of type {@link EmailSender}
	 * @return
	 */
	static EmailSender getSender() {
		if (stub) {
			ctx.getBean("emailSenderStub")
		}
		else {
			ctx.getBean("emailSender")
		}
	}

}
