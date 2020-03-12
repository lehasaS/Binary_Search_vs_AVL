for n in $(seq 298  297  2976)
do
    java -cp bin LSAVLTApp LoadShedding.rand.n$n.txt > AVLoutput/output.part5.arr.n$n.xls
    java -cp bin LSBSTApp LoadShedding.rand.n$n.txt > BSToutput/output.part5.bst.n$n.xls 
done
