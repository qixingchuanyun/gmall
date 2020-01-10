package com.atguigu.gmall.pms.controller;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.atguigu.core.bean.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * **************************************************************
 *
 * @描述 :
 * @作者 :	薛涛
 * @版本 :	v1.0
 * @日期 :	2020/1/9 16:38
 * @修改日志 :
 * @修改人 :
 * @修订后版本 :	v2.0
 * @修改时间 : ***************************************************************
 */
@RequestMapping("pms/oss")
@RestController
public class PmsOssController {

    /**
     * 请填写您的AccessKeyId。
     */
    @Value("${oss.accessId}")
    private String accessId;
    /**
     * 请填写您的AccessKeySecret。
     */
    @Value("${oss.accessKey}")
    private String accessKey;
    /**
     * 请填写您的 endpoint。
     */
    @Value("${oss.endpoint}")
    private String endpoint;
    /**
     * 请填写您的 bucketname 。
     */
    @Value("${oss.bucket}")
    private String bucket;

    /**
     * callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。   "http://88.88.88.88:8888";
     */
    @Value("${oss.callbackUrl}")
    private String callbackUrl;
    /**
     * 图片目录，每天一个目录
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 用户上传文件时指定的前缀。
     */
    String dir = sdf.format(new Date());

    @GetMapping("policy")
    public Resp<Object> policy() throws UnsupportedEncodingException {

        /**
         * host的格式为 bucketname.endpoint
         */
        String host = "https://" + bucket + "." + endpoint;
        OSSClient client = new OSSClient(endpoint, (new DefaultCredentialProvider(accessId, accessKey)), null);

        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = client.calculatePostSignature(postPolicy);

        Map<String, String> respMap = new LinkedHashMap<String, String>();
        respMap.put("accessid", accessId);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", host);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        // respMap.put("expire", formatISO8601Date(expiration));

        return Resp.ok(respMap);
    }

}
