# How to Run

Step 1: Clone and open the repository in IntelliJ

Step 2: Setup the JDK. Select amazon/coretto java 11.

Step 3: In the game folder, Right Click the Game Class.

Step 4: Select run Game.main()

# Game Description

Welcome to PACT!

This is a text-based adventure RPG designed for single player enjoyment. The game revolves around exploration of the game world between different areas and experiencing different events, some very peaceful and others not so much. 

The plot of the game is based around the legendary hero (you, the player) destined to save the lowly inhabitants of Tartarus, the game world. To do this, you must defeat the dangerous tyrant, The Demon King! In order to train and fight him, you must travel through the four elemental zones of the world, collecting magical crystals to open the gates to his castle. There is quite the plot twist, however... 

Your choices greatly affect the outcome of the game, so make your choices carefully! Don't lose track of who the enemy really is.

# Test Coverage

We covered most methods that did complex operations. 

Methods such as getters, setters, or otherwise low logic methods were not explicitly tested, 
but may have been implicitly tested while testing other functions. 

Classes in the game package were not tested for correctness due to being just initialization. 

Many classes in io package were also not tested (due to being input/output)

We also created a simulation test to be able to insert any sequence of user inputs and see if it throws a runtime error. 

More information about this is in the docstring of the GameTest.java file in the test/game package. 

The test coverage report can be found at index.html of the test_coverage_report folder. 

A screenshot is also provided here: 

![test_coverage_report_ss](https://cdn.discordapp.com/attachments/1025202069856063528/1050630342001819769/image.png)