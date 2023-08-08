package com.qiumu.novel.service;


import com.qiumu.novel.dao.entity.BookCategory;

import java.util.List;

/**
 * 小说模块 服务类
 *
 * @author qiumu
 * @date 2023/8/8
 */
public interface BookService {
    List<BookCategory> selectBookCategory();

}
