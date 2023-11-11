package com.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.constants.SystemConstants;
import com.qing.dto.TagListDto;
import com.qing.entity.Comment;
import com.qing.entity.LoginUser;
import com.qing.entity.ResponseResult;
import com.qing.enums.AppHttpCodeEnum;
import com.qing.exception.SystemException;
import com.qing.utils.BeanCopyUtils;
import com.qing.utils.SecurityUtils;
import com.qing.vo.PageVo;
import com.qing.vo.TagVo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import com.qing.entity.Tag;
import com.qing.mapper.TagMapper;
import com.qing.service.TagService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-08-07 17:22:29
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Resource
    private TagService tagService;

    //标签分页展示
    @Override
    public ResponseResult<PageVo> tagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {

        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        queryWrapper.eq(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());
        queryWrapper.eq(Tag::getDelFlag,0);

        //分页查询
        Page<Tag> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);


        //封装
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());

        return ResponseResult.okResult(pageVo);
    }

    //添加标签
    @Override
    public ResponseResult saveTag(Tag tag) {

        //判断标签名称是否为空
        if (!StringUtils.hasText(tag.getName())){
            throw new SystemException(AppHttpCodeEnum.TAGNAME_NOT_NULL);
        }
        //判断标签是否已经存在
        if (tagNameExist(tag.getName())){
            throw new SystemException(AppHttpCodeEnum.TAGNAME_EXIST);
        }
        //添加数据
        tagMapper.insert(tag);
        return ResponseResult.okResult();
    }

    //删除标签
    @Override
    public ResponseResult deleteTag(Long id) {

        LambdaUpdateWrapper<Tag> queryWrapper = new LambdaUpdateWrapper<>();

        queryWrapper.eq(Tag::getId,id);
        queryWrapper.set(Tag::getDelFlag,1);

        update(queryWrapper);

//        tagMapper.updateTagFlag(id,tag.getDelFlag(),tag.getUpdateTime());
        return ResponseResult.okResult();
    }

    //修改标签
    @Override
    public ResponseResult updateTag(TagListDto tagDto) {
//        LambdaUpdateWrapper<Tag> queryWrapper = new LambdaUpdateWrapper<>();
//        queryWrapper.eq(Tag::getId,tag.getId());
//        queryWrapper.set(Tag::getName,tag.getName());
//        queryWrapper.set(Tag::getRemark,tag.getRemark());
//        update(queryWrapper);
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setName(tagDto.getName());
        tag.setRemark(tagDto.getRemark());
        tagMapper.updateById(tag);
        return ResponseResult.okResult();
    }

    //根据id查询标签
    @Override
    public ResponseResult selectTagById(Long id) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getId,id);
        Tag tag = tagMapper.selectOne(queryWrapper);
        TagListDto tagListDto = BeanCopyUtils.copyBean(tag, TagListDto.class);
        return ResponseResult.okResult(tagListDto);
    }

    //查询所有标签
    @Override
    public List<TagVo> listAllTag() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId,Tag::getName);
        List<Tag> tagList = tagMapper.selectList(queryWrapper);
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(tagList, TagVo.class);
        return tagVos;
    }

    //标签名是否已经存在
    private boolean tagNameExist(String name) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getName,name);

        Integer count = tagMapper.selectCount(queryWrapper);
        return count > 0;
    }
}
