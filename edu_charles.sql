/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : edu_charles

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-30 17:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc` varchar(511) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tags
-- ----------------------------
