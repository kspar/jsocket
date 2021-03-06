JSocket
===============
A Java Socket Programming Library

![Build Status](https://travis-ci.org/czifro-tech/jsocket.svg?branch=master)


Summary
----------

JSocket was developed to make socket programming in Java simpler. JSocket currently only focuses on TCP connections. What makes this library useful is that it makes cross-platform and cross-language TCP connections easier to deal with on the Java side. This library attempts to ensure clean messages come through that come from another platform/language. In some instances, say C# client -> Java server, a "dirty" message will come through. The Jsocket library can clean the message and return to a developer the correct message. This library includes various feature that can send anything from a simple string to a complex object. Features also include RSA encryption. Generate your own private and public keys.


How to Use
-----------

Link to tutorial: https://github.com/czifro/JSocket/wiki/Tutorial


Build Status & Download
------------------------

|Version Number|Build Status|Download|
|:------:|:------:|:------:|
|v0.4.2 (master) |[![][v0.4.2-buildStatus]][travis-ci]|[Download JAR][v0.4.2]|
|v0.5.0 (beta 1) |[![][v0.5.0-beta1-buildStatus]][travis-ci]|[Download JAR][v0.5.0-beta1]|
|v0.5.0 (beta 2) |[![][v0.5.0-beta2-buildStatus]][travis-ci]|[Download JAR][v0.5.0-beta2]|
|v0.5.0 (beta 3) |[![][v0.5.0-beta3-buildStatus]][travis-ci]|[Download JAR][v0.5.0-beta3]|
|v0.5.0 (WIP) |[![][v0.5.0-buildStatus]][travis-ci]|---|

[travis-ci]: https://travis-ci.org/czifro-tech/jsocket
[v0.4.2-buildStatus]: https://travis-ci.org/czifro-tech/jsocket.svg?branch=master
[v0.4.2]: https://github.com/czifro-tech/jsocket/tree/mvn-repo/com/czifrodevelopment/jsocket/jsocket/0.4.2-SNAPSHOT
[v0.5.0-beta1-buildStatus]: https://travis-ci.org/czifro-tech/jsocket.svg?branch=vNext_0_5_0_beta_1
[v0.5.0-beta1]: https://www.dropbox.com/sh/2ea67dzctn4d0dl/AACXkmTNF9OOPbw3CHpKpONca?dl=0
[v0.5.0-beta2-buildStatus]: https://travis-ci.org/czifro-tech/jsocket.svg?branch=vNext_0_5_0_beta_2
[v0.5.0-beta2]: https://www.dropbox.com/sh/mfmd0sfei6qnxyp/AAC3Best69HwUjNrbXmk7QRea?dl=0
[v0.5.0-beta3-buildStatus]: https://travis-ci.org/czifro-tech/jsocket.svg?branch=vNext_0_5_0_beta_3
[v0.5.0-beta3]: https://www.dropbox.com/s/1vpz9l4q0e8lkto/jsocket-0.5.0-beta-3.jar?dl=0
[v0.5.0-buildStatus]: https://travis-ci.org/czifro-tech/jsocket.svg?branch=vNext_0_5_0


History: https://github.com/czifro/JSocket/wiki/Listed-Releases


Trello
-------------

Development can be tracked here: https://trello.com/b/6E8x9Mnv


===========


Credit
-------------

The ObjectSocket class is functional partly due to Google's [Gson package for Java](https://code.google.com/p/google-gson/). This package is great for converting any object to JSON and vice versa.

   
=====================


MIT License
---------------------------

The JSocket repository is released under the MIT License. Use it anyway you like. I release this software as is. In no way am I liable for anything as per outlined by the MIT License.

