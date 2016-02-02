package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import spock.lang.Specification
import spock.lang.Unroll;

class HelloSpec extends Specification {

	@Unroll
	def "handler returns 'Hello' string containing #firstName and #lastName"() {
		given:
		def service = new Hello()
		def context = [getLogger: { [log: {println it}] as LambdaLogger }] as Context
		expect: 
		service.myHandler([firstName: firstName, lastName: lastName], context) == "Hello $firstName $lastName"
		where:
		firstName | lastName
		'yo'      | 'dude'
		'meh'     | 'ma'
	}

}