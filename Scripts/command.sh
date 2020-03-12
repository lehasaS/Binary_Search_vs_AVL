for n in $(seq 298  297  2976)
do
	shuf <../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt | head -$n > ../data/LoadShedding.rand.n$n.txt
done
