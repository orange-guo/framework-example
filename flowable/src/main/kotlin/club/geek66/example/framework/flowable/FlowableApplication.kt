package club.geek66.example.framework.flowable

import org.flowable.engine.RepositoryService
import org.flowable.engine.RuntimeService
import org.flowable.engine.TaskService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class FlowableApplication

fun main(args: Array<String>) {
	runApplication<FlowableApplication>(*args)
}