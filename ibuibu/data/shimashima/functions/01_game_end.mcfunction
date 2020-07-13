# ゲーム終了用
#=========================================================================================================================

# ゲーム外へ移動
scoreboard players set on_game on_game 0

# ワールドボーダー拡大
worldborder set 50000

# タイトル
title @a times 0 100 20
title @a title ["",{"text":"\u52dd\u8005\uff1a","color":"yellow"},{"selector":"@a[gamemode=survival]","color":"gold"},{"text":"\uff01","color":"gold"}]

# そいつ光らすか
effect give @a[gamemode=survival] glowing 20 255 true

# 進捗あげりゅ

# ロビー戻ります
schedule function shimashima:go_lobby 5s