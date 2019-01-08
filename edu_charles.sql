/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : edu_charles

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-08 18:01:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `title` varchar(127) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `content` varchar(9999) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_author
-- ----------------------------
DROP TABLE IF EXISTS `t_author`;
CREATE TABLE `t_author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` tinyint(4) NOT NULL COMMENT '0:男 1：女',
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(1023) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_author
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL COMMENT '账号',
  `name` varchar(63) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `sex` tinyint(4) NOT NULL COMMENT '0 男 1女',
  `age` int(11) DEFAULT NULL,
  `phase` tinyint(4) NOT NULL COMMENT '0:停用 1：启用',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:普通用户 1：vip用户',
  `description` varchar(300) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`account`) COMMENT '账号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('2', 'zbw', '张三', '$2a$10$CvgC6lPV/rkFtPQXLKfAk.3Vav0OwAOWA7nj28ikacy89SOEdC3ZW', '1', null, '1', '0', '呵呵', '2019-01-08 09:18:18', '2019-01-08 09:18:18');

-- ----------------------------
-- Table structure for t_custom_token
-- ----------------------------
DROP TABLE IF EXISTS `t_custom_token`;
CREATE TABLE `t_custom_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) NOT NULL,
  `token` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_custom_token
-- ----------------------------
INSERT INTO `t_custom_token` VALUES ('1', '2', 'xxcbearer:eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDcwMjY5MzgsImFjY291bnQiOiJ6YncifQ.-hv7JubJqO8OqoC4qKhdkNLky5m7gNZ6e8qQkLfYkCVvp_LLLn9Z3ooPF4MAhHLVhgFo5a8usHTvb6YF4pmpUw', '2019-01-08 09:42:19', '2019-01-08 09:42:19');

-- ----------------------------
-- Table structure for t_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_tags`;
CREATE TABLE `t_tags` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `desc` varchar(511) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_tags
-- ----------------------------
