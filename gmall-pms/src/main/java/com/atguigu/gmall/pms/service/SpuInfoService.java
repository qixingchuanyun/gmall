package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.SpuInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * spu信息
 *
 * @author xuetao
 * @email 584275986@qq.com
 * @date 2020-01-09 15:14:52
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo querySpuInfo(QueryCondition condition, Long catId);

    void saveSpuInfoVO(SpuInfoVO spuInfoVO);
}

