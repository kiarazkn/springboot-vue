/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_manager
Target Host: localhost
Target Database: db_manager
Date: 2022/11/8 0:25:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `publishdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `comefrom` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_newstype
-- ----------------------------
DROP TABLE IF EXISTS `t_newstype`;
CREATE TABLE `t_newstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '2', '[世乒赛]中国女团3-0美国女团', '2022年10月3日，2022年第56届国际乒联世界乒乓球团体锦标赛（决赛）第四比赛日，中国女子团体迎战美国女子团体的比赛在成都高新体育中心多功能馆举办。', '2022-10-04 19:36:52', '新浪网');
INSERT INTO `t_news` VALUES ('2', '5', '【美股大涨700点！】', '【美股大涨700点！市场押注美联储调整政策！“风暴眼”瑞信转涨，#特斯拉创四个月最大跌幅#】', '2022-10-04 19:38:29', '环球市场播报');
INSERT INTO `t_news` VALUES ('3', '8', '【震撼！#东风快递发射大场面帧帧大片#】', '火热演兵场上，一枚枚“长剑”腾飞，划出一条条弹道。从“固定发射”到“机动发射”，从“择机发射”到“随机发射”，从“实弹发射”到“实战发射”， 火箭军官兵奋力打造新型导弹方阵，锻造大国“利剑”！东风快递，使命必达！', '2022-10-04 19:40:56', '央视军事');
INSERT INTO `t_news` VALUES ('4', '7', '2022年诺贝尔化学奖揭晓 原来化学奖是“跨界明星”？', '中新网10月5日电(管娜)北京时间10月5日下午，2022年诺贝尔化学奖揭晓。瑞典皇家科学院将该奖授予卡罗琳•露丝•贝尔托西(Carolyn R. Bertozzi)、摩顿•梅尔达尔(Morten Meldal)和卡尔•巴里•夏普莱斯(K. Barry Sharpless)，以表彰他们在“点击化学和生物正交化学”方面所做出的贡献。\n诺贝尔奖官网介绍称，夏普莱斯和梅尔达尔为一种功能形式的化学——点击化学奠定了基础，在这种化学中，分子构建块快速而有效地结合在一起。贝尔托西将点击化学带入了一个新的维度，并开始将其应用于生物体中。', '2022-10-05 23:07:57', '中国新闻网');
INSERT INTO `t_news` VALUES ('5', '5', '【#欧佩克与非欧佩克产油国决定11月起日均减产200万桶#】', '5日，石油输出国组织（欧佩克）与非欧佩克产油国第33次部长级会议在奥地利维也纳举行，会议决定从11月起，将原油总产量日均下调200万桶。会议结束后发表的声明指出，鉴于全球经济和石油市场前景的不确定性，以及需要加强对石油市场的长期指导，因此决定从2022年11月起，欧佩克与非欧佩克产油国根据8月要求的产量水平，将总产量日均下调200万桶，并将2020年达成的减产协议延长一年至2023年底。此前，欧佩克与非欧佩克产油国在9月宣布日均增产10万桶，然后又在10月宣布日均减产10万桶，所以8月总产量实际上与10月总产量完全一样。', '2022-10-06 13:44:33', '环球市场播报');
INSERT INTO `t_news` VALUES ('6', '9', '【#埃及考古学家要求大英博物馆归还罗塞塔石碑#】', '#大英博物馆有多少文物是海外掠夺来的# 罗塞塔石碑是大英博物馆的“镇馆之宝”之一，这座石碑上的铭文堪称破解古埃及语言的钥匙，意义非凡。近日，多名埃及考古学家要求大英博物馆归还罗塞塔石碑。', '2022-10-06 13:51:49', '环球时报');
INSERT INTO `t_newstype` VALUES ('1', '娱乐');
INSERT INTO `t_newstype` VALUES ('2', '体育');
INSERT INTO `t_newstype` VALUES ('3', '时事');
INSERT INTO `t_newstype` VALUES ('4', '政治');
INSERT INTO `t_newstype` VALUES ('5', '财经');
INSERT INTO `t_newstype` VALUES ('6', '时尚');
INSERT INTO `t_newstype` VALUES ('7', '教育');
INSERT INTO `t_newstype` VALUES ('8', '军事');
INSERT INTO `t_newstype` VALUES ('9', '历史文化');
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', 'admin', 'admin@qq.com', '15623456791', '湖北武汉', '2022-10-01 14:31:05');
INSERT INTO `t_user` VALUES ('2', 'lily', '123456', '李莉', 'lily@qq.com', '15567891234', '河南洛阳', '2022-10-02 15:58:29');
INSERT INTO `t_user` VALUES ('3', 'zhangsan', '123456', '张三', 'zs@qq.com', '13456789123', '四川成都', '2022-10-02 15:58:40');
INSERT INTO `t_user` VALUES ('4', 'lisi', '123456', '李斯', 'lisi@163.com', '14677967345', '湖北武汉', '2022-10-02 15:58:44');
INSERT INTO `t_user` VALUES ('15', 'abc', '123456', 'abc', 'abc@qq.com', '12435563678', '湖南长沙', '2022-11-02 14:17:53');
INSERT INTO `t_user` VALUES ('16', 'aa', '123456', 'aa', 'admin@qq.com', '15623456791', '湖北武汉', '2022-11-02 14:19:59');
INSERT INTO `t_user` VALUES ('17', 'bb', '123456', 'bb', 'lily@qq.com', '15567891234', '河南洛阳', '2022-11-02 14:19:59');
