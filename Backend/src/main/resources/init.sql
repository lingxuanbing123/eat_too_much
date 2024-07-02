USE backend;

/*
 * 商家信息表
 */
CREATE TABLE IF NOT EXISTS `business_info`
(
    `business_id`      int          NOT NULL AUTO_INCREMENT,-- 商家id
    `business_name`    varchar(255) NOT NULL,-- 商家名称
    `business_details` varchar(255) NOT NULL,-- 商家详情
    PRIMARY KEY (`business_id`),
    UNIQUE KEY (`business_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

/*
 * 商品信息表
 */
CREATE TABLE IF NOT EXISTS `good_info`
(
    `good_id`     int          NOT NULL,-- 商品id
    `good_name`   varchar(255) NOT NULL,-- 商品名称
    `good_price`  double       NOT NULL,-- 商品价格
    `business_id` int          NOT NULL,-- 商家id
    PRIMARY KEY (`good_id`),
    UNIQUE KEY (`good_id`),
    FOREIGN KEY (`business_id`) REFERENCES `business_info` (`business_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

/*
 * 用户信息表
 */
CREATE TABLE IF NOT EXISTS `user`
(
    `id`        int          NOT NULL AUTO_INCREMENT COMMENT '数据表中的用户序号',
    `user_id`   varchar(11)  NOT NULL COMMENT '用户唯一标识号，默认使用登录的手机号',
    `user_name` varchar(15)  NOT NULL,-- 用户名
    `password`  varchar(255) NOT NULL,-- 密码
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_id` (`user_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

/*
 * 订单信息表
 */
CREATE TABLE IF NOT EXISTS `order_info`
(
    `id`          int          NOT NULL AUTO_INCREMENT,-- 订单序号
    `user_id`     varchar(11)  NOT NULL,-- 用户id
    `order_date`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `is_pay`      boolean      NOT NULL DEFAULT FALSE,-- 是否支付
    `good_num`    int          NOT NULL DEFAULT 0,-- 商品数量
    `order_prices` double       NOT NULL DEFAULT 0,-- 商品价格
    `good_id`     int          NOT NULL DEFAULT 0,-- 商品id
    `good_name`   varchar(255) NOT NULL,-- 商品名称
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

/*
 * 购物车信息表
 */
CREATE TABLE IF NOT EXISTS `cart_info`
(
    `id`          int          NOT NULL AUTO_INCREMENT,-- 购物车序号
    `user_id`     varchar(11)  NOT NULL,-- 用户id
    `good_id`     int          NOT NULL,-- 商品id
    `good_name`   varchar(255) NOT NULL,-- 商品名称
    `good_price`  double       NOT NULL,-- 商品价格
    `good_num`    int          NOT NULL DEFAULT 0,-- 商品数量
    `business_id` int          NOT NULL,-- 商家id
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`good_id`) REFERENCES `good_info` (`good_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`business_id`) REFERENCES `business_info` (`business_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;