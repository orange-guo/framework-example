package club.geek66.example.framework.flowable

import club.geek66.example.framework.flowable.controller.MyController
import org.flowable.engine.HistoryService
import org.flowable.engine.RepositoryService
import org.flowable.engine.RuntimeService
import org.flowable.engine.TaskService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ProjectRequestTests {

	@Autowired
	lateinit var runtimeService: RuntimeService

	@Autowired
	lateinit var taskService: TaskService

	@Autowired
	lateinit var historyService: HistoryService

	@Autowired
	lateinit var repositoryService: RepositoryService

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	fun test() {
		mockMvc.perform(
			post("/user").param("name", "zhang")
		).andExpect(status().isOk)
			.andExpect(handler().handlerType(MyController::class.java))
			.andExpect(handler().methodName("create"))
	}

}