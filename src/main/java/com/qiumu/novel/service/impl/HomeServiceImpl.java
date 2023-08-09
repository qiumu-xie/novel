package com.qiumu.novel.service.impl;

import com.qiumu.novel.core.common.resp.RestResp;
import com.qiumu.novel.dto.resp.HomeBookRespDto;
import com.qiumu.novel.dto.resp.HomeFriendLinkRespDto;
import com.qiumu.novel.manager.cache.FriendLinkCacheManager;
import com.qiumu.novel.manager.cache.HomeBookCacheManager;
import com.qiumu.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页模块 服务实现类
 *
 * @author qiumu
 * @date 2023/8/9
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    private final FriendLinkCacheManager friendLinkCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }

    @Override
    public RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks() {
        return RestResp.ok(friendLinkCacheManager.listFriendLinks());
    }
}
