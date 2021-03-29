package club.geek66.example.framework.flowable

import org.junit.jupiter.api.Test

/**
 *
 * @author: orange
 * @date: 2021/3/29
 * @time: 下午5:38
 * @copyright: Copyright 2021 by orange
 */
class ProjectRequestTests : H2BasedProcessEngine() {

	@Test
	fun test() {
		val deployment =
			repositoryService
				.createDeployment()
				.addClasspathResource("processes/project-request.bpmn20.xml")
				.deploy()

		val processInstance = runtimeService.startProcessInstanceByKey("projectRequest")
	}

}