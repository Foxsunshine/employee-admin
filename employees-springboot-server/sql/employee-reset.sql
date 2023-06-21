/* CREATE DATABASE  IF NOT EXISTS `employee_directory`; */
USE `aiful`;

--
-- Table structure for table `employees`
--
DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Data for table `employees`
--
INSERT INTO
  `employees` (name, email,image)
VALUES
('鈴木　一郎', 'ichiro.suzuki@gmail.com','1.jpeg'),
  ('田中　太郎', 'taro.tanaka@gmail.com','2.jpeg'),
  ('山本　二郎', 'jiro.yamamoto@gmail.com','3.jpeg'),
  ('山田　花子', 'hanako.yamada@gmail.com','4.jpeg'),
  ('佐藤　勝', 'katsu.sato@gmail.com','5.jpeg'),
  ('伊藤　健太', 'kenta.ito@gmail.com','6.jpeg'),
  ('渡辺　直人', 'naoto.watanabe@gmail.com','7.jpeg'),
  ('小林　修', 'osamu.kobayashi@gmail.com','8.jpeg'),
  ('加藤　博', 'hiroshi.kato@gmail.com','9.jpeg'),
  ('吉田　紀夫', 'norio.yoshida@gmail.com','10.jpeg'),
  ('中村　義男', 'yoshio.nakamura@gmail.com','11.jpeg'),
  ('木村　裕子', 'hiroko.kimura@gmail.com','1.jpeg'),
  ('林　剛史', 'takeshi.hayashi@gmail.com','2.jpeg'),
  ('清水　健一', 'kenichi.shimizu@gmail.com','3.jpeg'),
  ('山口　勇', 'isamu.yamaguchi@gmail.com','4.jpeg'),
  ('森　広太', 'kota.mori@gmail.com','5.jpeg'),
  ('阿部　信二', 'shinji.abe@gmail.com','6.jpeg'),
    ('松本　敏弘', 'toshihiro.matsumoto@gmail.com','7.jpeg'),
  ('井上　繁', 'shigeru.inoue@gmail.com','8.jpeg'),
  ('高橋　良平', 'ryouhei.takahashi@gmail.com','9.jpeg'),
  ('黒田　和男', 'kazuo.kuroda@gmail.com','10.jpeg'),
  ('石田　光一', 'koichi.ishida@gmail.com','11.jpeg'),
  ('後藤　浩', 'hiroshi.goto@gmail.com','1.jpeg'),
  ('前田　勇次', 'yuji.maeda@gmail.com','2.jpeg'),
    ('松本　敏弘', 'toshihiro.matsumoto@gmail.com','7.jpeg'),
  ('井上　繁', 'shigeru.inoue@gmail.com','8.jpeg'),
  ('高橋　良平', 'ryouhei.takahashi@gmail.com','9.jpeg'),
  ('黒田　和男', 'kazuo.kuroda@gmail.com','10.jpeg'),
  ('石田　光一', 'koichi.ishida@gmail.com','11.jpeg'),
  ('後藤　浩', 'hiroshi.goto@gmail.com','1.jpeg'),
  ('前田　勇次', 'yuji.maeda@gmail.com','2.jpeg'),
    ('松本　敏弘', 'toshihiro.matsumoto@gmail.com','7.jpeg'),
  ('井上　繁', 'shigeru.inoue@gmail.com','8.jpeg'),
  ('高橋　良平', 'ryouhei.takahashi@gmail.com','9.jpeg'),
  ('黒田　和男', 'kazuo.kuroda@gmail.com','10.jpeg'),
  ('石田　光一', 'koichi.ishida@gmail.com','11.jpeg'),
  ('後藤　浩', 'hiroshi.goto@gmail.com','1.jpeg'),
  ('前田　勇次', 'yuji.maeda@gmail.com','2.jpeg'),
  ('松本　敏弘', 'toshihiro.matsumoto@gmail.com','7.jpeg'),
  ('井上　繁', 'shigeru.inoue@gmail.com','8.jpeg'),
  ('高橋　良平', 'ryouhei.takahashi@gmail.com','9.jpeg'),
  ('黒田　和男', 'kazuo.kuroda@gmail.com','10.jpeg'),
  ('石田　光一', 'koichi.ishida@gmail.com','11.jpeg'),
  ('後藤　浩', 'hiroshi.goto@gmail.com','1.jpeg'),
  ('前田　勇次', 'yuji.maeda@gmail.com','2.jpeg'),
  ('岡本　光二', 'koji.okamoto@gmail.com','3.jpeg'),
  ('長谷川　靖', 'yasushi.hasegawa@gmail.com','4.jpeg'),
  ('藤本　武志', 'takeshi.fujimoto@gmail.com','5.jpeg'),
  ('小川　勝', 'katsu.ogawa@gmail.com','6.jpeg'),
  ('高木　隆', 'takashi.takagi@gmail.com','7.jpeg'),
  ('村上　克也', 'katsuya.murakami@gmail.com','8.jpeg');