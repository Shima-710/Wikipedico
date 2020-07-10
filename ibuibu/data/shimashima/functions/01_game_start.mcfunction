# ゲームスタートするよお
#=========================================================================================================================


# ゲーム中に設定
scoreboard players set on_game on_game 1

# 参加者のエフェクトをクリアー
effect clear @a[team=!admin]

# 参加者のゲームモードを変更
gamemode survival @a[team=!admin]

# 上空にTP
tp @a 


# エリトラあげりゅ
replaceitem entity @a[team=!admin] armor.chest elytra