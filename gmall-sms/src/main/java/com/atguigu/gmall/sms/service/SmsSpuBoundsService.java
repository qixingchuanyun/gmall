package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SmsSpuBoundsEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品spu积分设置
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 20:00:41
 */
public interface SmsSpuBoundsService extends IService<SmsSpuBoundsEntity> {

    PageVo queryPage(QueryCondition params);
}

