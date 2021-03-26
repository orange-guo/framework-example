package club.geek66.example.framework.flowable

import org.flowable.engine.HistoryService
import org.flowable.engine.RepositoryService
import org.flowable.engine.RuntimeService
import org.flowable.engine.TaskService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FlowableApplicationTests {

	@Autowired
	lateinit var runtimeService: RuntimeService

	@Autowired
	lateinit var taskService: TaskService

	@Autowired
	lateinit var historyService: HistoryService

	@Autowired
	lateinit var repositoryService: RepositoryService

	@Test
	fun testOneTaskProcess() {
		val processInstance = runtimeService.startProcessInstanceByKey("oneTaskProcess")
		taskService.createTaskQuery()
			.processInstanceId(processInstance.id)
			.list().let { processTasks ->
				Assertions.assertEquals(1, processTasks.count())
				// complete task
				processTasks.first().let { task ->
					Assertions.assertEquals(task.name, "my task")
					taskService.complete(task.id)
				}
			}
		taskService.createTaskQuery()
			.processInstanceId(processInstance.id)
			.list().let { processTasks ->
				Assertions.assertEquals(0, processTasks.count())
			}
	}

	@Test
	fun testHolidayRequestProcess() {
		val processInstance = runtimeService.startProcessInstanceByKey("holidayRequest")

		taskService.createTaskQuery()
			.processInstanceId(processInstance.id)
			.list()
			.first()
			.let { task ->
				Assertions.assertEquals("Approve or reject request", task.name)
				taskService.complete(task.id, mapOf("approved" to false))
			}

		historyService.createHistoricProcessInstanceQuery()
			.processInstanceId(processInstance.id)
			.singleResult()
			.let { instance ->
				Assertions.assertNotNull(instance.endTime)
			}
	}

}
