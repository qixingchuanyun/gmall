package com.atguigu.gmall.pms.dao;

import com.atguigu.gmall.pms.entity.PmsCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:48:33
 */
@Mapper
public interface PmsCategoryDao extends BaseMapper<PmsCategoryEntity> {
	
}
