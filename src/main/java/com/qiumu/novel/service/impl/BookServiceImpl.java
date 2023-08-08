package com.qiumu.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiumu.novel.dao.entity.BookCategory;
import com.qiumu.novel.dao.mapper.BookCategoryMapper;
import com.qiumu.novel.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小说模块 服务实现类
 *
 * @author qiumu
 * @date 2023/8/8
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public List<BookCategory> selectBookCategory() {
        QueryWrapper<BookCategory> queryWrapper = new QueryWrapper<>();
        return bookCategoryMapper.selectList(queryWrapper);
    }
}
