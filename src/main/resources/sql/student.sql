/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:56:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(64) NOT NULL,
  `tel` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `Photo` varchar(60) default NULL,
  `sgrade_Id` varchar(64) default NULL,
  `QQ` varchar(20) default NULL,
  `scourse_id` varchar(64) default NULL,
  `company` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `sgrade_id_fk` (`sgrade_Id`),
  KEY `scourse_id_fk` (`scourse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2b29241e874710358c4e39e5d476d2bb', '15523235802', '王五', '/static/images/18cc009105c840a29b22c0e461553b41.jpg', '175acc6e874710358c4e39e5d476d2bb', '1002139909', '555774c082b6103594d0392f41b8d916', '国家电网');
INSERT INTO `student` VALUES ('d2ea2d7086db10358c4e39e5d476d2bb', '15523235802', '大王', '/static/images/04139a3fd1b443c08ee4771d52078677.jpg', '30303c2985db103580d7e7d881007961', '1002139909', '585c6d8582b6103594d0392f41b8d916', '国家电网');
INSERT INTO `student` VALUES ('e7b1b44386db10358c4e39e5d476d2bb', '15523235802', '安妮', '/static/images/83b5bb39271b4d10ae473a419785d0e1.jpg', '28d9cc3a860a103580d7e7d881007961', '1002139909', '555774c082b6103594d0392f41b8d916', '百度');
INSERT INTO `student` VALUES ('f76041b686db10358c4e39e5d476d2bb', '15523235802', '张三', '/static/images/670588c278ba45fda623110e797b27e6.jpg', '30303c2985db103580d7e7d881007961', '1002139909', '585c6d8582b6103594d0392f41b8d916', '京东');
