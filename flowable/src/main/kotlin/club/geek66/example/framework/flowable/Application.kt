package club.geek66.example.framework.flowable

import org.flowable.engine.ProcessEngine
import org.flowable.engine.ProcessEngineConfiguration
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration

/**
 *
 * @author: orange
 * @date: 2021/3/24
 * @time: 下午2:31
 * @copyright: Copyright 2021 by orange
 */

object Log : Loggable

// https://flowable.com/open-source/docs/bpmn/ch02-GettingStarted/
fun main() {

	val engineConfig: ProcessEngineConfiguration = StandaloneProcessEngineConfiguration()
		.setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
		.setJdbcUsername("sa")
		.setJdbcPassword("")
		.setJdbcDriver("org.h2.Driver")
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)

	val engine: ProcessEngine = engineConfig.buildProcessEngine()

	val repository = engine.repositoryService

	val deployment =
		repository
			.createDeployment()
			.addClasspathResource("holiday-request.bpmn20.xml")
			.deploy()

	Log.logger.info("{:deployment {:name ${deployment.name} :id ${deployment.id}}}")

	val definition = repository.createProcessDefinitionQuery()
		.deploymentId(deployment.id)
		.singleResult()

	val instance = engine.runtimeService.startProcessInstanceByKey(
		"holidayRequest", mapOf(
			"employee" to "Jack",
			"nrOfHolidays" to 100,
			"description" to "请假"
		)
	)

	engine
		.taskService
		.createTaskQuery()
		.taskCandidateGroup("managers")
		.list()
		.forEach { task ->
			println("task ${task.name}")
		}

}