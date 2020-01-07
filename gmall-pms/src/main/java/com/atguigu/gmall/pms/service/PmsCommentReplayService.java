package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsCommentReplayEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品评价回复关系
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-07 19:48:33
 */
public interface PmsCommentReplayService extends IService<PmsCommentReplayEntity> {

    PageVo queryPage(QueryCondition params);
}

