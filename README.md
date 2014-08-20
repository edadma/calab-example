Using CALab with your own Cellular Automata
===========================================

This repository shows how to setup a class of cellular automata not currently included in CALab.  CALab was actually started for the purpose of making it easy to explore new classes of cellular automata in a convenient way, which is why it only has a couple of CA classes included.  This repo adds support for Cyclic CA's to give you an example as to how to setup your own CA engine coded in Scala.  And for those more familiar with Java, there's also an example coded in Java which adds support for the "Vote" class of CA's, the most interesting being the "Fredkin Replicator" CA.  Actually, CALab was made "Java friendly" so that it would be easy to code a CA engine in Java.


Using this Repository to Run CCA's or Vote CA's
-----------------------------------------------

The easiest way to use this repository is to use the Simple Build Tool (SBT), and Git of course.  We will assume that you're setup to use Git and SBT.  Start by cloning the repo.

	git clone https://github.com/edadma/calab-example.git
	
Then go in to the newly created directory and start SBT.

	cd calab-example
	sbt
	
Now you can run CALab and have it load the CCA engine provided by this repo with the command

	run -e ca.hyperreal.calabexample.CyclicCA

SBT will cause the source files in this repo to be compiled, download CALab and then ensure that CALab will be able to find CyclicCA to load it, and then run CALab with CyclicCA loaded.