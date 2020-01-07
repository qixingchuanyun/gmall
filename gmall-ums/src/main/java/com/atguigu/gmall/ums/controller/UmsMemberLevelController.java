package com.atguigu.gmall.ums.controller;

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

import com.atguigu.gmall.ums.entity.UmsMemberLevelEntity;
import com.atguigu.gmall.ums.service.UmsMemberLevelService;




/**
 * 会员等级
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 20:02:47
 */
@Api(tags = "会员等级 管理")
@RestController
@RequestMapping("ums/umsmemberlevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService umsMemberLevelService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ums:umsmemberlevel:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = umsMemberLevelService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('ums:umsmemberlevel:info')")
    public Resp<UmsMemberLevelEntity> info(@PathVariable("id") Long id){
		UmsMemberLevelEntity umsMemberLevel = umsMemberLevelService.getById(id);

        return Resp.ok(umsMemberLevel);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ums:umsmemberlevel:save')")
    public Resp<Object> save(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.save(umsMemberLevel);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ums:umsmemberlevel:update')")
    public Resp<Object> update(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.updateById(umsMemberLevel);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ums:umsmemberlevel:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		umsMemberLevelService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
