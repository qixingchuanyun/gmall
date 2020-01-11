package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * **************************************************************
 *
 * @描述 :
 * @作者 :	薛涛
 * @版本 :	v1.0
 * @日期 :	2020/1/10 19:33
 * @修改日志 :
 * @修改人 :
 * @修订后版本 :	v2.0
 * @修改时间 : ***************************************************************
 */

@Data
public class AttrGroupVO extends AttrGroupEntity {
    private List<AttrEntity> attrEntities;

    private List<AttrAttrgroupRelationEntity> relations;
}
