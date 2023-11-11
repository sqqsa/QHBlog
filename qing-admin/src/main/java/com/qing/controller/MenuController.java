package com.qing.controller;

import com.qing.dto.TagListDto;
import com.qing.entity.Menu;
import com.qing.entity.ResponseResult;
import com.qing.entity.Role;
import com.qing.service.MenuService;
import com.qing.vo.RoutersVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    //分页显示菜单
    @GetMapping("/list")
    public ResponseResult<RoutersVo> menuList(@RequestParam(defaultValue = "") String status,
                                              @RequestParam(defaultValue = "") String menuName){


//        List<Menu> menus = menuService.menuList(status, menuName);
        return menuService.menuList(status,menuName);
    }
    //添加菜单
    @PostMapping()
    public ResponseResult saveMenu(@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }

    @GetMapping("{id}")
    public ResponseResult selectMenuById(@PathVariable Long id){
        return menuService.selectMenuById(id);
    }

    //逻辑删除标签
    @DeleteMapping("/{id}")
    public ResponseResult deleteMenu(@PathVariable Long id){
        return menuService.deleteMenuById(id);
    }

    //修改标签
    @PutMapping()
    public ResponseResult updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }


    @GetMapping("/roleMenuTreeselect/{id}")
    public ResponseResult<RoutersVo> roleMenuTreeSelect(@PathVariable Long id){

        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(id);
        return ResponseResult.okResult(menus);
    }


}
