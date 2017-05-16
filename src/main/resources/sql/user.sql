/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:56:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '用户id',
  `username` varchar(50) default NULL COMMENT '用户名',
  `password` char(64) default NULL COMMENT '密码',
  `state` varchar(32) default NULL COMMENT '状态',
  `create_time` datetime default NULL COMMENT '创建时间',
  `role_id` bigint(20) unsigned default NULL,
  PRIMARY KEY  (`id`),
  KEY `asda` (`role_id`),
  CONSTRAINT `asda` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '2017-05-09 11:56:41', '1');
INSERT INTO `user` VALUES ('2', '1111', '1111', null, null, null);
INSERT INTO `user` VALUES ('3', '信息学院', 'admin', null, null, null);
INSERT INTO `user` VALUES ('4', 'test', '1234', null, null, null);
INSERT INTO `user` VALUES ('5', 'test2', '1234', null, null, '1');
INSERT INTO `user` VALUES ('7', 'jxadmin', '1234', null, null, '24');
