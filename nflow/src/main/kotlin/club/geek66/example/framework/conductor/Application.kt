package club.geek66.example.framework.conductor

import io.nflow.engine.config.EngineConfiguration
import io.nflow.rest.config.RestConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import


/**
 *
 * @author: orange
 * @date: 2021/3/23
 * @time: 上午10:17
 * @copyright: Copyright 2021 by orange
 */
fun main() {
	@SpringBootApplication
	@Import(RestConfiguration::class)
	class Application
	SpringApplication.run(Application::class.java)
}