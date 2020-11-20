#毎tick実行するよ君
#=========================================================================================================================

# スペクテイターのadminに暗視付与
effect give @a[team=admin,gamemode=spectator] night_vision 1000000 255 true

# ロビー状態では耐性・満腹度回復を付与
execute if score on_game on_game matches 0 run effect give @a resistance 1000000 255 true
execute if score on_game on_game matches 0 run effect give @a saturation 1000000 255 true
execute if score on_game on_game matches 0 run effect give @a night_vision 1000000 255 true

# ゲーム中は空腹を付与
execute if score on_game on_game matches 1 run effect give @a hunger 1000000 1 true

# いぶいぶブックは渡さねえ！
execute if score on_game on_game matches 1 run clear @a[team=!admin] written_book


