package com.qiumu.novel.core.auth;

import com.qiumu.novel.core.common.exception.BusinessException;
import com.qiumu.novel.core.util.JwtUtils;
import com.qiumu.novel.manager.cache.UserInfoCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 前台门户系统 认证授权策略
 *
 * @author qiumu
 * @date 2023/8/14
 */
@Component
@RequiredArgsConstructor
public class FrontAuthStrategy implements AuthStrategy {

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;

    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // 统一账号认证
        authSSO(jwtUtils, userInfoCacheManager, token);
    }

}