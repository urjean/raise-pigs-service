/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : pigs

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 24/08/2020 23:31:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for feed
-- ----------------------------
DROP TABLE IF EXISTS `feed`;
CREATE TABLE `feed` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `feed_name` varchar(40) NOT NULL COMMENT '饲料名称',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `produce_date` date NOT NULL COMMENT '生产日期',
  `valid_month` tinyint(2) NOT NULL COMMENT '有效期（月）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='饲料表';

-- ----------------------------
-- Records of feed
-- ----------------------------
BEGIN;
INSERT INTO `feed` VALUES (123124123, 'sifa j', 123, '2020-08-05', 12, '2020-08-05 11:48:05', '2020-08-05 11:48:11', 123, 123);
COMMIT;

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `kind_name` varchar(20) NOT NULL COMMENT '种类名称',
  `kind_price` decimal(10,2) NOT NULL COMMENT '种类价格',
  `pigsty_id` bigint(20) NOT NULL COMMENT '猪圈主键',
  `feed_id` bigint(20) NOT NULL COMMENT '饲料主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='种类表';

-- ----------------------------
-- Table structure for machine
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `machine_name` varchar(40) NOT NULL COMMENT '设备名称',
  `purpose` varchar(255) DEFAULT NULL COMMENT '用途',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态（0：报废；1：完好；2：待维修）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `medicine_name` bigint(40) DEFAULT NULL COMMENT '药品名称',
  `medicine_quantity` int(11) DEFAULT NULL COMMENT '药品数量',
  `produce_date` date DEFAULT NULL COMMENT '生产日期',
  `valid_month` tinyint(2) DEFAULT NULL COMMENT '有效期（月）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品表';

-- ----------------------------
-- Table structure for pig
-- ----------------------------
DROP TABLE IF EXISTS `pig`;
CREATE TABLE `pig` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `number` int(11) NOT NULL COMMENT '编号',
  `kind_id` bigint(20) NOT NULL COMMENT '种类主键',
  `pigsty_id` bigint(20) NOT NULL COMMENT '猪圈主键',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄（月）',
  `gender` tinyint(2) NOT NULL DEFAULT '1' COMMENT '性别（0：公；1：母）',
  `status` tinyint(2) DEFAULT NULL COMMENT '健康状态（0：不健康；1：健康）',
  `inspect` tinyint(2) DEFAULT NULL COMMENT '检查情况（0：未检查；1：检查）',
  `sale` tinyint(2) DEFAULT NULL COMMENT '出售情况（0：未售出；1：售出）',
  `pregnant` tinyint(2) DEFAULT '0' COMMENT '怀孕（0：否；1：是）',
  `expect_birth_date` date DEFAULT NULL COMMENT '预计生产日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='猪表';

-- ----------------------------
-- Table structure for pigsty
-- ----------------------------
DROP TABLE IF EXISTS `pigsty`;
CREATE TABLE `pigsty` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `number` int(11) NOT NULL COMMENT '编号',
  `max_capacity` tinyint(2) DEFAULT NULL COMMENT '最大容量',
  `real_capacity` tinyint(2) DEFAULT NULL COMMENT '实际容量',
  `clean_date` date DEFAULT NULL COMMENT '清洁日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='猪圈表';

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` bigint(20) NOT NULL COMMENT '职位主键',
  `position_name` varchar(40) DEFAULT NULL COMMENT '职位名称',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '薪资',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位表';

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `type` tinyint(2) DEFAULT NULL COMMENT '采购类型',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型主键',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `purchase_date` date DEFAULT NULL COMMENT '采购日期',
  `produce_date` date DEFAULT NULL COMMENT '生产日期',
  `valid_month` tinyint(2) DEFAULT NULL COMMENT '有效期（月）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购记录';

-- ----------------------------
-- Table structure for purchase_plan
-- ----------------------------
DROP TABLE IF EXISTS `purchase_plan`;
CREATE TABLE `purchase_plan` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `type` tinyint(2) DEFAULT NULL COMMENT '采购计划类型',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型主键',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `purchase_plan_date` date DEFAULT NULL COMMENT '采购计划日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购计划表';

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `kind_id` bigint(20) DEFAULT NULL COMMENT '种类主键',
  `sale_quantity` int(11) DEFAULT NULL COMMENT '出售数量',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `sale_date` date DEFAULT NULL COMMENT '出售日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售表';

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `staff_name` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `gender` tinyint(2) DEFAULT NULL COMMENT '员工性别（0：男；1：女）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位主键',
  `adjust_salary` decimal(10,2) DEFAULT NULL COMMENT '个人薪资调整',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `permission_code` varchar(32) DEFAULT NULL COMMENT '权限code',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES (1, 'create_user', '创建用户');
INSERT INTO `sys_permission` VALUES (2, 'modify_user', '修改用户');
INSERT INTO `sys_permission` VALUES (3, 'delete_user', '删除用户');
INSERT INTO `sys_permission` VALUES (4, 'query_user', '查询用户');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色code',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(64) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '管理员，拥有所有权限');
INSERT INTO `sys_role` VALUES (2, 'user', '普通用户', '普通用户，拥有部分权限');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 1, 2);
INSERT INTO `sys_role_permission` VALUES (3, 1, 3);
INSERT INTO `sys_role_permission` VALUES (4, 1, 4);
INSERT INTO `sys_role_permission` VALUES (5, 2, 4);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account` varchar(32) NOT NULL COMMENT '账户',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `valid` tinyint(2) DEFAULT '1' COMMENT '是否有效（1.有效；0.无效）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (123456, 'osumg', '张三', '$2a$10$mWfJZ22aiK4fmwMMed.LNeSkeS7eI4x.zxdwESHh31LbOtuOvsrtK', '2020-08-20 15:11:12', 1, '2020-08-20 15:11:18', '2020-08-20 15:11:22', 1, 1);
INSERT INTO `sys_user` VALUES (123457, 'sukd', '李四', '$2a$10$mWfJZ22aiK4fmwMMed.LNeSkeS7eI4x.zxdwESHh31LbOtuOvsrtK', '2020-08-20 15:12:21', 1, '2020-08-20 15:12:25', '2020-08-20 15:12:29', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 123456, 1);
INSERT INTO `sys_user_role` VALUES (2, 123456, 2);
INSERT INTO `sys_user_role` VALUES (3, 123457, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
