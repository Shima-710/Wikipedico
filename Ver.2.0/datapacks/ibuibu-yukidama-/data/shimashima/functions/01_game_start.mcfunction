# ゲームスタートするよお
#=========================================================================================================================

# ゲーム中に設定
scoreboard players set on_game on_game 1
scoreboard players set @a[team=!admin] play 1

# 参加者のエフェクトをクリアー
effect clear @a

# さよならTPアイテム
clear @a player_head


# タイトル
title @a times 0 40 20
title @a title ["",{"text":"\u22d9 ","bold":true},{"text":"START","bold":true,"color":"yellow"},{"text":" \u22d8","bold":true}]

# エリトラあげりゅ
replaceitem entity @a[team=!admin] armor.chest elytra
# エリトラ落下死防止
effect give @a[team=!admin] resistance 10 255 true

# 参加者のゲームモードを変更
gamemode survival @a[team=!admin,team=!dead]
gamemode spectator @a[team=admin]


# 上空にTP -> 変更
# tp @a -27663 309 36470 ~ 90
fill -27678 252 36485 -27648 254 36455 air destroy


# ワールドボーダーをとりあえず作る
worldborder center -27663 36470
worldborder add 5000000
# んで狭める中心をランダムで決める
schedule function shimashima:boarder_set 15s
# その他設定
worldborder damage amount 0.05
worldborder damage buffer 0
worldborder warning distance 0
worldborder warning time 10

# ibuibu mode
execute if score ibuibumode ibuibumode matches 1 run effect give iibukuro glowing 1000000 255 true