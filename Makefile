JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR = src
BINDIR = bin
OUTDIR = output
AVLOUTDIR = AVLoutput
BSTOUTDIR = BSToutput
$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Loadshedding.class BinaryTreeNode.class BinaryTree.class BinarySearchTree.class AVLTree.class LSAVLTApp.class\
	LSBSTApp.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
	rm $(AVLOUTDIR)/*.xls
	rm $(BSTOUTDIR)/*.xls
	rm $(OUTDIR)/*.txt
	$(RM) -r doc/*

javadoc:
	javadoc -d doc/ src/*.java


runpart2:
	java -cp bin LSAVLTApp 6 29 02 > $(OUTDIR)/output.part2.known1.txt
	java -cp bin LSAVLTApp 6 9 04 > $(OUTDIR)/output.part2.known2.txt
	java -cp bin LSAVLTApp 1 2 00 > $(OUTDIR)/output.part2.known3.txt

	java -cp bin LSAVLTApp 6 33 02 > $(OUTDIR)/output.part2.invalid1.txt
	java -cp bin LSAVLTApp 1 2 39 > $(OUTDIR)/output.part2.invalid2.txt
	java -cp bin LSAVLTApp 66 9 02 > $(OUTDIR)/output.part2.invalid3.txt

	java -cp bin LSAVLTApp > $(OUTDIR)/output.part1.printallareas.txt

runpart4:
	java -cp bin LSBSTApp 6 29 02 > $(OUTDIR)/output.part4.known1.txt
	java -cp bin LSBSTApp 6 9 04 > $(OUTDIR)/output.part4.known2.txt
	java -cp bin LSBSTApp 1 2 00 > $(OUTDIR)/output.part4.known3.txt

	java -cp bin LSBSTApp 6 33 02 > $(OUTDIR)/output.part4.invalid1.txt
	java -cp bin LSBSTApp 1 2 39 > $(OUTDIR)/output.part4.invalid2.txt
	java -cp bin LSBSTApp 66 9 02 > $(OUTDIR)/output.part4.invalid3.txt

	java -cp bin LSBSTApp > $(OUTDIR)/output.part3.printallareas.txt

randomise:
	sh Scripts/command.sh

runpart5:
	sh Scripts/commands2.sh
