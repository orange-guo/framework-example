/*
package club.geek66.example.framework.flowable

import org.flowable.engine.*
import org.flowable.spring.ProcessEngineFactoryBean
import org.flowable.spring.SpringProcessEngineConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

*/
/**
 *
 * @author: orange
 * @date: 2021/3/25
 * @time: 上午10:24
 * @copyright: Copyright 2021 by orange
 *//*

@Configuration
class FlowableConfiguration {

	@Bean
	fun processEngineConfiguration(
		dataSource: DataSource,
		transactionManager: PlatformTransactionManager
	): SpringProcessEngineConfiguration = SpringProcessEngineConfiguration().apply {
		this.dataSource = dataSource
		this.transactionManager = transactionManager
		this.databaseSchemaUpdate = "${true}"
		this.isAsyncExecutorActivate = false
	}

	@Bean
	fun processEngine(
		configuration: SpringProcessEngineConfiguration
	): ProcessEngineFactoryBean =
		ProcessEngineFactoryBean().apply {
			processEngineConfiguration = configuration
		}

	@Bean
	fun repositoryService(processEngine: ProcessEngine): RepositoryService = processEngine.repositoryService

	@Bean
	fun runtimeService(processEngine: ProcessEngine): RuntimeService = processEngine.runtimeService

	@Bean
	fun taskService(processEngine: ProcessEngine): TaskService = processEngine.taskService

	@Bean
	fun historyService(processEngine: ProcessEngine): HistoryService = processEngine.historyService

	@Bean
	fun managementService(processEngine: ProcessEngine): ManagementService = processEngine.managementService

}*/
