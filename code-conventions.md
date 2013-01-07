                                    ##WARNING: description not finished yet!

###General
 - Indentation: never ever use tabs in source code, because there is not a standard for the placement of tabstops. 
 - Line wrapping: always use 120 symbols in one line.

###Java
##General
 - Java source file should not be very large, 300-400 lines for one file will be enough(except only some rare api or parser).
 - Indentation: use 4 spaces.

##Packages:
 - Package name should be in lowercase and should not contain any underscores.
 - Package name should be subdivided, start with the company/project domain before split into layers on features. Example “com.umbrellacorp.ui.client.service” or “com.umbrellacorp.ui.server.service”.

##Comments
 - Classes, methods and constants should contains javadoc.
 - In general descriptions all sentences should end up with a dot, except param, return and thrown.
 - If you create a class or interface or make some serious corrections, you should always add yourself as the author.
 - Use {@inheritDoc} directive to directly inherit the long description from the parent class in child classes or when you implement/override a method and you want to put some description by parent’s javadoc.
 - Before package declaration firstly should go copyright documentation(if there is no copyright information, just skip it).

##Classes, methods, interfaces etc
- classes names should be in CamelCase. Normally class representing something in the real world, so try to use nouns.
- interface also should be in CamelCase and name should describe an operation that a class can do.

##Examples
Java source code should be here!

###XML and GWT guidelines
This is not only an entirely coding convention it’s also some explanation and recommendation on how to architect some of the features. 


##Examples
GWT source code should be here!
