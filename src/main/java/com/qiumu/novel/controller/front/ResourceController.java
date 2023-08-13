package com.qiumu.novel.controller.front;

import com.qiumu.novel.core.common.resp.RestResp;
import com.qiumu.novel.core.constant.ApiRouterConsts;
import com.qiumu.novel.dto.resp.ImgVerifyCodeRespDto;
import com.qiumu.novel.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 前台门户-资源(图片/视频/文档)模块 API 控制器
 *
 * @author qiumu
 * @date 2023/8/13
 */
@Tag(name = "ResourceController", description = "前台门户-资源模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_RESOURCE_URL_PREFIX)
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    /**
     * 获取图片验证码接口
     */
    @Operation(summary = "获取图片验证码接口")
    @GetMapping("img_verify_code")
    public RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException {
        return resourceService.getImgVerifyCode();
    }

    /**
     * 图片上传接口
     */
    @Operation(summary = "图片上传接口")
    @PostMapping("/image")
    RestResp<String> uploadImage(
        @Parameter(description = "上传文件") @RequestParam("file") MultipartFile file) {
        return resourceService.uploadImage(file);
    }

}
