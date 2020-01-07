package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SmsSkuBoundsEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品sku积分设置
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 20:00:41
 */
public interface SmsSkuBoundsService extends IService<SmsSkuBoundsEntity> {

    PageVo queryPage(QueryCondition params);
}

