/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : q_blog

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-11-11 20:54:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sg_comment
-- ----------------------------
DROP TABLE IF EXISTS `sg_comment`;
CREATE TABLE `sg_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` char(1) DEFAULT '0' COMMENT '评论类型（0代表文章评论，1代表友链评论）',
  `article_id` bigint DEFAULT NULL COMMENT '文章id',
  `root_id` bigint DEFAULT '-1' COMMENT '根评论id',
  `content` varchar(512) DEFAULT NULL COMMENT '评论内容',
  `to_comment_user_id` bigint DEFAULT '-1' COMMENT '所回复的目标评论的userid',
  `to_comment_id` bigint DEFAULT '-1' COMMENT '回复目标评论id',
  `create_by` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表';

-- ----------------------------
-- Records of sg_comment
-- ----------------------------
INSERT INTO `sg_comment` VALUES ('1', '0', '1', '-1', 'asS', '-1', '-1', '1', '2022-01-29 07:59:22', '1', '2022-01-29 07:59:22', '0');
INSERT INTO `sg_comment` VALUES ('2', '0', '1', '-1', '[哈哈]SDAS', '-1', '-1', '1', '2022-01-29 08:01:24', '1', '2022-01-29 08:01:24', '0');
INSERT INTO `sg_comment` VALUES ('3', '0', '1', '-1', '是大多数', '-1', '-1', '1', '2022-01-29 16:07:24', '1', '2022-01-29 16:07:24', '0');
INSERT INTO `sg_comment` VALUES ('4', '0', '1', '-1', '撒大声地', '-1', '-1', '1', '2022-01-29 16:12:09', '1', '2022-01-29 16:12:09', '0');
INSERT INTO `sg_comment` VALUES ('5', '0', '1', '-1', '你再说什么', '-1', '-1', '1', '2022-01-29 18:19:56', '1', '2022-01-29 18:19:56', '0');
INSERT INTO `sg_comment` VALUES ('6', '0', '1', '-1', 'hffd', '-1', '-1', '1', '2022-01-29 22:13:52', '1', '2022-01-29 22:13:52', '0');
INSERT INTO `sg_comment` VALUES ('9', '0', '1', '2', '你说什么', '1', '2', '1', '2022-01-29 22:18:40', '1', '2022-01-29 22:18:40', '0');
INSERT INTO `sg_comment` VALUES ('10', '0', '1', '2', '哈哈哈哈[哈哈]', '1', '9', '1', '2022-01-29 22:29:15', '1', '2022-01-29 22:29:15', '0');
INSERT INTO `sg_comment` VALUES ('11', '0', '1', '2', 'we全文', '1', '10', '3', '2022-01-29 22:29:55', '1', '2022-01-29 22:29:55', '0');
INSERT INTO `sg_comment` VALUES ('12', '0', '1', '-1', '王企鹅', '-1', '-1', '1', '2022-01-29 22:30:20', '1', '2022-01-29 22:30:20', '0');
INSERT INTO `sg_comment` VALUES ('13', '0', '1', '-1', '什么阿是', '-1', '-1', '1', '2022-01-29 22:30:56', '1', '2022-01-29 22:30:56', '0');
INSERT INTO `sg_comment` VALUES ('14', '0', '1', '-1', '新平顶山', '-1', '-1', '1', '2022-01-29 22:32:51', '1', '2022-01-29 22:32:51', '0');
INSERT INTO `sg_comment` VALUES ('15', '0', '1', '-1', '2222', '-1', '-1', '1', '2022-01-29 22:34:38', '1', '2022-01-29 22:34:38', '0');
INSERT INTO `sg_comment` VALUES ('16', '0', '1', '2', '3333', '1', '11', '1', '2022-01-29 22:34:47', '1', '2022-01-29 22:34:47', '0');
INSERT INTO `sg_comment` VALUES ('17', '0', '1', '2', '回复weqedadsd', '3', '11', '1', '2022-01-29 22:38:00', '1', '2022-01-29 22:38:00', '0');
INSERT INTO `sg_comment` VALUES ('18', '0', '1', '-1', 'sdasd', '-1', '-1', '1', '2022-01-29 23:18:19', '1', '2022-01-29 23:18:19', '0');
INSERT INTO `sg_comment` VALUES ('19', '0', '1', '-1', '111', '-1', '-1', '1', '2022-01-29 23:22:23', '1', '2022-01-29 23:22:23', '0');
INSERT INTO `sg_comment` VALUES ('20', '0', '1', '1', '你说啥？', '1', '1', '1', '2022-01-30 10:06:21', '1', '2022-01-30 10:06:21', '0');
INSERT INTO `sg_comment` VALUES ('21', '0', '1', '-1', '友链添加个呗', '-1', '-1', '1', '2022-01-30 10:06:50', '1', '2022-01-30 10:06:50', '0');
INSERT INTO `sg_comment` VALUES ('22', '1', '1', '-1', '友链评论2', '-1', '-1', '1', '2022-01-30 10:08:28', '1', '2022-01-30 10:08:28', '0');
INSERT INTO `sg_comment` VALUES ('23', '1', '1', '22', '回复友链评论3', '1', '22', '1', '2022-01-30 10:08:50', '1', '2022-01-30 10:08:50', '0');
INSERT INTO `sg_comment` VALUES ('24', '1', '1', '-1', '友链评论4444', '-1', '-1', '1', '2022-01-30 10:09:03', '1', '2022-01-30 10:09:03', '0');
INSERT INTO `sg_comment` VALUES ('25', '1', '1', '22', '收到的', '1', '22', '1', '2022-01-30 10:13:28', '1', '2022-01-30 10:13:28', '0');
INSERT INTO `sg_comment` VALUES ('26', '0', '1', '-1', 'sda', '-1', '-1', '1', '2022-01-30 10:39:05', '1', '2022-01-30 10:39:05', '0');
INSERT INTO `sg_comment` VALUES ('27', '0', '1', '1', '说你咋地', '1', '20', '14787164048662', '2022-01-30 17:19:30', '14787164048662', '2022-01-30 17:19:30', '0');
INSERT INTO `sg_comment` VALUES ('28', '0', '1', '1', 'sdad', '1', '1', '14787164048662', '2022-01-31 11:11:20', '14787164048662', '2022-01-31 11:11:20', '0');
INSERT INTO `sg_comment` VALUES ('29', '0', '1', '-1', '你说是的ad', '-1', '-1', '14787164048662', '2022-01-31 14:10:11', '14787164048662', '2022-01-31 14:10:11', '0');
INSERT INTO `sg_comment` VALUES ('30', '0', '1', '1', '撒大声地', '1', '1', '14787164048662', '2022-01-31 20:19:18', '14787164048662', '2022-01-31 20:19:18', '0');
INSERT INTO `sg_comment` VALUES ('31', '0', '1', '1', '到底有谁知道', '1', '20', '1', '2023-07-31 22:43:15', '1', '2023-07-31 22:43:15', '0');
INSERT INTO `sg_comment` VALUES ('32', '0', '1', '-1', '1', '-1', '-1', '1', '2023-08-02 14:52:29', '1', '2023-08-02 14:52:29', '0');
INSERT INTO `sg_comment` VALUES ('33', '1', '1', '-1', '1', '-1', '-1', '1', '2023-08-02 14:52:45', '1', '2023-08-02 14:52:45', '0');
INSERT INTO `sg_comment` VALUES ('34', '1', '1', '-1', '1', '-1', '-1', '1', '2023-08-02 14:54:13', '1', '2023-08-02 14:54:13', '0');
INSERT INTO `sg_comment` VALUES ('35', '1', '1', '-1', '友情链接评论测试', '-1', '-1', '1', '2023-08-02 14:57:55', '1', '2023-08-02 14:57:55', '0');
