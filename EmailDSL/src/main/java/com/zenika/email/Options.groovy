package com.zenika.email

import groovy.transform.ToString;

@ToString(includeNames=true)
class Options {

	boolean html = false
	boolean important = false
	def headers = [:]
	
}
