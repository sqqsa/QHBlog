package com.qing.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.management.LockInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagListDto {

    private Long id;
    //标签名
    private String name;

    //备注
    private String remark;
}
