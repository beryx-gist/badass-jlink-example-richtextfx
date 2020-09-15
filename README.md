[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/beryx-gist/badass-jlink-example-richtextfx/blob/master/LICENSE)
[![Build Status](https://img.shields.io/travis/beryx-gist/badass-jlink-example-richtextfx/master.svg?label=Build)](https://travis-ci.org/beryx-gist/badass-jlink-example-richtextfx)

## Badass JLink Plugin Example: RichTextFX ##

A small JavaFX application using [RichTextFX](https://github.com/FXMisc/RichTextFX) that shows how to use the [Badass JLink Plugin](https://github.com/beryx/badass-jlink-plugin).
It creates a custom runtime image containing only the JDK and JavaFX modules required by the application.
It also creates a platform-specific installer that associates files with the _my-java_ extension with this application.

Take a look at [build.gradle](https://github.com/beryx-gist/badass-jlink-example-richtextfx/blob/master/build.gradle) to see how to configure the plugin.

### Usage
**Running with gradle:**
```
./gradlew run
```

A window containing Java source code with syntax highlighting should appear on the screen.


**Creating and executing a custom runtime image:**
```
./gradlew jlink
cd build/image/bin
./java-keywords
```

A window containing Java source code with syntax highlighting should appear on the screen.


**Creating platform-specific application installers:**
```
./gradlew jpackage
```

The platform-specific application installers will be available in the build/jpackage directory.
The installers associate files with the extension `.my-java` with this application.
