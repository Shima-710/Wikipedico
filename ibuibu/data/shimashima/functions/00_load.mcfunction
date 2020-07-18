#minecraft/tags/functions/loadに書く用
#データパックが読み込まれた時に一度だけ実行
#=========================================================================================================================
#=========================================================================================================================


#=========================================================================================================================
#ゲームルール設定

    #コマンドブロックの実行結果出力無効
        gamerule commandBlockOutput false
    #モブの自然湧き無効
        gamerule doMobSpawning false
    #延焼の無効
        gamerule doFireTick false
    #モブによる破壊・アイテム取得の無効化
        gamerule mobGriefing false
    #ランダムチックスピード＜設定値：０＝成長はしない＞
        gamerule randomTickSpeed 0
    #デバッグ情報の簡素化
        gamerule reducedDebugInfo true
    #手打ちコマンド実行結果表示の無効
        gamerule sendCommandFeedback false
    #初期スポーン範囲の設定＜設定値：１＞
        gamerule spawnRadius 1
    #デスメオフ
        gamerule showDeathMessages false
    #時刻の固定・設定＜設定値：6000(太陽がほぼ真上)＞
        gamerule doDaylightCycle false
        time set 6000
    #天気の固定・設定＜設定値：晴れ＞
        gamerule doWeatherCycle false
        weather clear

    #難易度
        difficulty hard


#=========================================================================================================================
#チームの追加・編集

# Admin
    team add admin
    team modify admin nametagVisibility always
    team modify adimn color dark_red

# A
    team add A
    team modify A color red

# B
    team add B
    team modify B color blue

# C
    team add C
    team modify C color yellow

# D
    team add D
    team modify D color green

# E
    team add E
    team modify E color black

# spread
    team add spread

# players
    team add players
    team modify players nametagVisibility always
    team modify players collisionRule never

#=========================================================================================================================
#スコアボードの追加

# ゲーム中/外を判定(ゲーム中＝1/ゲーム外＝0｜初期値0)
    scoreboard objectives add on_game dummy
    scoreboard players set on_game on_game 0

# プレイヤーの参加/非参加を判定(参加＝1/非参加＝0｜初期値0)
    scoreboard objectives add play dummy
    scoreboard players set @a play 0

# 死亡判定(死亡＝1/生存＝0｜初期値0)
    scoreboard objectives add death deathCount
    scoreboard players set @a death 0

# エリトラ使用検知
    scoreboard objectives add fly custom:aviate_one_cm
    scoreboard objectives add flied dummy

# エリトラ使用後に歩いたこと検知
    scoreboard objectives add walk custom:walk_one_cm

# ワールドボーダーの範囲決定用のスコアぼ
    scoreboard objectives add wb_range dummy
    scoreboard players set wb_range wb_range 0

# ワールドボーダーの時間用のスコアぼ
    scoreboard objectives add wb_time dummy
    scoreboard players set wb_time wb_time 0

# ibuibu mode
    scoreboard objectives add ibuibumode dummy
    scoreboard players set ibuibumode ibuibumode 0

# 雪玉爆弾
    scoreboard objectives add sb used:snowball
    scoreboard players set @a sb 0

# なんかリストに表示されよるからぐっばい
    scoreboard objectives setdisplay list


#=========================================================================================================================
#