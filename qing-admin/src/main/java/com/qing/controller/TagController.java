package com.qing.controller;

import com.qing.dto.TagListDto;
import com.qing.entity.ResponseResult;
import com.qing.entity.Tag;
import com.qing.service.TagService;
import com.qing.vo.PageVo;
import com.qing.vo.TagVo;
import io.swagger.models.auth.In;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Resource
    private TagService tagService;

    //分页展示标签
    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.tagList(pageNum,pageSize,tagListDto);
    }
    //添加标签
    @PostMapping()
    public ResponseResult saveTag(@RequestBody Tag tag){
        return tagService.saveTag(tag);
    }

    //逻辑删除标签
    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable Long id){
        return tagService.deleteTag(id);
    }

    //根据id查询标签
    @GetMapping("/{id}")
    public ResponseResult selectTagById(@PathVariable Long id){
        return tagService.selectTagById(id);
    }
    //修改标签
    @PutMapping()
    public ResponseResult updateTag(@RequestBody TagListDto tagDto){
        return tagService.updateTag(tagDto);
    }

    //查询所有标签
    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> tagVoList = tagService.listAllTag();
        return ResponseResult.okResult(tagVoList);

    }
}
