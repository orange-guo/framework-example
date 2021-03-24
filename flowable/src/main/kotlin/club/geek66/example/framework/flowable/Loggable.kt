package club.geek66.example.framework.flowable

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 * @author: orange
 * @date: 2021/3/24
 * @time: 下午3:22
 * @copyright: Copyright 2021 by orange
 */
interface Loggable {

	val logger: Logger
		get() = LoggerFactory.getLogger(this::class.java)

}