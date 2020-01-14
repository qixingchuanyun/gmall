package com.atguigu.gmall.pms.feign;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.pms.dto.SkuSaleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * **************************************************************
 *
 * @描述 :
 * @作者 :	薛涛
 * @版本 :	v1.0
 * @日期 :	2020/1/13 16:39
 * @修改日志 :
 * @修改人 :
 * @修订后版本 :	v2.0
 * @修改时间 : ***************************************************************
 */

@FeignClient
public interface SkuSaleFeign {

    @PostMapping("/sms/skubounds/skusale/save")
    Resp<Object> saveSkuSaleInfo(@RequestBody SkuSaleDTO skuSaleDTO);
}
