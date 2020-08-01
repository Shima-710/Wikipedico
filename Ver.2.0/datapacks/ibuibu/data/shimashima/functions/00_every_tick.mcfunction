#毎tick実行するよ君
#=========================================================================================================================

# ---------------
# ---for admin---
#
# スペクテイターのadminに暗視付与
effect give @a[team=admin,gamemode=spectator] night_vision 1000000 255 true


# ----------------
# ---for player---
#
# ロビー状態では耐性・満腹度回復を付与
execute if score on_game on_game matches 0 run effect give @a resistance 1000000 255 true
execute if score on_game on_game matches 0 run effect give @a saturation 1000000 255 true
execute if score on_game on_game matches 0 run effect give @a night_vision 1000000 255 true

# エリトラで飛んだよ検知からの消去
#execute as @a[scores={fly=1..},limit=1] run scoreboard players set @s flied 1
#execute as @a[scores={fly=1..}] run scoreboard players set @s walk 0
#execute as @a[scores={fly=1..}] run scoreboard players set @s fly 0
#execute if entity @a[scores={flied=1}] as @a[scores={flied=1}] run execute if entity @a[scores={walk=1..}] as @a[scores={walk=1..}] run clear @s elytra

# 雪玉爆弾
#scoreboard players add @a[scores={sb=1..9}] sb 1
#scoreboard players set @a[scores={sb=10}] sb 0
#tag @a[nbt={SelectedItem:{id:"minecraft:snowball"}}] add usesb
#execute if entity @a[tag=usesb] run function shimashima:snowball-1

# いぶいぶブックは渡さねえ！
execute if score on_game on_game matches 1 run clear @a[team=!admin] written_book



# -----------------
# ---charas---
#

# ninja
effect give @a[tag=ninja] jump_boost 1000000 3 true
effect give @a[tag=ninja] speed 1000000 3 true

# gorilla
effect give @a[tag=gorilla] slowness 1000000 1 true
effect give @a[tag=gorilla] health_boost 1000000 10 true
effect give @a[tag=gorilla] hunger 1000000 1 true

# healer
effect give @a[tag=healer] resistance 1000000 2 true
effect give @a[tag=healer] regeneration 1000000 3 true

# neet
#effect give @a[tag=neet] resistance 1000000 -3 true
#effect give @a[tag=neet] speed 1000000 -3 true

# tyuuni-before
#effect give @a[tag=tyuuni-bef] resistance 1000000 -3 true
#effect give @a[tag=tyuuni-bef] resistance 1000000 -3 true

# tyuuni-after
effect give @a[tag=tyuuni-aft] speed 1000000 3 true
effect give @a[tag=tyuuni-aft] resistance 1000000 3 true
effect give @a[tag=tyuuni-aft] health_boost 1000000 20 true
effect give @a[tag=tyuuni-aft] strength 1000000 3 true

# tank
effect give @a[tag=tank] resistance 1000000 3 true
effect give @a[tag=tank] health_boost 1000000 100 true
effect give @a[tag=tank] slowness 1000000 3 true

# robot
effect give @a[tag=robot] strength 1000000 2 true
effect give @a[tag=robot] resistance 1000000 2 true
effect give @a[tag=robot] slowness 1000000 2 true