package com.atguigu.gmall.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.pms.service.AttrGroupService;
import com.atguigu.gmall.pms.vo.AttrGroupVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gmall.pms.service.AttrAttrgroupRelationService;




/**
 * 属性&属性分组关联
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-09 15:14:52
 */
@Api(tags = "属性&属性分组关联 管理")
@RestController
@RequestMapping("pms/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:attrattrgrouprelation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attrAttrgroupRelationService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('pms:attrattrgrouprelation:info')")
    public Resp<AttrAttrgroupRelationEntity> info(@PathVariable("id") Long id){
		AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return Resp.ok(attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:attrattrgrouprelation:save')")
    public Resp<Object> save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:attrattrgrouprelation:update')")
    public Resp<Object> update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:attrattrgrouprelation:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }
    @ApiOperation("删除关联关系")
    @PostMapping("/delete/attr")
    public Resp<String> delete(@RequestBody List<AttrAttrgroupRelationEntity> relationEntities){

        this.attrAttrgroupRelationService.delete(relationEntities);

        return Resp.ok("删除成功");
    }
    @ApiOperation("根据三级分类id查询分组及组下的规格参数")
    @GetMapping("/withattrs/cat/{catId}")
    public Resp<List<AttrGroupVO>> queryByCid(@PathVariable("catId")Long cid){

        List<AttrGroupVO> attrGroupVOs = this.attrGroupService.queryByCid(cid);
        return Resp.ok(attrGroupVOs);
    }
}
