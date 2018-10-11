Experiment where a TestLister and a TestCase update/read a GlobalVariable
==============

## What is this?

This is a simple [Katalon Studio](https://www.katalon.com/) project demoveloped for demostration purpose. You can clone this out to your PC and run it with Katalon Studio.

This project was developed using Katalon Studio 5.7.1.

This project was developed to reproduce [a problem raised in a post in the Katalon Forum](https://forum.katalon.com/discussion/10064/globalvariable-map-is-not-picking-up-the-latest-key-value). The original question was as follows:

>Found that the GlobalVariable Map is not picking up the latest Value of a Key during execution.
1. Define a Global Variable Map, ie. TestingA variable.
2. Assign value to the TestingA Map in the TestListener, Before Test Case
eg. GlobalVariable.TestingA.put("A","Testing 123")
3. In the Test Case, modify the TestingA value, eg. GlobalVariable.TestingA.put("A", "This is modified")
4. in the TestListner, After Test Case, found below:
GlobalVariable.TestingA.get("A") -> Resulting in the value : "Testing 123". I am expecting the value should be "This is modified" instead .
>
>This is happening in the GlobalVariable with MAP

## How to run the demo
1. Download the latest zip of the project from the  [releases]https://github.com/kazurayam/KatalonDiscussion10064/releases) page, unzip it.
2. Open the project with your Katalon Studio.
3. Open the `Test Cases/TC` and run it with any browser

## How it worked

Please find the source here:

- [Test Listener/TL](Test Listeners/TL.groovy)
- [Test Cases/TC](Scripts/TC/Script1539216962665.groovy)

When I executed the Test Case, I got the following messages in the log:

```
...
10-11-2018 09:40:06 AM - [INFO]   - >>> before update, m.get('A')=Testing 123
...
10-11-2018 09:40:06 AM - [INFO]   - >>> after test case, m.get('A')=This is modified
...
```

## Conclusion

In my environement, the Test Lister TL and the Test Case TC successfully read and update the GlobalVariable of type java.util.Map.

I presume the questioner who raised the original question has a problem unique to his own environment. For example the Groovy source of the GlobalVariable might not have been compiled Groovy properly. I would suggest him the following procedure:

1. stop Katalon Studio GUI.
2. remove the `<project directory>/bin/` directory where all of compiled class files are stored including GlobalVariable.
2. restart Katalon Studio GUI.
3. run the Test Case again; then all of Groovy sources will be recompiled. You you see the result using the clean-built binaries.
