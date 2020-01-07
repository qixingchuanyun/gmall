package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.oms.entity.OmsOrderSettingEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 订单配置信息
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:58:21
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageVo queryPage(QueryCondition params);
}

