package com.qiumu.novel.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiumu.novel.core.constant.CacheConsts;
import com.qiumu.novel.core.constant.DatabaseConsts;
import com.qiumu.novel.dao.entity.HomeFriendLink;
import com.qiumu.novel.dao.mapper.HomeFriendLinkMapper;
import com.qiumu.novel.dto.resp.HomeFriendLinkRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 友情链接 缓存管理类
 *
 * @author qiumu
 * @date 2023/8/9
 */
@Component
@RequiredArgsConstructor
public class FriendLinkCacheManager {

    private final HomeFriendLinkMapper friendLinkMapper;

    /**
     * 友情链接列表查询，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER,
        value = CacheConsts.HOME_FRIEND_LINK_CACHE_NAME)
    public List<HomeFriendLinkRespDto> listFriendLinks() {
        // 从友情链接表中查询出友情链接列表
        QueryWrapper<HomeFriendLink> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(DatabaseConsts.CommonColumnEnum.SORT.getName());
        return friendLinkMapper.selectList(queryWrapper).stream().map(v -> {
            HomeFriendLinkRespDto respDto = new HomeFriendLinkRespDto();
            respDto.setLinkName(v.getLinkName());
            respDto.setLinkUrl(v.getLinkUrl());
            return respDto;
        }).toList();
    }

}
