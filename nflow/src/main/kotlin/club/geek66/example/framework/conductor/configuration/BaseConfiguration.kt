package club.geek66.example.framework.conductor.configuration

import club.geek66.example.framework.conductor.workflow.ExampleWorkflow
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @author: orange
 * @date: 2021/3/24
 * @time: 上午11:23
 * @copyright: Copyright 2021 by orange
 */
@Configuration
class BaseConfiguration {

	@Bean
	fun exampleWorkflow(): ExampleWorkflow = ExampleWorkflow()

}