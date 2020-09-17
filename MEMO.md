# Wikipedico 開発メモ

等幅環境で見ないと見栄えが死にます

技術仕様はREADME記載


## ファイル構造
GitHub Repository - [Wikipedico](https://github.com/Shima-710/Wikipedico)

```
.
├── .git/
├── .gitignore
├── LICENSE
├── README.md
├── HIKITUGI.md
└── Ver.3.0/
		├── datapacks/
		|	├── bukkit/pack.mcmeta
		|	└── ibuibu/
		|		├── data/
		|		|	├── minecraft/*								# 以下略,デフォルトの進捗及びレシピは無効化済み
		|		|	└── shimashima/
		|		|		├── functions/
		|		|		|	├── wb_range/*						# ワールドボーダー範囲設定用
		|		|		|	├── wb_time/*						# ワールドボーダー収縮時間設定用
		|		|		|	├── 00_every_tick.mcfunction		# 毎チック実行
		|		|		|	├── 00_load.mcfunction				# ロード時実行
		|		|		|	├── 01_game_end.mcfunction			# ゲーム終了時実行
		|		|		|	├── 01_game_start.mcfunction		# ゲームスタート時実行
		|		|		|	├── 01_goodbye_item.mcfunction		# ゲーム中所持禁止アイテムをクリアー
		|		|		|	├── 01_replay.mcfunction			# 未使用
		|		|		|	├── 01_toggle_nametag.mcfunction	# ネームタグの表示非表示
		|		|		|	├── 02_admin-book.mcfunction		# admin用の本を渡す
		|		|		|	├── 02_murabito.mcfunction			# 商人召喚用スポーンエッグ
		|		|		|	└── boarder_set.mcfunction			# ワールドボーダーをセット
		|		|		|
		|		|		└── recipes/
		|		|			└── revival.json					# 復活の石レシピ
		|		|
		|		└── pack.mcmeta
		|
		└── scripts/
			├── charas/											# キャラクターごとのファイルが格納
			|	├── chara_gorilla.sk							# ゴリラ
			|	├── chara_healer.sk								# ヒーラー
			|	├── chara_neet.sk								# ニート
			|	├── chara_ninja.sk								# 忍者
			|	├── chara_robot.sk								# ロボット
			|	├── chara_tank.sk								# タンク
			|	└── chara_tyuuni.sk								# 厨二病
			|
			├── command/										# 利用ケース別にコマンドファイルが格納
			|	├── command_dev.sk								# 開発用コマンド
			|	├── command_gen.sk								# 一般ユーザー用コマンド
			|	└── command_gm.sk								# ゲームマスター用コマンド
			|
			├── shop/											# モード別にショップ用ファイルが格納
			|	├── _leg/										# 過去ファイル/バックアップ
			|	├── shop_buy.sk									# 購入内容
			|	├── shop_item_chara.sk							# キャラ有効時に購入可能
			|	├── shop_sell.sk								# 売却内容
			|	└── shop_skill.sk								# キャラ有効時レベルアップ用
			|
			├── system/											# 各種システム処理用ファイルが格納
			|	├── system_actionbar.sk							# アクションバー
			|	├── system_asure.sk								# アスレチック
			|	├── system_daruma.sk							# だるまさんが転んだ
			|	├── system_main.sk								# メイン
			|	├── system_revival.sk							# 復活
			|	└── system_skill.sk								# キャラ選択
			|
			├── config.sk										# 設定ファイル
			├── function.sk										# 全functionが記述
			└── welcome.sk										# join,quit,loadに関する内容
```


## 導入
1. Skript. skQuaryを導入
2. Ver.3.0/datapacksをworld/datapacksと入れ替え
3. Ver.3.0/scriptsをplugins_Skript_scriptsと入れ替え
4. “/natto—defineloca”で各種ロケーション変数を指定
5. 00_game_start.mcfunctionの36行目の座標を上空待機所の座標に書き換え

## 始め方
1. adminで進行する場合は”/admin”
2. モード選択
3. “_start”コマンドまたは本(_book)でゲームスタート
4. 強制終了は”/end”
5. 次の試合に移る場合はリロード

## ゲームモード
### 同時稼働可能
* だるまさんが転んだモード

	/mode daruma

* キャラクター

	/mode skill

* チーム戦

	/mode team

* いぶいぶ

	/mode ibuibu

### 同時稼働不可
* 弓のみ

	/mode yumi

* 雪玉のみ

	/mode yukidama

## コマンド
一般ユーザーコマンドについてはwiki参照

* start

	ゲームを開始

* end

	ゲームを終了

* joincount

	同接・累接人数を表示

* admin [<join/leave>]  [<player>]

	指定プレイヤーをadminに(adminのみで省略可能)

* join <team> [<player>]

	むりくりプレイヤーをチームに入れる(バグるかも)

* chara <choise/look> [<player>]

	choiseで…ってかずっとchoiceのスペルミスってね？
	choiceでキャラ選択、lookで各チームのキャラを確認

* revival

	運営特権で指定プレイヤーを復活
	ただし該当者の所属チームが全滅している場合はバグる

* destroyable [<true/false>]

	破壊の可否を設定

* anntirange <範囲> <速度>

	ボーダーの現在の範囲を指定
	速度の指定は必須

* anntispeed <速度>

	ボーダーの収集速度の変更

* book

	admin用の本がもらえる

* murabito

	商人用スポーンエッグがもらえる

* emerald <個数>

	指定個数分のエメラルドがもらえる
	デバッグ用

* lobby

	ロビーにTPできる
	デバッグ用

* mode

	(略)