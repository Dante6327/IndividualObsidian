package com.dotcode.individualobsidian.common.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.dotcode.individualobsidian"])
class JpaConfig {
    // TODO: 추가 설정 필요 시 구현
}
