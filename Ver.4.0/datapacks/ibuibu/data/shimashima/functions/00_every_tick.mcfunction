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


execute if score on_game on_game matches 1 run effect give @a hunger 1000000 1 true

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

# ninja-1
effect give @a[tag=ninja-1] jump_boost 1000000 0 true
effect give @a[tag=ninja-1] speed 1000000 1 true

# ninja-2
effect give @a[tag=ninja-2] jump_boost 1000000 1 true
effect give @a[tag=ninja-2] speed 1000000 2 true

# ninja-3
effect give @a[tag=ninja-3] jump_boost 1000000 2 true
effect give @a[tag=ninja-3] speed 1000000 3 true


# gorilla-1
effect give @a[tag=gorilla-1] slowness 1000000 0 true
effect give @a[tag=gorilla-1] hunger 1000000 1 true

# gorilla-2
effect give @a[tag=gorilla-2] slowness 1000000 0 true
effect give @a[tag=gorilla-2] hunger 1000000 1 true

# gorilla-3
effect give @a[tag=gorilla-3] slowness 1000000 0 true
effect give @a[tag=gorilla-3] hunger 1000000 1 true


# healer-1
effect give @a[tag=healer-1] resistance 1000000 2 true
effect give @a[tag=healer-1] regeneration 1000000 3 true

# healer-2
effect give @a[tag=healer-2] resistance 1000000 2 true
effect give @a[tag=healer-2] regeneration 1000000 3 true

# healer-3
effect give @a[tag=healer-3] resistance 1000000 2 true
effect give @a[tag=healer-3] regeneration 1000000 3 true
effect give @a[tag=healer-3] speed 1000000 0 true

# neet-1
effect give @a[tag=neet-1] slowness 1000000 1 true

# neet-2
effect give @a[tag=neet-1] slowness 1000000 1 true

# neet-3
effect give @a[tag=neet-3] speed 1000000 1 true


# tyuuni-before
effect give @a[tag=tyuuni-bef] slowness 1000000 0 true

# tyuuni-after
effect give @a[tag=tyuuni-aft] speed 1000000 2 true
effect give @a[tag=tyuuni-aft] resistance 1000000 3 true
effect give @a[tag=tyuuni-aft] strength 1000000 3 true

# tank-1
effect give @a[tag=tank-1] resistance 1000000 3 true
effect give @a[tag=tank-1] slowness 1000000 0 true

# tank-2
effect give @a[tag=tank-2] resistance 1000000 3 true
effect give @a[tag=tank-2] slowness 1000000 0 true

# tank-3
effect give @a[tag=tank-3] resistance 1000000 3 true
effect give @a[tag=tank-3] slowness 1000000 0 true


# robot-1
effect give @a[tag=robot-1] strength 1000000 2 true
effect give @a[tag=robot-1] resistance 1000000 2 true

# robot-2
effect give @a[tag=robot-2] strength 1000000 2 true
effect give @a[tag=robot-2] resistance 1000000 2 true

# robot-3
effect give @a[tag=robot-3] strength 1000000 2 true
effect give @a[tag=robot-3] resistance 1000000 2 true