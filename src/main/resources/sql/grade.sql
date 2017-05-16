/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-16 15:55:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_Id` varchar(64) NOT NULL,
  `grade_name` varchar(20) default NULL,
  `gmajor_id` varchar(64) default NULL,
  `photo` varchar(60) default NULL,
  `year` varchar(4) default NULL,
  PRIMARY KEY  (`grade_Id`),
  KEY `gmajor_id_fk` (`gmajor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('175acc6e874710358c4e39e5d476d2bb', '1', 'fe3d8eed851a103580d7e7d881007961', '/static/images/8e4ea8723235436a89bc734dc6ae4de4.jpg', '2016');
INSERT INTO `grade` VALUES ('28d9cc3a860a103580d7e7d881007961', '2', 'a80fab5982b6103594d0392f41b8d916', '/static/images/cd07b3b13dd641728b0680908274fac6.jpg', '2015');
INSERT INTO `grade` VALUES ('30303c2985db103580d7e7d881007961', '11', 'de6ab1fc8518103580d7e7d881007961', '/static/images/e13e11d59d7f4c7fabffa5fe632c732e.jpg', '2013');
INSERT INTO `grade` VALUES ('905b63ad85c5103580d7e7d881007961', '1', 'de6ab1fc8518103580d7e7d881007961', '/static/images/ab49f450a6e2461084b2826101a95f50.jpg', '2015');
INSERT INTO `grade` VALUES ('f411a28985c5103580d7e7d881007961', '1', 'de6ab1fc8518103580d7e7d881007961', '/static/images/689f75c9b9c34d969a9d6dd861018b48.jpg', '2015');
