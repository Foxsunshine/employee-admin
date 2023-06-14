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
  `image` blob DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Data for table `employees`
--
INSERT INTO
  `employees` (name, email,image)
VALUES
  ('中尾　勇哉', 'kaihatsu.yuya.nakao@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('ジャン　チェン', 'kaihatsu.chien.jan@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('福嶋　ゆか', 'kaihatsu.yuka.fukushima@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('ミン　ピャイ　テイン', 'kaihatsu.min.pyai.tein@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('リク　ハン', 'kaihatsu.han.riku@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('松井　孝典', 'kaihatsu.takanori.matsui@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('藤井　奏多', 'kaihatsu.kanata.fujii@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('及川　勇人', 'kaihatsu.yuto.oikawa@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('飯田　英寛', 'kaihatsu.hidehiro.iida@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('森　政勝', 'kaihatsu.masakatsu.mori@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('中川　祐希', 'kaihatsu.yuki.nakagawa@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg')),
  ('翁長　靖武', 'kaihatsu.yasutake.onaga@gmail.com',LOAD_FILE('/Users/janchen/Downloads/defaultImg.jpeg'));
  -- ('鈴木　一郎', 'ichiro.suzuki@gmail.com'),
--   ('田中　太郎', 'taro.tanaka@gmail.com'),
--   ('山本　二郎', 'jiro.yamamoto@gmail.com'),
--   ('山田　花子', 'hanako.yamada@gmail.com'),
--   ('佐藤　勝', 'katsu.sato@gmail.com'),
--   ('伊藤　健太', 'kenta.ito@gmail.com'),
--   ('渡辺　直人', 'naoto.watanabe@gmail.com'),
--   ('小林　修', 'osamu.kobayashi@gmail.com'),
--   ('加藤　博', 'hiroshi.kato@gmail.com'),
--   ('吉田　紀夫', 'norio.yoshida@gmail.com'),
--   ('中村　義男', 'yoshio.nakamura@gmail.com'),
--   ('木村　裕子', 'hiroko.kimura@gmail.com'),
--   ('林　剛史', 'takeshi.hayashi@gmail.com'),
--   ('清水　健一', 'kenichi.shimizu@gmail.com'),
--   ('山口　勇', 'isamu.yamaguchi@gmail.com'),
--   ('森　広太', 'kota.mori@gmail.com'),
--   ('阿部　信二', 'shinji.abe@gmail.com'),
--   ('松本　敏弘', 'toshihiro.matsumoto@gmail.com'),
--   ('井上　繁', 'shigeru.inoue@gmail.com'),
--   ('高橋　良平', 'ryouhei.takahashi@gmail.com'),
--   ('黒田　和男', 'kazuo.kuroda@gmail.com'),
--   ('石田　光一', 'koichi.ishida@gmail.com'),
--   ('後藤　浩', 'hiroshi.goto@gmail.com'),
--   ('前田　勇次', 'yuji.maeda@gmail.com'),
--   ('岡本　光二', 'koji.okamoto@gmail.com'),
--   ('長谷川　靖', 'yasushi.hasegawa@gmail.com'),
--   ('藤本　武志', 'takeshi.fujimoto@gmail.com'),
--   ('小川　勝', 'katsu.ogawa@gmail.com'),
--   ('高木　隆', 'takashi.takagi@gmail.com'),
--   ('村上　克也', 'katsuya.murakami@gmail.com');