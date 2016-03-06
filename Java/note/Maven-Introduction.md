
Introduction
============
介绍
=====

Maven, a Yiddish word meaning accumulator of knowledge, was originally started as an attempt to simplify the build processes in the Jakarta Turbine project.

Maven,是一个犹太词，意思是知识的累积，它原本的目标是为了在Jakarta Terbine项目中简化构建过程。

There were several projects each with their own Ant build files that were all slightly different and JARs were checked into CVS. We wanted a standard way to build the projects, a clear definition of what the project consisted of, an easy way to publish project information and a way to share JARs across several projects.

The result is a tool that can now be used for building and managing any Java-based project. We hope that we have created something that will make the day-to-day work of Java developers easier and generally help with the comprehension of any Java-based project.


Maven’s Objectives
===================
Maven的目标
============

Maven’s primary goal is to allow a developer to comprehend the complete state of a development effort in the shortest period of time.

Maven的主要目标是允许开发者在最短时间周期内理解一个开发成果的完成状态。
 
In order to attain this goal there are several areas of concern that Maven attempts to deal with:

 * Making the build process easy  
   使构建过程更简单
 * Providing a uniform build system  
   提供一个统一的构建系统
 * Providing quality project information  
   提供质量项目信息
 * Providing guidelines for best practices development
 * Allowing transparent migration to new features


Making the build process easy
-----------------------------
使构建过程更简单
--------------

While using Maven doesn’t eliminate the need to know about the underlying mechanisms, Maven does provide a lot of shielding from the details.


Providing a uniform build system
---------------------------------
提供一个统一的构建系统
--------------------

Maven allows a project to build using its project object model (POM) and a set of plugins that are shared by all projects using Maven, providing a uniform build system. Once you familiarize yourself with how one Maven project builds you automatically know how all Maven projects build saving you immense amounts of time when trying to navigate many projects.


Providing quality project information
-------------------------------------
提供质量项目信息
--------------

Maven provides plenty of useful project information that is in part taken from your POM and in part generated from your project’s sources. For example, Maven can provide:

* Change log document created directly from source control
* Cross referenced sources
* Mailing lists
* Dependency list
* Unit test reports including coverage

As Maven improves the information set provided will improve, all of which will be transparent to users of Maven.

Other products can also provide Maven plugins to allow their set of project information alongside some of the standard information given by Maven, all still based on the POM.


Providing guidelines for best practices development
-----------------------------------------------------

Maven aims to gather current principles for best practices development, and make it easy to guide a project in that direction.

For example, specification, execution, and reporting of unit tests are part of the normal build cycle using Maven. Current unit testing best practices were used as guidelines:

* Keeping your test source code in a separate, but parallel source tree
* Using test case naming conventions to locate and execute tests
* Have test cases setup their environment and don’t rely on customizing the build for test preparation.

Maven also aims to assist in project workflow such as release management and issue tracking.

Maven also suggests some guidelines on how to layout your project’s directory structure so that once you learn the layout you can easily navigate any other project that uses Maven and the same defaults.


Allowing transparent migration to new features
-----------------------------------------------

Maven provides an easy way for Maven clients to update their installations so that they can take advantage of any changes that been made to Maven itself.

Installation of new or updated plugins from third parties or Maven itself has been made trivial for this reason.


What is Maven Not?
==================
Maven不是什么？
==============

You may have heard some of the following things about Maven:

你可能听过一些关于Maven的说法：

* Maven is a site and documentation tool  
  Maven是一个站点和文档工具

* Maven extends Ant to let you download dependencies
* Maven is a set of reusable Ant scriptlets

While Maven does these things, as you can read above in the “What is Maven?” section, these are not the only features Maven has, and its objectives are quite different.

Maven does encourage best practices, but we realise that some projects may not fit with these ideals for historical reasons. While Maven is designed to be flexible, to an extent, in these situations and to the needs of different projects, it can not cater to every situation without making compromises to the integrity of its objectives.

If you decide to use Maven, and have an unusual build structure that you cannot reorganise, you may have to forgo some features or the use of Maven altogether.
