[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/beryx-gist/badass-jlink-example-richtextfx/blob/master/LICENSE)
[![Build Status](https://img.shields.io/travis/beryx-gist/badass-jlink-example-richtextfx/master.svg?label=Build)](https://travis-ci.org/beryx-gist/badass-jlink-example-richtextfx)

## Badass JLink Plugin Example: RichTextFX ##

A small JavaFX application using [RichTextFX](https://github.com/FXMisc/RichTextFX).

The plugin is configured in `build.gradle` as follows:

```
plugins {
    id 'org.openjfx.javafxplugin' version '0.0.7'
    id 'org.beryx.jlink' version '2.11.0'
}

dependencies {
    implementation 'org.fxmisc.richtext:richtextfx:0.10.1'
}

repositories {
    mavenCentral()
}

javafx {
    modules = ['javafx.controls']
}

mainClassName = "org.example.richtextfx/org.example.richtextfx.JavaKeywordsDemo"
jlink {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'java-keywords'
    }
    addExtraDependencies("javafx")
}
```

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
