/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(64) NOT NULL,
  `course_name` varchar(20) default NULL,
  PRIMARY KEY  (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('555774c082b6103594d0392f41b8d916', '信息工程学院');
INSERT INTO `course` VALUES ('585c6d8582b6103594d0392f41b8d916', '机械工程学院');
INSERT INTO `course` VALUES ('5fc3a28882b6103594d0392f41b8d916', '艺术与设计学院');
INSERT INTO `course` VALUES ('666bf8e882b6103594d0392f41b8d916', '矿物与环境学院');
INSERT INTO `course` VALUES ('69024ae382b6103594d0392f41b8d916', '财经与贸易学院');
INSERT INTO `course` VALUES ('6ddeea4682b6103594d0392f41b8d916', '继续教育学院');
INSERT INTO `course` VALUES ('96767287885d10358c4e39e5d476d2bb', '测试');
