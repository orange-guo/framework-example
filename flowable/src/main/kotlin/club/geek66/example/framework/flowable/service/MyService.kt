package club.geek66.example.framework.flowable.service

import org.flowable.engine.RuntimeService
import org.flowable.engine.TaskService
import org.flowable.task.api.Task
import org.springframework.stereotype.Service
import javax.transaction.Transactional


/**
 *
 * @author: orange
 * @date: 2021/3/25
 * @time: 上午11:20
 * @copyright: Copyright 2021 by orange
 */
@Service
class MyService(
	private val runtimeService: RuntimeService,
	private val taskService: TaskService
) {

	@Transactional
	fun startProcess(processName: String) {
		runtimeService.startProcessInstanceByKey(processName)
	}

	@Transactional
	fun getTasks(assignee: String): List<Task> {
		return taskService.createTaskQuery().taskAssignee(assignee).list()
	}

}