package club.geek66.example.framework.flowable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
	@SpringBootApplication
	class FlowableApplication
	runApplication<FlowableApplication>(*args)
}