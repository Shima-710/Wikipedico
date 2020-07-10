# 中心ランダム
#=========================================================================================================================

# いざ狭める
execute at @r[team=!admin,limit=1] run worldborder center ~ ~ 

# 範囲
worldborder set 500
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
worldborder set 1 900
execute if score wb_time wb_time matches 100 run worldborder set 1 100
execute if score wb_time wb_time matches 200 run worldborder set 1 200
execute if score wb_time wb_time matches 300 run worldborder set 1 300
execute if score wb_time wb_time matches 400 run worldborder set 1 400
execute if score wb_time wb_time matches 500 run worldborder set 1 500
execute if score wb_time wb_time matches 600 run worldborder set 1 600
execute if score wb_time wb_time matches 700 run worldborder set 1 700
execute if score wb_time wb_time matches 800 run worldborder set 1 800
execute if score wb_time wb_time matches 900 run worldborder set 1 900
execute if score wb_time wb_time matches 1000 run worldborder set 1 1000