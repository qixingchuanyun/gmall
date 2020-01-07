package com.atguigu.gmall.pms.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.pms.entity.PmsSpuCommentEntity;
import com.atguigu.gmall.pms.service.PmsSpuCommentService;




/**
 * 商品评价
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:48:33
 */
@Api(tags = "商品评价 管理")
@RestController
@RequestMapping("pms/pmsspucomment")
public class PmsSpuCommentController {
    @Autowired
    private PmsSpuCommentService pmsSpuCommentService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:pmsspucomment:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = pmsSpuCommentService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('pms:pmsspucomment:info')")
    public Resp<PmsSpuCommentEntity> info(@PathVariable("id") Long id){
		PmsSpuCommentEntity pmsSpuComment = pmsSpuCommentService.getById(id);

        return Resp.ok(pmsSpuComment);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:pmsspucomment:save')")
    public Resp<Object> save(@RequestBody PmsSpuCommentEntity pmsSpuComment){
		pmsSpuCommentService.save(pmsSpuComment);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:pmsspucomment:update')")
    public Resp<Object> update(@RequestBody PmsSpuCommentEntity pmsSpuComment){
		pmsSpuCommentService.updateById(pmsSpuComment);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:pmsspucomment:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		pmsSpuCommentService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
