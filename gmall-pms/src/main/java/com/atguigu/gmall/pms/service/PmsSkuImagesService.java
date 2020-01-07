package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsSkuImagesEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * sku图片
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:48:33
 */
public interface PmsSkuImagesService extends IService<PmsSkuImagesEntity> {

    PageVo queryPage(QueryCondition params);
}

