package com.qiumu.novel;

import com.qiumu.novel.dao.entity.BookCategory;
import com.qiumu.novel.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@SpringBootTest
@Slf4j
@EnableCaching
class NovelApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void Test1() {
        System.out.println("第一次查询");
        List<BookCategory> bookCategories = bookService.selectBookCategory();
        System.out.println(bookCategories);

        System.out.println("第二次查询");
        List<BookCategory> bookCategories1 = bookService.selectBookCategory();
        System.out.println(bookCategories1);

        System.out.println("第三次查询");
        List<BookCategory> bookCategories2 = bookService.selectBookCategory();
        System.out.println(bookCategories2);
    }

}
