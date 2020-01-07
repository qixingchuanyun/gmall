package com.atguigu.gmall.oms.dao;

import com.atguigu.gmall.oms.entity.OmsOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:58:21
 */
@Mapper
public interface OmsOrderDao extends BaseMapper<OmsOrderEntity> {
	
}
