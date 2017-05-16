/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:56:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '角色id',
  `role_name` varchar(32) default NULL COMMENT '角色名',
  `role_sign` varchar(128) default NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(256) default NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '信息学院管理员', 'xxxyadmin', '信息学院');
INSERT INTO `role` VALUES ('3', '222', '22222', '222');
INSERT INTO `role` VALUES ('5', '222', '22222', '222');
INSERT INTO `role` VALUES ('22', 'test', 'xxx', '123');
INSERT INTO `role` VALUES ('23', 'test', 'xxx', '123');
INSERT INTO `role` VALUES ('24', '机械学院管理员', 'jxxyadmin', '机械学院');
