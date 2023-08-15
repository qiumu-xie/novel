package com.qiumu.novel.service;


import com.qiumu.novel.core.common.resp.PageRespDto;
import com.qiumu.novel.core.common.resp.RestResp;
import com.qiumu.novel.dto.req.BookSearchReqDto;
import com.qiumu.novel.dto.resp.BookInfoRespDto;

/**
 * 搜索 服务类
 *
 * @author qiumu
 * @date 2023/8/15
 */
public interface SearchService {

    /**
     * 小说搜索
     *
     * @param condition 搜索条件
     * @return 搜索结果
     */
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);

}
