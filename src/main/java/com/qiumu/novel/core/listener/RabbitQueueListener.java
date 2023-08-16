package com.qiumu.novel.core.listener;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.qiumu.novel.core.constant.AmqpConsts;
import com.qiumu.novel.core.constant.EsConsts;
import com.qiumu.novel.dao.entity.BookInfo;
import com.qiumu.novel.dao.mapper.BookInfoMapper;
import com.qiumu.novel.dto.es.EsBookDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Rabbit 队列监听器
 *
 * @author qiumu
 * @date 2023/8/16
 */
@Component
@ConditionalOnProperty(prefix = "spring", name = {"elasticsearch.enabled",
    "amqp.enabled"}, havingValue = "true")
@RequiredArgsConstructor
@Slf4j
public class RabbitQueueListener {

    private final BookInfoMapper bookInfoMapper;

    private final ElasticsearchClient esClient;

    /**
     * 监听小说信息改变的 ES 更新队列，更新最新小说信息到 ES
     */
    @RabbitListener(queues = AmqpConsts.BookChangeMq.QUEUE_ES_UPDATE)
    @SneakyThrows
    public void updateEsBook(Long bookId) {
        BookInfo bookInfo = bookInfoMapper.selectById(bookId);
        IndexResponse response = esClient.index(i -> i
            .index(EsConsts.BookIndex.INDEX_NAME)
            .id(bookInfo.getId().toString())
            .document(EsBookDto.build(bookInfo))
        );
        log.info("Indexed with version " + response.version());
    }

}
