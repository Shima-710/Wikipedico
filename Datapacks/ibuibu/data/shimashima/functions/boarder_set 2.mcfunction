# 中心ランダム
#=========================================================================================================================

# いざ狭める
execute at @r[team=!admin,limit=1,scores={play=1}] run worldborder center ~ ~ 
tellraw @a ["",{"text":"[\u904b\u55b6] ","color":"aqua"},{"text":"\u5883\u754c\u306e\u53ce\u7e2e\u304c\u59cb\u307e\u308a\u307e\u3057\u305f","color":"white"}]
playsound block.note_block.basedrum master @a ~ ~ ~ 

# 範囲
worldborder set 1000
execute if score wb_range wb_range matches 100 run worldborder set 100
execute if score wb_range wb_range matches 200 run worldborder set 200
execute if score wb_range wb_range matches 300 run worldborder set 300
execute if score wb_range wb_range matches 400 run worldborder set 400
execute if score wb_range wb_range matches 500 run worldborder set 500
execute if score wb_range wb_range matches 600 run worldborder set 600
execute if score wb_range wb_range matches 700 run worldborder set 700
execute if score wb_range wb_range matches 800 run worldborder set 800
execute if score wb_range wb_range matches 900 run worldborder set 900
execute if score wb_range wb_range matches 1000 run worldborder set 1000

# 縮小開始
worldborder set 10 500
execute if score wb_time wb_time matches 100 run worldborder set 10 100
execute if score wb_time wb_time matches 200 run worldborder set 10 200
execute if score wb_time wb_time matches 300 run worldborder set 10 300
execute if score wb_time wb_time matches 400 run worldborder set 10 400
execute if score wb_time wb_time matches 500 run worldborder set 10 500
execute if score wb_time wb_time matches 600 run worldborder set 10 600
execute if score wb_time wb_time matches 700 run worldborder set 10 700
execute if score wb_time wb_time matches 800 run worldborder set 10 800
execute if score wb_time wb_time matches 900 run worldborder set 10 900
execute if score wb_time wb_time matches 1000 run worldborder set 10 1000