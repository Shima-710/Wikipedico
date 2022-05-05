# Wikipedico

-Battle Royale in Minecraft-

About me : https://wikipedico.studio.site

Organizer : [iibukuro](https://twitter.com/_ibukuro_)

Developer : [ShimaShima_710](https://twitter.com/ShimaShima_710)

## Specification

Minecraft Version : Minecraft Java Edition 1.16.4

Supported Server : Spigot 1.16.4, 1.16.5

External Plugins : Skript 2.5.1, skQuery 4.1.4

## File Structure

.sk and .mcfunction files are included in src/main/resource folder.

```
.
└── Ver.5.0/plugin/src/main/resources
	├── datapacks/ibuibu/data/
	|	├── minecraft/tags/functions/	
	|	|	├── load.json				        # ワールドロード時実行
	|	|	└── tick.json				        # 毎tick実行
	|	└── shimashima/functions/
	|		├── wb_range/				    # ワールドボーダー範囲設定用
	|		|	└── *.mcfunction
	|		├── wb_time/				    # ワールドボーダー収縮時間設定用
	|		|	└── *.mcfunction
|		├── 00_every_tick.mcfunction        # 毎チック実行
	|		├── 00_load.mcfunction			    # ロード時実行
	|		├── 01_game_end.mcfunction		    # ゲーム終了時実行
	|		├── 01_game_start.mcfunction		# ゲームスタート時実行
	|		├── 01_goodbye_item.mcfunction		# ゲーム中所持禁止アイテムをクリアー
	|		├── 01_toggle_nametag.mcfunction	# ネームタグの表示非表示
	|		├── 02_admin-book.mcfunction		# admin用の本を渡す
	|		├── 02_murabito.mcfunction		    # 商人召喚用スポーンエッグ
	|		└── boarder_set.mcfunction		    # ワールドボーダーをセット
	├── variables/
	|	└── variables.csv				    #Skript用変数ファイル
	├── scripts/
	|	├── command/				        # 利用ケース別にコマンドファイルが格納
	|	|	├── command_dev.sk			        # 開発用コマンド
	|	|	├── command_gen.sk			        # 一般ユーザー用コマンド
	|	|	└── command_gm.sk			        # ゲームマスター用コマンド
	|	|
	|	├── shop/				            # モード別にショップ用ファイルが格納
	|	|	├── shop_buy.sk				        # 購入内容
	|	|	└── shop_sell.sk			        # 売却内容
	|	|
	|	├── system/				            # 各種システム処理用ファイルが格納
	|	|	├── system_asure.sk			        # アスレチック
	|	|	├── system_daruma.sk			    # だるまさんが転んだ
	|	|	├── system_main.sk			        # メイン
	|	|	└── system_team.sk			        # チーム戦
	|	|	└── system_yukigassen.sk		    # 雪合戦
	|	|
	|	├── config.sk					    # 設定ファイル(内部処理)
	|	├── function.sk					    # 全functionが記述
	|	└── welcome.sk					    # join,quit,loadに関する内容
	|
	├── config.yml						    # wikipedico用configファイル(実働)
	└── plugin.yml						    # プラグイン本体用yaml
```
