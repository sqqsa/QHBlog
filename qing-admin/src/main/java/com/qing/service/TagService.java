package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.dto.TagListDto;
import com.qing.entity.ResponseResult;
import com.qing.entity.Tag;
import com.qing.vo.PageVo;
import com.qing.vo.TagVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-08-07 17:22:29
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> tagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    ResponseResult saveTag(Tag tag);

    ResponseResult deleteTag(Long id);

    ResponseResult updateTag(TagListDto tagDto);

    ResponseResult selectTagById(Long id);

    List<TagVo> listAllTag();
}
