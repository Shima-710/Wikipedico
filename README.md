# Wikipedico
```
Latest Update : 11/12/2020 | Written by ShimaShima_710
```
## Overview

 **Wikipedico**
-Battle Royale in Minecraft-

About project and rules : [Official Site](https://wikipedico.studio.site)

Organizer : [iibukuro](https://twitter.com/_ibukuro_)

Developer : [ShimaShima_710](https://twitter.com/ShimaShima_710)

## Specification

Minecraft Version : Minecraft Java Edition 1.16.4

Supported Server : Spigot-1.16.4

External Plugins : Skript 2.5.1, skQuery 4.1.4

## Dev. Environment
OS : macOS 11.0.1 Big Sur

Language : Java, Skript, mcfunction

Project Management : Apache Maven

## File Structure

.sk and .mcfunction files are included in resource folder.

```
.
└── Ver.5.0/plugin/src/main/resources
	├── datapacks/ibuibu/data/
	|	├── minecraft/tags/functions/	
	|	|	├── load.json				# ワールドロード時実行
	|	|	└── tick.json				# 毎tick実行
	|	└── shimashima/functions/
	|		├── wb_range/				# ワールドボーダー範囲設定用
	|		|	└── *.mcfunction
	|		├── wb_time/				# ワールドボーダー収縮時間設定用
	|		|	└── *.mcfunction
	|		├── 00_every_tick.mcfunction		# 毎チック実行
	|		├── 00_load.mcfunction			# ロード時実行
	|		├── 01_game_end.mcfunction		# ゲーム終了時実行
	|		├── 01_game_start.mcfunction		# ゲームスタート時実行
	|		├── 01_goodbye_item.mcfunction		# ゲーム中所持禁止アイテムをクリアー
	|		├── 01_toggle_nametag.mcfunction	# ネームタグの表示非表示
	|		├── 02_admin-book.mcfunction		# admin用の本を渡す
	|		├── 02_murabito.mcfunction		# 商人召喚用スポーンエッグ
	|		└── boarder_set.mcfunction		# ワールドボーダーをセット
	├── variables/
	|	└── variables.csv				#Skript用変数ファイル
	└── scripts/
		├── command/				# 利用ケース別にコマンドファイルが格納
		|	├── command_dev.sk			# 開発用コマンド
		|	├── command_gen.sk			# 一般ユーザー用コマンド
		|	└── command_gm.sk			# ゲームマスター用コマンド
		|
		├── shop/				# モード別にショップ用ファイルが格納
		|	├── shop_buy.sk				# 購入内容
		|	└── shop_sell.sk			# 売却内容
		|
		├── system/				# 各種システム処理用ファイルが格納
		|	├── system_asure.sk			# アスレチック
		|	├── system_daruma.sk			# だるまさんが転んだ
		|	├── system_main.sk			# メイン
		|	└── system_team.sk			# チーム戦
		|	└── system_yukigassen.sk		# 雪合戦
		|
		├── config.sk					# 設定ファイル
		├── function.sk					# 全functionが記述
		└── welcome.sk					# join,quit,loadに関する内容
```


## 導入
1. Wikipedico,Skript,skQuaryを導入
2. コンソール,またはクライアントで "/install" を実行
3. クライアントで “/natto—defineloca” を実行（各種ロケーション変数を設定）
4. ファイル内の #TODO: を確認,変更（主にマップ依存座標）
5. "/reload"

## 始め方
1. adminで進行する場合は ”/admin”
2. モード選択
3. “/start” コマンド,または本でゲームスタート
4. 強制終了は ”/end”
5. 2戦目以降は前回試合終了時に自動リロードが入るのでそのまま何もせずに "/start"

## ゲームモード
* だるまさんが転んだモード

	だるまさんが転んだができるモード

	```
	/mode daruma
	```

* チーム戦

	チーム対抗戦ができるモード

	```
	/mode team
	```

* いぶいぶ

	いぶいぶモード

	```
	/mode ibuibu
	```

## コマンド
一般ユーザーコマンドについてはwiki参照

* start

	ゲームを開始

* end

	ゲームを終了

* joincount

	同接・累接人数を表示

* admin [\<join/leave>]  [\<player>]

	指定プレイヤーをadminに(adminのみで省略可能)

* join \<team> [\<player>]

	むりくりプレイヤーをチームに入れる

* revival

	運営特権で指定プレイヤーを復活
	ただし該当者の所属チームが全滅している場合はバグる

* destroyable [\<true/false>]

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
