package com.songspy.storage.db.core.configuration

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EntityScan("com.songspy")
@EnableJpaRepositories("com.songspy")
@Configuration
class CoreJpaConfiguration
