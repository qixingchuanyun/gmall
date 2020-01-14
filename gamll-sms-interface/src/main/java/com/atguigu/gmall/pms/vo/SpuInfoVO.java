package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import lombok.Data;

import java.util.List;

/**
 * **************************************************************
 *
 * @描述 :
 * @作者 :	薛涛
 * @版本 :	v1.0
 * @日期 :	2020/1/11 8:44
 * @修改日志 :
 * @修改人 :
 * @修订后版本 :	v2.0
 * @修改时间 : ***************************************************************
 */
@Data
public class SpuInfoVO extends SpuInfoEntity {

    /** 图片信息*/
    private List<String> spuImages;

    /** 基本属性信息*/
    private List<ProductAttrValueVO> baseAttrs;

     /**  sku信息*/
    private List<SkuInfoVO> skus;
}
