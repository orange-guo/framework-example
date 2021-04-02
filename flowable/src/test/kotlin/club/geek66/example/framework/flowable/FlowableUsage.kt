package club.geek66.example.framework.flowable

import org.junit.jupiter.api.Assertions

/**
 *
 * @author: orange
 * @date: 2021/3/24
 * @time: 下午6:00
 * @copyright: Copyright 2021 by orange
 */
class FlowableUsage : H2BasedProcessEngine() {

	fun test() {
		// https://flowable.com/open-source/docs/bpmn/ch02-GettingStarted/
		val deployment =
			repositoryService
				.createDeployment()
				.addClasspathResource("processes/holiday-request.bpmn20.xml")
				.deploy()

		logger.info("{:deployment {:name ${deployment.name} :id ${deployment.id}}}")

		val definition = repositoryService.createProcessDefinitionQuery()
			.deploymentId(deployment.id)
			.singleResult()

		val instance = runtimeService
			.startProcessInstanceByKey(
				"holidayRequest",
				mapOf("employee" to "Jack", "nrOfHolidays" to 100, "description" to "请假")
			)

		taskService.createTaskQuery()
//			.deploymentId(deployment.id)
//			.processDefinitionId(definition.id)
			.processInstanceId(instance.id)
			.list().let { taskList ->
				Assertions.assertEquals(taskList.count(), 1)
				Assertions.assertEquals(taskList.first().name, "Approve or reject request")

				// approve the holidayRequest
				taskService.complete(taskList.first().id, mapOf("approved" to true))
			}
		taskService.createTaskQuery()
			.processInstanceId(instance.id)
			.list()
			.let { taskList ->
				Assertions.assertEquals(taskList.count(), 0)
			}

		// couldn't instantiate class org.flowable.CallExternalSystemDelegate why?
	}

}