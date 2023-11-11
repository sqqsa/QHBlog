/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : q_blog

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-11-11 20:54:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('0', '0');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '2000');
INSERT INTO `sys_role_menu` VALUES ('3', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '3');
INSERT INTO `sys_role_menu` VALUES ('3', '4');
INSERT INTO `sys_role_menu` VALUES ('3', '100');
INSERT INTO `sys_role_menu` VALUES ('3', '101');
INSERT INTO `sys_role_menu` VALUES ('3', '103');
INSERT INTO `sys_role_menu` VALUES ('3', '104');
INSERT INTO `sys_role_menu` VALUES ('3', '105');
INSERT INTO `sys_role_menu` VALUES ('3', '106');
INSERT INTO `sys_role_menu` VALUES ('3', '107');
INSERT INTO `sys_role_menu` VALUES ('3', '108');
INSERT INTO `sys_role_menu` VALUES ('3', '109');
INSERT INTO `sys_role_menu` VALUES ('3', '110');
INSERT INTO `sys_role_menu` VALUES ('3', '111');
INSERT INTO `sys_role_menu` VALUES ('3', '112');
INSERT INTO `sys_role_menu` VALUES ('3', '113');
INSERT INTO `sys_role_menu` VALUES ('3', '114');
INSERT INTO `sys_role_menu` VALUES ('3', '115');
INSERT INTO `sys_role_menu` VALUES ('3', '116');
INSERT INTO `sys_role_menu` VALUES ('3', '500');
INSERT INTO `sys_role_menu` VALUES ('3', '501');
INSERT INTO `sys_role_menu` VALUES ('3', '1001');
INSERT INTO `sys_role_menu` VALUES ('3', '1002');
INSERT INTO `sys_role_menu` VALUES ('3', '1003');
INSERT INTO `sys_role_menu` VALUES ('3', '1004');
INSERT INTO `sys_role_menu` VALUES ('3', '1005');
INSERT INTO `sys_role_menu` VALUES ('3', '1006');
INSERT INTO `sys_role_menu` VALUES ('3', '1007');
INSERT INTO `sys_role_menu` VALUES ('3', '1008');
INSERT INTO `sys_role_menu` VALUES ('3', '1009');
INSERT INTO `sys_role_menu` VALUES ('3', '1010');
INSERT INTO `sys_role_menu` VALUES ('3', '1011');
INSERT INTO `sys_role_menu` VALUES ('3', '1012');
INSERT INTO `sys_role_menu` VALUES ('3', '1017');
INSERT INTO `sys_role_menu` VALUES ('3', '1018');
INSERT INTO `sys_role_menu` VALUES ('3', '1019');
INSERT INTO `sys_role_menu` VALUES ('3', '1020');
INSERT INTO `sys_role_menu` VALUES ('3', '1021');
INSERT INTO `sys_role_menu` VALUES ('3', '1022');
INSERT INTO `sys_role_menu` VALUES ('3', '1023');
INSERT INTO `sys_role_menu` VALUES ('3', '1024');
INSERT INTO `sys_role_menu` VALUES ('3', '1025');
INSERT INTO `sys_role_menu` VALUES ('3', '1026');
INSERT INTO `sys_role_menu` VALUES ('3', '1027');
INSERT INTO `sys_role_menu` VALUES ('3', '1028');
INSERT INTO `sys_role_menu` VALUES ('3', '1029');
INSERT INTO `sys_role_menu` VALUES ('3', '1030');
INSERT INTO `sys_role_menu` VALUES ('3', '1031');
INSERT INTO `sys_role_menu` VALUES ('3', '1032');
INSERT INTO `sys_role_menu` VALUES ('3', '1033');
INSERT INTO `sys_role_menu` VALUES ('3', '1034');
INSERT INTO `sys_role_menu` VALUES ('3', '1035');
INSERT INTO `sys_role_menu` VALUES ('3', '1036');
INSERT INTO `sys_role_menu` VALUES ('3', '1037');
INSERT INTO `sys_role_menu` VALUES ('3', '1038');
INSERT INTO `sys_role_menu` VALUES ('3', '1039');
INSERT INTO `sys_role_menu` VALUES ('3', '1040');
INSERT INTO `sys_role_menu` VALUES ('3', '1041');
INSERT INTO `sys_role_menu` VALUES ('3', '1042');
INSERT INTO `sys_role_menu` VALUES ('3', '1043');
INSERT INTO `sys_role_menu` VALUES ('3', '1044');
INSERT INTO `sys_role_menu` VALUES ('3', '1045');
INSERT INTO `sys_role_menu` VALUES ('3', '1046');
INSERT INTO `sys_role_menu` VALUES ('3', '1047');
INSERT INTO `sys_role_menu` VALUES ('3', '1048');
INSERT INTO `sys_role_menu` VALUES ('3', '1049');
INSERT INTO `sys_role_menu` VALUES ('3', '1050');
INSERT INTO `sys_role_menu` VALUES ('3', '1051');
INSERT INTO `sys_role_menu` VALUES ('3', '1052');
INSERT INTO `sys_role_menu` VALUES ('3', '1053');
INSERT INTO `sys_role_menu` VALUES ('3', '1054');
INSERT INTO `sys_role_menu` VALUES ('3', '1055');
INSERT INTO `sys_role_menu` VALUES ('3', '1056');
INSERT INTO `sys_role_menu` VALUES ('3', '1057');
INSERT INTO `sys_role_menu` VALUES ('3', '1058');
INSERT INTO `sys_role_menu` VALUES ('3', '1059');
INSERT INTO `sys_role_menu` VALUES ('3', '1060');
INSERT INTO `sys_role_menu` VALUES ('3', '2000');
INSERT INTO `sys_role_menu` VALUES ('11', '1');
INSERT INTO `sys_role_menu` VALUES ('11', '100');
INSERT INTO `sys_role_menu` VALUES ('11', '101');
INSERT INTO `sys_role_menu` VALUES ('11', '102');
INSERT INTO `sys_role_menu` VALUES ('11', '103');
INSERT INTO `sys_role_menu` VALUES ('11', '104');
INSERT INTO `sys_role_menu` VALUES ('11', '105');
INSERT INTO `sys_role_menu` VALUES ('11', '106');
INSERT INTO `sys_role_menu` VALUES ('11', '107');
INSERT INTO `sys_role_menu` VALUES ('11', '108');
INSERT INTO `sys_role_menu` VALUES ('11', '500');
INSERT INTO `sys_role_menu` VALUES ('11', '501');
INSERT INTO `sys_role_menu` VALUES ('11', '1001');
INSERT INTO `sys_role_menu` VALUES ('11', '1002');
INSERT INTO `sys_role_menu` VALUES ('11', '1003');
INSERT INTO `sys_role_menu` VALUES ('11', '1004');
INSERT INTO `sys_role_menu` VALUES ('11', '1005');
INSERT INTO `sys_role_menu` VALUES ('11', '1006');
INSERT INTO `sys_role_menu` VALUES ('11', '1007');
INSERT INTO `sys_role_menu` VALUES ('11', '1008');
INSERT INTO `sys_role_menu` VALUES ('11', '1009');
INSERT INTO `sys_role_menu` VALUES ('11', '1010');
INSERT INTO `sys_role_menu` VALUES ('11', '1011');
INSERT INTO `sys_role_menu` VALUES ('11', '1012');
INSERT INTO `sys_role_menu` VALUES ('11', '1013');
INSERT INTO `sys_role_menu` VALUES ('11', '1014');
INSERT INTO `sys_role_menu` VALUES ('11', '1015');
INSERT INTO `sys_role_menu` VALUES ('11', '1016');
INSERT INTO `sys_role_menu` VALUES ('11', '1017');
INSERT INTO `sys_role_menu` VALUES ('11', '1018');
INSERT INTO `sys_role_menu` VALUES ('11', '1019');
INSERT INTO `sys_role_menu` VALUES ('11', '1020');
INSERT INTO `sys_role_menu` VALUES ('11', '1021');
INSERT INTO `sys_role_menu` VALUES ('11', '1022');
INSERT INTO `sys_role_menu` VALUES ('11', '1023');
INSERT INTO `sys_role_menu` VALUES ('11', '1024');
INSERT INTO `sys_role_menu` VALUES ('11', '1025');
INSERT INTO `sys_role_menu` VALUES ('11', '1026');
INSERT INTO `sys_role_menu` VALUES ('11', '1027');
INSERT INTO `sys_role_menu` VALUES ('11', '1028');
INSERT INTO `sys_role_menu` VALUES ('11', '1029');
INSERT INTO `sys_role_menu` VALUES ('11', '1030');
INSERT INTO `sys_role_menu` VALUES ('11', '1031');
INSERT INTO `sys_role_menu` VALUES ('11', '1032');
INSERT INTO `sys_role_menu` VALUES ('11', '1033');
INSERT INTO `sys_role_menu` VALUES ('11', '1034');
INSERT INTO `sys_role_menu` VALUES ('11', '1035');
INSERT INTO `sys_role_menu` VALUES ('11', '1036');
INSERT INTO `sys_role_menu` VALUES ('11', '1037');
INSERT INTO `sys_role_menu` VALUES ('11', '1038');
INSERT INTO `sys_role_menu` VALUES ('11', '1039');
INSERT INTO `sys_role_menu` VALUES ('11', '1040');
INSERT INTO `sys_role_menu` VALUES ('11', '1041');
INSERT INTO `sys_role_menu` VALUES ('11', '1042');
INSERT INTO `sys_role_menu` VALUES ('11', '1043');
INSERT INTO `sys_role_menu` VALUES ('11', '1044');
INSERT INTO `sys_role_menu` VALUES ('11', '1045');
INSERT INTO `sys_role_menu` VALUES ('11', '2000');
INSERT INTO `sys_role_menu` VALUES ('11', '2003');
INSERT INTO `sys_role_menu` VALUES ('11', '2004');
INSERT INTO `sys_role_menu` VALUES ('11', '2005');
INSERT INTO `sys_role_menu` VALUES ('11', '2006');
INSERT INTO `sys_role_menu` VALUES ('11', '2007');
INSERT INTO `sys_role_menu` VALUES ('11', '2008');
INSERT INTO `sys_role_menu` VALUES ('11', '2009');
INSERT INTO `sys_role_menu` VALUES ('11', '2010');
INSERT INTO `sys_role_menu` VALUES ('11', '2011');
INSERT INTO `sys_role_menu` VALUES ('11', '2012');
INSERT INTO `sys_role_menu` VALUES ('11', '2013');
INSERT INTO `sys_role_menu` VALUES ('11', '2014');
INSERT INTO `sys_role_menu` VALUES ('12', '2017');
INSERT INTO `sys_role_menu` VALUES ('12', '2022');
INSERT INTO `sys_role_menu` VALUES ('12', '2024');
INSERT INTO `sys_role_menu` VALUES ('12', '2025');
INSERT INTO `sys_role_menu` VALUES ('12', '2026');
INSERT INTO `sys_role_menu` VALUES ('12', '2027');
