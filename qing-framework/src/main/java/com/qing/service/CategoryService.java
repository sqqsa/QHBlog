package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.Category;
import com.qing.entity.ResponseResult;
import com.qing.vo.CategoryVo;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-07-26 12:13:55
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

    List<CategoryVo> listAllCategory();
}
