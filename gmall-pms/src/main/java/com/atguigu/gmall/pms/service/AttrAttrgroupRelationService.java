package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;


/**
 * 属性&属性分组关联
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-09 15:14:52
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageVo queryPage(QueryCondition params);

    void delete(List<AttrAttrgroupRelationEntity> relationEntities);
}

