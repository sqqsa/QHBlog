package com.qing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qing.entity.Tag;

import java.util.Date;

/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-07 17:22:27
 */
public interface TagMapper extends BaseMapper<Tag> {

    void updateTagFlag(Long id, Integer delFlag, Date updateTime);
}

