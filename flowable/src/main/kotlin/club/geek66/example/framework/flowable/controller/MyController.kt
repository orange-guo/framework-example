package club.geek66.example.framework.flowable.controller

import club.geek66.example.framework.flowable.service.MyService
import org.springframework.web.bind.annotation.*

/**
 * @author: orange
 * @date: 2021/3/25
 * @time: 上午11:21
 * @copyright: Copyright 2021 by orange
 */
@RestController
@RequestMapping("/api/v1/processes")
class MyController(private val myService: MyService) {

	@PostMapping
	fun newProcess(name: String) {
		myService.startProcess(name)
	}

	@GetMapping("/{id}/tasks")
	fun listTask(@PathVariable id: String, @RequestParam assignee: String): List<TaskRepresentation> =
		myService.getTasks(assignee)
			.map { task ->
				TaskRepresentation(task.id, task.name)
			}

	class TaskRepresentation(val id: String, val name: String)

}