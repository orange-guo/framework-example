package club.geek66.example.framework.flowable

import club.geek66.example.framework.flowable.common.Loggable
import org.flowable.engine.ProcessEngine
import org.flowable.engine.ProcessEngineConfiguration
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration

/**
 *
 * @author: orange
 * @date: 2021/3/29
 * @time: 下午5:06
 * @copyright: Copyright 2021 by orange
 */
abstract class H2BasedProcessEngine(
	private val engine: ProcessEngine = StandaloneProcessEngineConfiguration()
		.setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
		.setJdbcUsername("sa")
		.setJdbcPassword("")
		.setJdbcDriver("org.h2.Driver")
		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
		.buildProcessEngine()
) : ProcessEngine by engine, Loggable
