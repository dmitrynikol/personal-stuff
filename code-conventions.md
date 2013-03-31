### WARNING: description not finished yet!

These guidelines/recommendation should be followed for all new source files added to the repository.

### General
 - Indentation: never ever use tabs in source code, because there is not a standard for the placement of tabstops. 
 - Line wrapping: always use 120 symbols in one line.

### Java
General
 - Java source file should not be very large, 300-400 lines for one file will be enough(except only some rare api or parser).
 - Indentation: use 4 spaces.

Packages:
 - Package name should be in lowercase and should not contain any underscores.
 - Package name should be subdivided, start with the company/project domain before split into layers on features. Example “com.umbrellacorp.ui.client.service” or “com.umbrellacorp.ui.server.service”.

Comments
 - Classes, methods and constants should contains javadoc.
 - In general descriptions all sentences should end up with a dot, except param, return and thrown.
 - If you create a class or interface or make some serious corrections, you should always add yourself as the author.
 - Use {@inheritDoc} directive to directly inherit the long description from the parent class in child classes or when you implement/override a method and you want to put some description by parent’s javadoc.
 - Before package declaration firstly should go copyright documentation(if there is no copyright information, just skip it).

Classes, methods, interfaces etc
- classes names should be in CamelCase. Normally class representing something in the real world, so try to use nouns.
- interface also should be in CamelCase and name should describe an operation that a class can do.

### Examples

```java
/*
 * Copyright 2005 UmbrellaCorp Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.umbrellacorp.ui.client.core; 

/**
 * Class description should be here.
 * 
 * @author Firstname Lastname
 * @version 1.15 02 May 2012  
 */
public class Element implements Renderer, Updater {
	
	/**
	 *  class description...
	 */
	public class First {
		
	}
	/**
	 *  count documentation comment
	 */
	public static int count;
	
	/**
	 *  static initializer declarations
	 */
	static {
		
	}
	
	/**
	 *  static method declarations with documentation comment
	 */
	static void executeSomething() {
		// implementations...
	}
	
	/**
	 *  firstField documentation comment
	 */
	public Object firstField;
	/**
	 * secondField documentation comment
	 */
	public Object secondField;
	
	/**
	 * isAlive documentation comment
	 */
	protected boolean isAlive; 
	
	/**
	 * position documentation comment
	 */
	private Position2D position;
	
	/**
	 * class description...
	 */
	public Element() {
		// implementation should be here...
	}
	/**
	 * class description...
	 */
	private Element(boolean visible) {
		// implementation should be here...
	}
	
	/**
	 * method render documentation  comment
	 * 
	 * @param object description
	 */
	@Override
	public void render(Object object) {
		// implementation should be here...
	}
	/**
	 * method update documentation  comment
	 * 
	 * @param delta description
	 */
	protected void update(float delta) {
		// implementation should be here...
	}
	/**
     * method destroy documentation  comment
     *
     * @param level description
     * @return description
     * @throws ElementException when ....
     */
	private boolean destroy(Level level) {
		// implementation should be here...
	}
}
```

### XML and GWT guidelines
This is not only an entirely coding convention it’s also some explanation and recommendation on how to architect some of the features. 


Examples
GWT source code should be here!
