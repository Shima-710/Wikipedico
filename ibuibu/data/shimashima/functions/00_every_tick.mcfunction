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
effect give @a[scores={on_game=0}] resistance 1000000 255 true
effect give @a[scores={on_game=0}] saturation 1000000 255 true

# エリトラで飛んだよ検知
execute as @a[scores={fly=1}] run scoreboard players add @s flied 1
execute as @a[scores={fly=1}] run scoreboard players set @s walk 0
execute as @a[scores={flied=1},scores={walk=1}] run clear @s elytra



# -----------------
# ---game system---
#
# 死亡スコア＝1でスペクテイター
execute if entity @a[scores={death=1}] run gamemode spectator