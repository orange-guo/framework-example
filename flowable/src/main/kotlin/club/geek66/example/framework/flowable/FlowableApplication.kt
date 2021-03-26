package club.geek66.example.framework.flowable

import org.flowable.engine.RepositoryService
import org.flowable.engine.RuntimeService
import org.flowable.engine.TaskService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class FlowableApplication {

	/*@Bean
	fun init(
		repositoryService: RepositoryService,
		runtimeService: RuntimeService,
		taskService: TaskService
	): CommandLineRunner {
		return CommandLineRunner {
			println(
				"Number of process definitions : "
					+ repositoryService.createProcessDefinitionQuery().count()
			)
			System.out.println("Number of tasks : " + taskService.createTaskQuery().count())
			runtimeService.startProcessInstanceByKey("oneTaskProcess")
			System.out.println(
				("Number of tasks after process start: "
					+ taskService.createTaskQuery().count())
			)
		}
	}*/

}

fun main(args: Array<String>) {
	runApplication<FlowableApplication>(*args)
}