package club.geek66.example.framework.flowable.delegate

import org.flowable.engine.delegate.DelegateExecution
import org.flowable.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

/**
 *
 * @author: orange
 * @date: 2021/3/25
 * @time: 下午12:00
 * @copyright: Copyright 2021 by orange
 */
@Component
class SendRejectionMail : JavaDelegate {

	override fun execute(execution: DelegateExecution) {
		println("sending mail...")
	}

}