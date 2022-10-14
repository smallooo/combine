package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 汇付图片上传的回调结果
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HfPhotoUploadResult {
    private Data data;

    public class Data {
        private String resp_desc;
        private String file_id;
        private String resp_code;
    }
}

