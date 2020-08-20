# ネームタグ操作
#=========================================================================================================================

# さよなら
execute if score on_game on_game matches 1 run team modify admin nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify red nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify blue nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify yellow nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify green nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify orange nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify purple nametagVisibility hideForOtherTeams
execute if score on_game on_game matches 1 run team modify gray nametagVisibility hideForOtherTeams

execute if score on_game on_game matches 1 run scoreboard objectives setdisplay belowName health

# おかえり
execute if score on_game on_game matches 0 run team modify admin nametagVisibility always
execute if score on_game on_game matches 0 run team modify red nametagVisibility always
execute if score on_game on_game matches 0 run team modify blue nametagVisibility always
execute if score on_game on_game matches 0 run team modify yellow nametagVisibility always
execute if score on_game on_game matches 0 run team modify green nametagVisibility always
execute if score on_game on_game matches 0 run team modify orange nametagVisibility always
execute if score on_game on_game matches 0 run team modify purple nametagVisibility always
execute if score on_game on_game matches 0 run team modify gray nametagVisibility always

execute if score on_game on_game matches 0 run scoreboard objectives setdisplay belowName