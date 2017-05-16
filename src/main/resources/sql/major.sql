/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:56:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_Id` varchar(64) NOT NULL,
  `major_name` varchar(20) default NULL,
  `mcourse_id` varchar(64) default NULL,
  PRIMARY KEY  (`major_Id`),
  KEY `mcourse_id_fk` (`mcourse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('95ff0cdd82b6103594d0392f41b8d916', '信息安全技术', '555774c082b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('9b86f37c82b6103594d0392f41b8d916', '移动通信技术', '555774c082b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('9c0db94b82bb103594d0392f41b8d916', '哈哈', '');
INSERT INTO `major` VALUES ('a80fab5982b6103594d0392f41b8d916', '软件开发与项目管理', '555774c082b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('bc3ff01282b6103594d0392f41b8d916', '酒店管理', '69024ae382b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('c9ce6a5382b6103594d0392f41b8d916', '会计', '69024ae382b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('cf8eb7908b5c103597a85d8581f753ba', 'test', '585c6d8582b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('de6ab1fc8518103580d7e7d881007961', '数控车床', '585c6d8582b6103594d0392f41b8d916');
INSERT INTO `major` VALUES ('fe3d8eed851a103580d7e7d881007961', '信息技术', '555774c082b6103594d0392f41b8d916');
