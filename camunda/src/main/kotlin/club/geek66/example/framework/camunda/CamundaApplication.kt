package club.geek66.example.framework.camunda

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.net.Inet4Address
import java.net.InetAddress
import java.net.Socket
import java.net.SocketAddress

/**
 *
 * @author: orange
 * @date: 2021/4/2
 * @time: 上午11:03
 * @copyright: Copyright 2021 by orange
 */
fun main(args: Array<String>) {
	@SpringBootApplication
	@EnableProcessApplication
	class CamundaApplication
	runApplication<CamundaApplication>(*args)
}