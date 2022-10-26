SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `category_id` bigint(20) DEFAULT NULL,
                            `icon` varchar(500) DEFAULT NULL,
                            `title` varchar(100) DEFAULT NULL,
                            `show_status` int(1) DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `read_count` int(1) DEFAULT NULL,
                            `content` text,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商表';



-- ----------------------------
-- Table structure for final_users
-- ----------------------------
DROP TABLE IF EXISTS `final_users`;
CREATE TABLE `final_users` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                     `name` varchar(100) DEFAULT NULL,
                                     `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                                     `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                                     `show_status` int(2) DEFAULT NULL,
                                     `sort` int(11) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户表';


-- ----------------------------
-- Table structure for 正扫交易记录
-- ----------------------------
DROP TABLE IF EXISTS `final_users`;
CREATE TABLE `final_users` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(100) DEFAULT NULL,
                               `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                               `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                               `show_status` int(2) DEFAULT NULL,
                               `sort` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='正扫交易记录';


-- -- ----------------------------
-- -- Table structure for 反扫交易记录
-- -- ----------------------------
-- DROP TABLE IF EXISTS `final_users`;
-- CREATE TABLE `final_users` (
--                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
--                                `name` varchar(100) DEFAULT NULL,
--                                `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
--                                `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
--                                `show_status` int(2) DEFAULT NULL,
--                                `sort` int(11) DEFAULT NULL,
--                                PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反扫交易记录';


-- ----------------------------
-- Table structure for 反扫交易记录
-- ----------------------------
DROP TABLE IF EXISTS `final_users`;
CREATE TABLE `final_users` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(100) DEFAULT NULL,
                               `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                               `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                               `show_status` int(2) DEFAULT NULL,
                               `sort` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推荐关系表';



-- ----------------------------
-- Table structure for 利润分配结果记录表
-- ----------------------------
DROP TABLE IF EXISTS `final_users`;
CREATE TABLE `final_users` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(100) DEFAULT NULL,
                               `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                               `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                               `show_status` int(2) DEFAULT NULL,
                               `sort` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='最终用户表';


-- ----------------------------
-- Table structure for 利润分配结果记录表
-- ----------------------------
DROP TABLE IF EXISTS `agent_split`;
CREATE TABLE `agent_split` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(100) DEFAULT NULL,
                               `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                               `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                               `show_status` int(2) DEFAULT NULL,
                               `sort` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='利润分配结果记录表'


-- ----------------------------
-- Table structure for 利润分配结果记录表
-- ----------------------------
DROP TABLE IF EXISTS `split`;
CREATE TABLE `split` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(100) DEFAULT NULL,
                               `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
                               `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
                               `show_status` int(2) DEFAULT NULL,
                               `sort` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='利润分配结果记录表'

