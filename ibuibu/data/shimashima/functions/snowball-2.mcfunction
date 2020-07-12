#雪玉用-2
#=========================================================================================================================

tag @a[nbt=!{SelectedItem:{id:"minecraft:snowball"}}] remove usesb

execute at @e[tag=imsb,limit=1] if entity @a[scores={sb=0},distance=..2] run summon tnt ~ ~ ~ 