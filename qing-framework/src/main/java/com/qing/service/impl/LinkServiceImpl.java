package com.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.constants.SystemConstants;
import com.qing.entity.ResponseResult;
import com.qing.utils.BeanCopyUtils;
import com.qing.vo.LinkVo;
import org.springframework.stereotype.Service;
import com.qing.entity.Link;
import com.qing.mapper.LinkMapper;
import com.qing.service.LinkService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-07-27 16:26:05
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Resource
    private LinkMapper linkMapper;
    @Override
    public ResponseResult getAllLink() {
        //查询条件
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        //判断状态为已审核
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);

        List<Link> linkList = linkMapper.selectList(queryWrapper);

        //封装成LinkVo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(linkList, LinkVo.class);

        return ResponseResult.okResult(linkVos);
    }
}
