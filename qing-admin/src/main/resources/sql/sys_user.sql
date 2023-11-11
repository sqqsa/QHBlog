/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : q_blog

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-11-11 20:55:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `password` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `type` char(1) DEFAULT '0' COMMENT '用户类型：0代表普通用户，1代表管理员',
  `status` char(1) DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phonenumber` varchar(32) DEFAULT NULL COMMENT '手机号',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `create_by` bigint DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14787164048665 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'sg', 'sg111', '$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy', '1', '0', '23412332@qq.com', '18888888888', '1', 'http://blog-qlt.oss-cn-beijing.aliyuncs.com/44cac5235228449690476a71d5b4ffc21.png?Expires=1693039987&OSSAccessKeyId=LTAI5t95yMJVtQtzFFyygzba&Signature=5VDgLxbTa9F358L29%2FANeXYX4FI%3D', null, '2022-01-05 09:01:56', '1', '2022-01-30 15:37:03', '0');
INSERT INTO `sys_user` VALUES ('3', 'sg3', 'weqe', '$2a$10$ydv3rLkteFnRx9xelQ7elOiVhFvXOooA98xCqk/omh7G94R.K/E3O', '1', '0', null, null, '0', null, null, '2022-01-05 13:28:43', null, '2022-01-05 13:28:43', '0');
INSERT INTO `sys_user` VALUES ('4', 'sg2', 'dsadd', '$2a$10$kY4T3SN7i4muBccZppd2OOkhxMN6yt8tND1sF89hXOaFylhY2T3he', '1', '0', '23412332@qq.com', '19098790742', '0', null, null, null, null, null, '0');
INSERT INTO `sys_user` VALUES ('5', 'sg2233', 'tteqe', '', '1', '0', null, '18246845873', '1', null, null, '2022-01-06 03:51:13', null, '2022-01-06 07:00:50', '0');
INSERT INTO `sys_user` VALUES ('6', 'sangeng', 'sangeng', '$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy', '1', '0', '2312321', '17777777777', '0', null, null, '2022-01-16 06:54:26', null, '2022-01-16 07:06:34', '0');
INSERT INTO `sys_user` VALUES ('14787164048662', 'weixin', 'weixin', '$2a$10$y3k3fnMZsBNihsVLXWfI8uMNueVXBI08k.LzWYaKsW8CW7xXy18wC', '0', '0', 'weixin@qq.com', null, null, null, '-1', '2022-01-30 17:18:44', '-1', '2022-01-30 17:18:44', '0');
INSERT INTO `sys_user` VALUES ('14787164048664', 'cpa', '陈平安', '$2a$10$tNp.RmI3vi1h3zZwClhQqOYQoMxZ8k1M.tYuW6UtjCfnB1wqhomVK', '0', '0', 'cpa@jqcc.com', null, '0', null, null, null, null, null, '0');
