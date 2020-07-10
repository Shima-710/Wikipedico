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
effect give @a[scores={play=0}] resistance 1000000 255 true
effect give @a[scores={play=0}] absorption 1000000 255 true



# -----------------
# ---game system---
#
# 死亡スコア＝1でスペクテイター
execute if entity @a[scores={death=1}] run gamemode spectator