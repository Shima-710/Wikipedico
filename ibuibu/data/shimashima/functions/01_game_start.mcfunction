# ゲームスタートするよお
#=========================================================================================================================


# ゲーム中に設定
scoreboard players set on_game on_game 1

# 参加者のエフェクトをクリアー
effect clear @a

# 参加者のゲームモードを変更
gamemode survival @a[team=!admin]

# 上空にTP
tp @a 


# エリトラあげりゅ
replaceitem entity @a[team=!admin] armor.chest elytra


# ワールドボーダーをとりあえず作る
worldborder center ~ ~ 
worldborder add 500
worldborder set 500
# 中心決定用のアマスタ召喚
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-1"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-2"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-3"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-4"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-5"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-6"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-7"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-8"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-9"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-10"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-11"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-12"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-13"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-14"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-15"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-16"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-17"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-18"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-19"]}
summon armor_stand ~ ~ ~ {Team:"spread",Marker:1b,Invisible:1b,Tags:["arm-20"]}
# そのアマスタを散らばせる
spreadplayers ~ ~ 10 100 false @e[type=armor_stand,team=spread]
# んで狭める中心をランダムで決める
execute at @r[team=spread,limit=1] as @r[team=spread,limit=1] run worldborder center ~ ~ 
# いざ狭める
worldborder set 1 900
# その他設定
worldborder damage amount 0.1
worldborder damage buffer 0
worldborder warning distance 0
worldborder warning time 10