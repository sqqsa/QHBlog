/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : q_blog

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-11-11 20:54:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2035 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '1', 'M', '0', '0', '', 'system', '0', '2021-11-12 10:46:19', '0', null, '系统管理目录', '0');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '1', 'C', '0', '0', 'system:user:list', 'user', '0', '2021-11-12 10:46:19', '1', '2022-07-31 15:47:58', '用户管理菜单', '0');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '1', 'C', '0', '0', 'system:role:list', 'peoples', '0', '2021-11-12 10:46:19', '0', null, '角色管理菜单', '0');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '1', 'C', '0', '0', 'system:menu:list', 'tree-table', '0', '2021-11-12 10:46:19', '0', null, '菜单管理菜单', '0');
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '1', 'F', '0', '0', 'system:user:query', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '1', 'F', '0', '0', 'system:user:add', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '1', 'F', '0', '0', 'system:user:edit', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '1', 'F', '0', '0', 'system:user:remove', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '1', 'F', '0', '0', 'system:user:export', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '1', 'F', '0', '0', 'system:user:import', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '1', 'F', '0', '0', 'system:user:resetPwd', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '1', 'F', '0', '0', 'system:role:query', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '1', 'F', '0', '0', 'system:role:add', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '1', 'F', '0', '0', 'system:role:edit', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '1', 'F', '0', '0', 'system:role:remove', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '1', 'F', '0', '0', 'system:role:export', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '1', 'F', '0', '0', 'system:menu:query', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '1', 'F', '0', '0', 'system:menu:add', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '1', 'F', '0', '0', 'system:menu:edit', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '1', 'F', '0', '0', 'system:menu:remove', '#', '0', '2021-11-12 10:46:19', '0', null, '', '0');
INSERT INTO `sys_menu` VALUES ('2017', '内容管理', '0', '4', 'content', null, '1', 'M', '0', '0', null, 'table', null, '2022-01-08 02:44:38', '1', '2022-07-31 12:34:23', '', '0');
INSERT INTO `sys_menu` VALUES ('2018', '分类管理', '2017', '1', 'category', 'content/category/index', '1', 'C', '0', '0', 'content:category:list', 'example', null, '2022-01-08 02:51:45', null, '2022-01-08 02:51:45', '', '0');
INSERT INTO `sys_menu` VALUES ('2019', '文章管理', '2017', '0', 'article', 'content/article/index', '1', 'C', '0', '0', 'content:article:list', 'build', null, '2022-01-08 02:53:10', null, '2022-01-08 02:53:10', '', '0');
INSERT INTO `sys_menu` VALUES ('2021', '标签管理', '2017', '6', 'tag', 'content/tag/index', '1', 'C', '0', '0', 'content:tag:index', 'button', null, '2022-01-08 02:55:37', null, '2022-01-08 02:55:50', '', '0');
INSERT INTO `sys_menu` VALUES ('2022', '友链管理', '2017', '4', 'link', 'content/link/index', '1', 'C', '0', '0', 'content:link:list', '404', null, '2022-01-08 02:56:50', null, '2022-01-08 02:56:50', '', '0');
INSERT INTO `sys_menu` VALUES ('2023', '写博文', '0', '0', 'write', 'content/article/write/index', '1', 'C', '0', '0', 'content:article:writer', 'build', null, '2022-01-08 03:39:58', '1', '2022-07-31 22:07:05', '', '0');
INSERT INTO `sys_menu` VALUES ('2024', '友链新增', '2022', '0', '', null, '1', 'F', '0', '0', 'content:link:add', '#', null, '2022-01-16 07:59:17', null, '2022-01-16 07:59:17', '', '0');
INSERT INTO `sys_menu` VALUES ('2025', '友链修改', '2022', '1', '', null, '1', 'F', '0', '0', 'content:link:edit', '#', null, '2022-01-16 07:59:44', null, '2022-01-16 07:59:44', '', '0');
INSERT INTO `sys_menu` VALUES ('2026', '友链删除', '2022', '1', '', null, '1', 'F', '0', '0', 'content:link:remove', '#', null, '2022-01-16 08:00:05', null, '2022-01-16 08:00:05', '', '0');
INSERT INTO `sys_menu` VALUES ('2027', '友链查询', '2022', '2', '', null, '1', 'F', '0', '0', 'content:link:query', '#', null, '2022-01-16 08:04:09', null, '2022-01-16 08:04:09', '', '0');
INSERT INTO `sys_menu` VALUES ('2028', '导出分类', '2018', '1', '', null, '1', 'F', '0', '0', 'content:category:export', '#', null, '2022-01-21 07:06:59', null, '2022-01-21 07:06:59', '', '0');
INSERT INTO `sys_menu` VALUES ('2034', '异常管理', '1', '4', 'system:error', null, '1', 'M', '0', '0', null, 'bug', null, null, null, null, '', '1');
