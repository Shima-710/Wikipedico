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

# エリトラで飛んだよ検知からの消去
#execute as @a[scores={fly=1..},limit=1] run scoreboard players set @s flied 1
#execute as @a[scores={fly=1..}] run scoreboard players set @s walk 0
#execute as @a[scores={fly=1..}] run scoreboard players set @s fly 0
#execute if entity @a[scores={flied=1}] as @a[scores={flied=1}] run execute if entity @a[scores={walk=1..}] as @a[scores={walk=1..}] run clear @s elytra



# -----------------
# ---game system---
#