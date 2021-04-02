package club.geek66.example.framework.camunda

import org.camunda.bpm.engine.ProcessEngine
import org.camunda.bpm.engine.RuntimeService
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @author: orange
 * @date: 2021/4/2
 * @time: 上午11:14
 * @copyright: Copyright 2021 by orange
 */
@Configuration
class BeanConfiguration {

	@Bean
	fun runner(
		processEngine: ProcessEngine
	): ApplicationRunner = ApplicationRunner {
		// runtimeService.startProcessInstanceById("Process_1bc458v")
		processEngine
			.repositoryService
			.createProcessDefinitionQuery()
			.list().size.let { size ->
				println("definition size is $size")
			}
	}

}