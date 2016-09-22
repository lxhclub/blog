/*
MySQL Data Transfer
Source Host: localhost
Source Database: onlineqa
Target Host: localhost
Target Database: onlineqa
Date: 2016/9/21 18:32:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
CREATE TABLE `admin` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
CREATE TABLE `answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '答案Id',
  `replayId` int(11) NOT NULL COMMENT '回答者Id',
  `oid` int(11) NOT NULL COMMENT '回复主题Id',
  `qSeq` int(11) DEFAULT NULL COMMENT '问题序号',
  `seSeq` int(11) DEFAULT NULL COMMENT '选项序号',
  `seValue` varchar(1000) DEFAULT NULL COMMENT '选项内容',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for object
-- ----------------------------
CREATE TABLE `object` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) DEFAULT NULL,
  `discribe` varchar(1000) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `anonymousFlag` char(1) DEFAULT NULL COMMENT '是否匿名投递',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for question
-- ----------------------------
CREATE TABLE `question` (
  `oid` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `qtype` int(11) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for replay
-- ----------------------------
CREATE TABLE `replay` (
  `replayId` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `replayCode` varchar(100) NOT NULL COMMENT '回复者代码',
  `replayIp` varchar(100) NOT NULL COMMENT '回复者IP',
  `oid` int(11) NOT NULL COMMENT '主题Id',
  `replayTime` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`replayId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='回复内容表';

-- ----------------------------
-- Table structure for selecter
-- ----------------------------
CREATE TABLE `selecter` (
  `oid` int(11) DEFAULT NULL,
  `qseq` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `selseq` int(11) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '232F297A57A5A743894A0E4A801FC3');
INSERT INTO `answer` VALUES ('16', '6', '21', '1', '1', '1', null);
INSERT INTO `answer` VALUES ('17', '6', '21', '2', '2', '2', null);
INSERT INTO `answer` VALUES ('18', '6', '21', '3', '1', '建议1', null);
INSERT INTO `answer` VALUES ('19', '7', '21', '1', '2', '2', null);
INSERT INTO `answer` VALUES ('20', '7', '21', '2', '3', '3', null);
INSERT INTO `answer` VALUES ('21', '7', '21', '3', '1', '建议2', null);
INSERT INTO `answer` VALUES ('22', '8', '22', '1', '3', '3', null);
INSERT INTO `answer` VALUES ('23', '8', '22', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('24', '8', '22', '2', '3', '3', null);
INSERT INTO `answer` VALUES ('25', '8', '22', '3', '3', '3', null);
INSERT INTO `answer` VALUES ('26', '8', '22', '4', '1', '吃，好吃的，如果一直吃下去，我愿意回家找吃的', null);
INSERT INTO `answer` VALUES ('27', '9', '22', '1', '2', '2', null);
INSERT INTO `answer` VALUES ('28', '9', '22', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('29', '9', '22', '2', '3', '3', null);
INSERT INTO `answer` VALUES ('30', '9', '22', '3', '3', '3', null);
INSERT INTO `answer` VALUES ('31', '9', '22', '4', '1', '我要吃的，不说那么多，先给我吃的才有力气', null);
INSERT INTO `answer` VALUES ('32', '10', '23', '1', '2', '2', null);
INSERT INTO `answer` VALUES ('33', '10', '23', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('34', '10', '23', '2', '3', '3', null);
INSERT INTO `answer` VALUES ('35', '10', '23', '3', '5', '5', null);
INSERT INTO `answer` VALUES ('36', '10', '23', '4', '1', '回哈市', null);
INSERT INTO `answer` VALUES ('37', '11', '22', '1', '2', '2', null);
INSERT INTO `answer` VALUES ('38', '11', '22', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('39', '11', '22', '2', '2', '2', null);
INSERT INTO `answer` VALUES ('40', '11', '22', '3', '1', '1', null);
INSERT INTO `answer` VALUES ('41', '11', '22', '4', '1', '吃不行', null);
INSERT INTO `answer` VALUES ('42', '12', '24', '1', '1', '1', null);
INSERT INTO `answer` VALUES ('43', '12', '24', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('44', '12', '24', '2', '2', '2', null);
INSERT INTO `answer` VALUES ('45', '12', '24', '3', '1', '爱无悔和', null);
INSERT INTO `answer` VALUES ('46', '12', '24', '4', '1', '1', null);
INSERT INTO `answer` VALUES ('47', '13', '24', '1', '1', '1', null);
INSERT INTO `answer` VALUES ('48', '13', '24', '2', '2', '2', null);
INSERT INTO `answer` VALUES ('49', '13', '24', '2', '3', '3', null);
INSERT INTO `answer` VALUES ('50', '13', '24', '3', '1', '我想找工作', null);
INSERT INTO `answer` VALUES ('51', '13', '24', '4', '1', '1', null);
INSERT INTO `answer` VALUES ('52', '14', '26', '1', '1', '1', null);
INSERT INTO `answer` VALUES ('53', '14', '26', '2', '1', '靠双方的认可', null);
INSERT INTO `answer` VALUES ('54', '14', '26', '3', '1', '1', null);
INSERT INTO `answer` VALUES ('55', '15', '26', '1', '3', '3', null);
INSERT INTO `answer` VALUES ('56', '15', '26', '2', '1', '双方的努力和互相的支持', null);
INSERT INTO `answer` VALUES ('57', '15', '26', '3', '1', '1', null);
INSERT INTO `answer` VALUES ('58', '15', '26', '4', '1', '是的', null);
INSERT INTO `answer` VALUES ('59', '16', '24', '1', '4', '4', null);
INSERT INTO `answer` VALUES ('60', '16', '24', '2', '2', '2', null);
INSERT INTO `answer` VALUES ('61', '16', '24', '3', '1', '好好努力', null);
INSERT INTO `answer` VALUES ('62', '16', '24', '4', '1', '1', null);
INSERT INTO `answer` VALUES ('63', '17', '23', '1', '3', '3', null);
INSERT INTO `answer` VALUES ('64', '17', '23', '2', '5', '5', null);
INSERT INTO `answer` VALUES ('65', '17', '23', '3', '2', '2', null);
INSERT INTO `answer` VALUES ('66', '17', '23', '4', '1', '多加点窗口', null);
INSERT INTO `answer` VALUES ('67', '18', '22', '1', '3', '3', null);
INSERT INTO `answer` VALUES ('68', '18', '22', '2', '4', '4', null);
INSERT INTO `answer` VALUES ('69', '18', '22', '3', '4', '4', null);
INSERT INTO `answer` VALUES ('70', '18', '22', '4', '1', '民以食为天', null);
INSERT INTO `answer` VALUES ('71', '19', '21', '1', '1', '1', null);
INSERT INTO `answer` VALUES ('72', '19', '21', '2', '1', '1', null);
INSERT INTO `answer` VALUES ('73', '19', '21', '3', '1', '积极向上', null);
INSERT INTO `object` VALUES ('21', '员工思想动态调查问卷', '说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。', '2016-09-21 17:28:55', '1', null, '1');
INSERT INTO `object` VALUES ('22', '关于饮食的调查', '说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。', '2016-09-21 17:44:53', '1', null, '1');
INSERT INTO `object` VALUES ('23', '关于NIIT饮食的调查', '说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。', '2016-09-21 17:45:52', '1', null, '1');
INSERT INTO `object` VALUES ('24', '关于去向', '说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。', '2016-09-21 17:57:51', '1', null, '1');
INSERT INTO `object` VALUES ('26', '关于毕业大学生结婚问题', '说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。', '2016-09-21 18:22:52', '1', null, '1');
INSERT INTO `question` VALUES ('21', '您的姓别', '0', '1', null);
INSERT INTO `question` VALUES ('21', '您的年龄', '0', '2', null);
INSERT INTO `question` VALUES ('21', '建议意见', '3', '3', null);
INSERT INTO `question` VALUES ('22', '你了解的关于吃的城市', '2', '1', null);
INSERT INTO `question` VALUES ('22', '吃在广州', '1', '2', null);
INSERT INTO `question` VALUES ('23', '对于饮食的质量', '0', '1', null);
INSERT INTO `question` VALUES ('22', '写出吃的誓言', '0', '3', null);
INSERT INTO `question` VALUES ('22', '写出吃的文化内涵', '3', '4', null);
INSERT INTO `question` VALUES ('23', '食堂有哪些是你喜欢的食物', '1', '2', null);
INSERT INTO `question` VALUES ('23', '你觉得下列哪个城市比无锡的食物好吃', '2', '3', null);
INSERT INTO `question` VALUES ('24', '去向', '0', '1', null);
INSERT INTO `question` VALUES ('23', '对于食堂得建议', '3', '4', null);
INSERT INTO `question` VALUES ('24', '做什么', '1', '2', null);
INSERT INTO `question` VALUES ('24', '自己的想法', '3', '3', null);
INSERT INTO `question` VALUES ('24', '最后的目标', '2', '4', null);
INSERT INTO `question` VALUES ('26', '你认为毕业应该结婚吗', '0', '1', null);
INSERT INTO `question` VALUES ('26', '你认为毕业结婚靠什么', '3', '2', null);
INSERT INTO `question` VALUES ('26', '你认为毕业没有父母的资助也可以结婚吗', '2', '3', null);
INSERT INTO `question` VALUES ('26', '你认为毕业结婚是对女性的尊重吗', '3', '4', null);
INSERT INTO `replay` VALUES ('6', 'anonymous', '192.168.0.1', '21', '2011-12-05 10:23:24', '');
INSERT INTO `replay` VALUES ('7', 'anonymous', '127.0.0.1', '21', '2011-12-05 10:23:58', '');
INSERT INTO `replay` VALUES ('8', 'anonymous', '0:0:0:0:0:0:0:1', '22', '2016-09-21 17:50:13', '');
INSERT INTO `replay` VALUES ('9', 'anonymous', '192.168.48.73', '22', '2016-09-21 17:54:30', '');
INSERT INTO `replay` VALUES ('10', 'anonymous', '192.168.48.224', '23', '2016-09-21 17:59:37', '');
INSERT INTO `replay` VALUES ('11', 'anonymous', '192.168.48.224', '22', '2016-09-21 17:59:57', '');
INSERT INTO `replay` VALUES ('12', 'anonymous', '192.168.48.73', '24', '2016-09-21 18:05:16', '');
INSERT INTO `replay` VALUES ('13', 'anonymous', '0:0:0:0:0:0:0:1', '24', '2016-09-21 18:16:16', '');
INSERT INTO `replay` VALUES ('14', 'anonymous', '0:0:0:0:0:0:0:1', '26', '2016-09-21 18:26:16', '');
INSERT INTO `replay` VALUES ('15', 'anonymous', '192.168.48.48', '26', '2016-09-21 18:28:02', '');
INSERT INTO `replay` VALUES ('16', 'anonymous', '192.168.48.48', '24', '2016-09-21 18:28:53', '');
INSERT INTO `replay` VALUES ('17', 'anonymous', '192.168.48.48', '23', '2016-09-21 18:29:41', '');
INSERT INTO `replay` VALUES ('18', 'anonymous', '192.168.48.48', '22', '2016-09-21 18:30:08', '');
INSERT INTO `replay` VALUES ('19', 'anonymous', '192.168.48.48', '21', '2016-09-21 18:30:28', '');
INSERT INTO `selecter` VALUES ('21', '1', 'A 男', '1', null);
INSERT INTO `selecter` VALUES ('21', '1', 'B 女', '2', null);
INSERT INTO `selecter` VALUES ('21', '2', 'A 25岁以下', '1', null);
INSERT INTO `selecter` VALUES ('21', '2', 'B 25~30岁', '2', null);
INSERT INTO `selecter` VALUES ('21', '2', 'C 30岁以上', '3', null);
INSERT INTO `selecter` VALUES ('21', '3', '写出您的建议，意见', '0', null);
INSERT INTO `selecter` VALUES ('22', '1', '北京', '1', null);
INSERT INTO `selecter` VALUES ('22', '1', '上海', '2', null);
INSERT INTO `selecter` VALUES ('22', '1', '广州', '3', null);
INSERT INTO `selecter` VALUES ('22', '1', '成都', '4', null);
INSERT INTO `selecter` VALUES ('22', '2', '广州白切鸡', '1', null);
INSERT INTO `selecter` VALUES ('22', '2', '鱼生', '2', null);
INSERT INTO `selecter` VALUES ('22', '2', '纸包鸡', '3', null);
INSERT INTO `selecter` VALUES ('22', '2', '满汉全席', '4', null);
INSERT INTO `selecter` VALUES ('23', '1', '好', '1', null);
INSERT INTO `selecter` VALUES ('23', '1', '坏', '2', null);
INSERT INTO `selecter` VALUES ('23', '1', '中等', '3', null);
INSERT INTO `selecter` VALUES ('22', '3', '天下吃为先', '1', null);
INSERT INTO `selecter` VALUES ('22', '3', '我吃故我在', '2', null);
INSERT INTO `selecter` VALUES ('22', '3', '若为吃得慌，宁缺一头猪', '3', null);
INSERT INTO `selecter` VALUES ('22', '3', '吃遍天下都不怕', '4', null);
INSERT INTO `selecter` VALUES ('22', '4', '吃不完也得吃，为了减肥，吃', '1', null);
INSERT INTO `selecter` VALUES ('23', '2', '西红柿炒蛋', '1', null);
INSERT INTO `selecter` VALUES ('23', '2', '红烧肉', '2', null);
INSERT INTO `selecter` VALUES ('23', '2', '豆角', '3', null);
INSERT INTO `selecter` VALUES ('23', '2', '排骨', '4', null);
INSERT INTO `selecter` VALUES ('23', '2', '回锅肉盖饭', '5', null);
INSERT INTO `selecter` VALUES ('23', '2', '炒番茄', '6', null);
INSERT INTO `selecter` VALUES ('23', '2', '肉包', '7', null);
INSERT INTO `selecter` VALUES ('23', '3', '上海', '1', null);
INSERT INTO `selecter` VALUES ('23', '3', '北京', '2', null);
INSERT INTO `selecter` VALUES ('23', '3', '合肥', '3', null);
INSERT INTO `selecter` VALUES ('23', '3', '四川', '4', null);
INSERT INTO `selecter` VALUES ('23', '3', '广州', '5', null);
INSERT INTO `selecter` VALUES ('23', '3', '福建', '6', null);
INSERT INTO `selecter` VALUES ('23', '3', '山东', '7', null);
INSERT INTO `selecter` VALUES ('23', '3', '海南', '8', null);
INSERT INTO `selecter` VALUES ('24', '1', '北京', '1', null);
INSERT INTO `selecter` VALUES ('24', '1', '上海', '2', null);
INSERT INTO `selecter` VALUES ('24', '1', '淮北', '3', null);
INSERT INTO `selecter` VALUES ('24', '1', '回家', '4', null);
INSERT INTO `selecter` VALUES ('23', '4', '', '1', null);
INSERT INTO `selecter` VALUES ('24', '2', '考验', '1', null);
INSERT INTO `selecter` VALUES ('24', '2', '考公', '2', null);
INSERT INTO `selecter` VALUES ('24', '2', '回家', '3', null);
INSERT INTO `selecter` VALUES ('24', '2', '培训', '4', null);
INSERT INTO `selecter` VALUES ('24', '3', '', '1', null);
INSERT INTO `selecter` VALUES ('24', '4', '房子', '1', null);
INSERT INTO `selecter` VALUES ('24', '4', '车子', '2', null);
INSERT INTO `selecter` VALUES ('24', '4', '美女', '3', null);
INSERT INTO `selecter` VALUES ('26', '1', '应该', '1', null);
INSERT INTO `selecter` VALUES ('26', '1', '不应该', '2', null);
INSERT INTO `selecter` VALUES ('26', '1', '随便', '3', null);
INSERT INTO `selecter` VALUES ('26', '2', '', '1', null);
INSERT INTO `selecter` VALUES ('26', '3', '可以', '1', null);
INSERT INTO `selecter` VALUES ('26', '3', '不可以', '2', null);
INSERT INTO `selecter` VALUES ('26', '3', '差不多', '3', null);
INSERT INTO `selecter` VALUES ('26', '4', '', '1', null);
