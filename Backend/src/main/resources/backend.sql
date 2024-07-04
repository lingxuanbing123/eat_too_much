/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : backend

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/07/2024 09:00:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_info_ibfk_1`(`userid` ASC) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '19573022922', '华中科技大学');

-- ----------------------------
-- Table structure for business_info
-- ----------------------------
DROP TABLE IF EXISTS `business_info`;
CREATE TABLE `business_info`  (
  `businessId` int(11) NOT NULL AUTO_INCREMENT,
  `businessName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `businessDetails` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`businessId`) USING BTREE,
  UNIQUE INDEX `business_id`(`businessId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_info
-- ----------------------------
INSERT INTO `business_info` VALUES (123, '123', '3121');
INSERT INTO `business_info` VALUES (124, 'dak', 'dawda');

-- ----------------------------
-- Table structure for cart_info
-- ----------------------------
DROP TABLE IF EXISTS `cart_info`;
CREATE TABLE `cart_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `goodId` int(11) NOT NULL,
  `goodName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `goodPrice` double NOT NULL,
  `goodNum` int(11) NOT NULL DEFAULT 0,
  `businessId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `good_id`(`goodId` ASC) USING BTREE,
  INDEX `business_id`(`businessId` ASC) USING BTREE,
  INDEX `cart_info_ibfk_1`(`userid` ASC) USING BTREE,
  CONSTRAINT `cart_info_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_info_ibfk_3` FOREIGN KEY (`businessId`) REFERENCES `business_info` (`businessId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_info
-- ----------------------------

-- ----------------------------
-- Table structure for good_info
-- ----------------------------
DROP TABLE IF EXISTS `good_info`;
CREATE TABLE `good_info`  (
  `goodId` int(11) NOT NULL,
  `goodName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `goodPrice` double NOT NULL,
  `businessId` int(11) NOT NULL,
  PRIMARY KEY (`goodId`) USING BTREE,
  UNIQUE INDEX `good_id`(`goodId` ASC) USING BTREE,
  INDEX `business_id`(`businessId` ASC) USING BTREE,
  CONSTRAINT `good_info_ibfk_1` FOREIGN KEY (`businessId`) REFERENCES `business_info` (`businessId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_info
-- ----------------------------
INSERT INTO `good_info` VALUES (1, '烤鸡', 100, 123);
INSERT INTO `good_info` VALUES (2, '烤鸭', 100, 123);
INSERT INTO `good_info` VALUES (3, '饭团', 100, 124);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `orderDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `isPay` tinyint(1) NOT NULL DEFAULT 1,
  `goodNum` int(11) NOT NULL DEFAULT 0,
  `orderPrices` double NOT NULL DEFAULT 0,
  `goodId` int(11) NOT NULL DEFAULT 0,
  `goodName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_info_ibfk_1`(`userid` ASC) USING BTREE,
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据表中的用户序号',
  `userid` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '用户唯一标识号，默认使用登录的手机号',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (22, '1234567910', 'user3', 'admin');
INSERT INTO `user` VALUES (25, '19573022922', 'user1', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
