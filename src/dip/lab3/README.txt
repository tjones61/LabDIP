INSTRUCTIONS:
===================================
You have been presented with a description and purpose of the
Dependency Inversion Principle (DIP). You will need to understand this
principle to successfully complete the lab work.

DIP RULES:
    A. HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW
       LEVEL MODULES. BOTH SHOULD DEPEND UPON ABSTRACTIONS.

    B. ABSTRACTIONS SHOULD NOT DEPEND UPON DETAILS. DETAILS
       SHOULD DEPEND UPON ABSTRACTIONS.

DIP OBJECTIVES:
    1. Reduce rigidity and fragility.
    2. Improve portability (code reuse, flexibility)

THE CHALLENGE (DO NOT START UNTIL LABS #1 AND #2 ARE COMPLETED):
------------------------------------------------------------------------
In this lab #3 you are building a program from scratch that uses the 
design principles specified by the DIP. To succeed follow these instructions:

Use the OOA/D goals that you memorized:

    * Generic Analysis: Define the problem and its requirements:

      This can be accomplished by reading the project specification below.

    * Object-Oriented Analysis: Find the conceptual objects in
      the problem domain:

      After reading the project specification, look for, or think of nouns
      that represent the objects you will need. There should be six key
      nouns and these should be fairly obvious.

    * Generic Design: Find a conceptual solution:

      Create a Domain Model as follows...
      Using pencil and paper, draw boxes containing conceptual object names,
      connected by association lines, labeled to describe the association.
      You should have one box for each of six key conceptual objects.

    * Object-oriented Design: Skillfully Assigning Responsibilities to Objects:

      Now that you have a good idea of the objects you will need and how
      they will collaborate (communicate) with each other, apply the DIP and
      all best practices learned so far to write code that follows your 
      Domain Model and skillfully assigns the right responsibilities to the
      right objects. Ask yourself, what should this object do, and what
      should it not do?


PROJECT SPECIFICATIONS:
----------------------
We need a simple messaging system that is flexible enough to input
messages from different sources (keyboard, file, another object, etc.)
and output those messages in different ways.

For example message input might be needed for a
random tip of the day (perhaps stored as an array of Strings) or a welcome 
message, or an error message coming from another object. Message output might
be needed to go to various destinations: the console or a GUI, for example
(you could use a JOptionPane). So you might need a class for console output and 
another for GUI output to start, but in the future be able to added other 
output classes as needed. Switching message input objects or message
output objects should be easy and should not break code. Take a look at the
"IndependentCopy" project and notice how easily we can switch from one
reader or writer to another. This is your goal for input and output objects.

The actual wording of the messages is not important for this first version,
however, you will need to support at least two different ways of inputting
a message and at least two different ways of outputting a message. And we want
as much code as possible to be portable and flexible so that changes don't
require much editing. For example, in the IndependentCopy sample, it was the
Copier class and Reader and Writer interfaces that were portable. Further,
you need a high-level class that delegates the work of getting a message 
(input) and outputting a message to various low-level classes. For example, 
in the IndependentCopy example the Copier class was the high-level class. It
delegated the actual work of copying to various readers and writers. You
will need a high-level class that provides some kind of message service. It
should delegate to low-level classes that do the input and output. Both
high-level and low-level classes should depend on abstractions. Again, examine
the IndependentCopy example for how this is done.

In addition you will need a Startup class with a main method to start the 
program and do some basic initialization. But remember, input comes from 
the input components and output goes to the output components. You need to 
ENCAPSULATE as much behavior as possible in your high-level class so that 
the Startup class knows as little as possible (Principle of Least Knowledge) 
about the other classes in your program.  So to do this your Startup class must 
ONLY talk to the high-level class -- never to the low-level classes. That means
your program should have at least 6 classes: one startup, one high-level service
class, two input classes and two output classes. And you should be able to
test the flexibility of your program by switching input and output objects 
without breaking any code in your high level class or the low level classes.
In addition, you should be able to add a third input and a third output class
easily without breaking anything either (except the Startup initialization
code will need altering.)

For those of you who don't know how to do simple input/output GUIs, here's
some sample code:

For an output GUI, just use a JOptionPane.showMessageDialog() method, but you
must remember to do an import first, above your class declaration, but below
the package reference:

package dip.lab3;

import javax.swing.JOptionPane;

public class MyClass { ...

... then to use it just do this inside a method:

JOptionPane.showMessageDialog(null,"My Message");

... then to do input, if necessary, do this inside a method:

String response =
       JOptionPane.showInputDialog(null, "A Prompt, like enter message here:");

For more information, see the online JavaDoc for the JOptionPane class in
Java SE 7.

IMPORTANT Final thoughts: treat this as a self-test. Make sure you follow ALL best
practices discussed to date. That includes method parameter validation, no
magic numbers, open/closed principle, Command-Query separation principle,
Single Responsibility Principle, Principle of Least Knowledge, Encapsulation,
Liskov Substitution Principle and proper naming conventions.
 