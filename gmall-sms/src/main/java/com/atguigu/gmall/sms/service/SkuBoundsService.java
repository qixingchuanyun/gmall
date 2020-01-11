package com.atguigu.gmall.sms.service;

import com.atguigu.gmall.sms.vo.SkuSaleDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SkuBoundsEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品sku积分设置
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-09 15:18:57
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageVo queryPage(QueryCondition params);

    void saveSkuSaleInfo(SkuSaleDTO skuSaleDTO);
}

