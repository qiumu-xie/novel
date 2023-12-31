package com.qiumu.novel.core.config;

import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * elasticsearch 相关配置
 *
 * @author qiumu
 * @date 2023/8/8
 */
@Configuration
@Slf4j
public class EsConfig {

    /**
     * 解决 ElasticsearchClientConfigurations 修改默认 ObjectMapper 配置的问题
     */
    @Bean
    JacksonJsonpMapper jacksonJsonpMapper() {
        return new JacksonJsonpMapper();
    }

}

