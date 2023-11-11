/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : q_blog

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-11-11 20:54:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sg_tag
-- ----------------------------
DROP TABLE IF EXISTS `sg_tag`;
CREATE TABLE `sg_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '标签名',
  `create_by` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='标签';

-- ----------------------------
-- Records of sg_tag
-- ----------------------------
INSERT INTO `sg_tag` VALUES ('1', 'Mybatis', null, null, null, '2022-01-11 09:20:50', '0', 'weqwe');
INSERT INTO `sg_tag` VALUES ('2', 'asdas', null, '2022-01-11 09:20:55', null, '2022-01-11 09:20:55', '1', 'weqw');
INSERT INTO `sg_tag` VALUES ('3', 'weqw', null, '2022-01-11 09:21:07', null, '2022-01-11 09:21:07', '1', 'qweqwe');
INSERT INTO `sg_tag` VALUES ('4', 'Java', null, '2022-01-13 15:22:43', null, '2022-01-13 15:22:43', '0', 'sdad');
INSERT INTO `sg_tag` VALUES ('5', 'WAD', null, '2022-01-13 15:22:47', null, '2023-08-09 10:47:45', '1', 'ASDAD');
INSERT INTO `sg_tag` VALUES ('6', 'GoLang', null, '2023-08-09 09:35:39', null, null, '1', 'GoLang!!!!!');
INSERT INTO `sg_tag` VALUES ('7', 'DFF', '1', '2023-08-09 11:04:40', null, '2023-08-10 04:10:58', '0', 'DFF!!!11');
INSERT INTO `sg_tag` VALUES ('8', '人力资源', '1', '2023-08-10 04:11:25', null, '2023-08-10 04:11:29', '0', '老师还可以111');
