Instructions for running code:

  The java code can be run anywhere with java 11. Running the code generates a text document which
  contains a representation of a boolean expression. This text document is used by sat-solver.py, 
  so make sure it is reachable by that file.  	

  We used the satispy Python package along with Minisat for SAT solving. We used a virtual machine 
  running linux, but any linux machine should work. Make sure python3 and pip3 are installed on the
  system. Run 'sudo pip3 install satispy' and 'sudo apt-get install -y minisat' in a terminal to get
  all the neccesary python packages. At this point sat-solver.py should be runnable. 
