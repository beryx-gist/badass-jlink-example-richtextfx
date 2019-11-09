[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/beryx-gist/badass-jlink-example-richtextfx/blob/master/LICENSE)
[![Build Status](https://img.shields.io/travis/beryx-gist/badass-jlink-example-richtextfx/master.svg?label=Build)](https://travis-ci.org/beryx-gist/badass-jlink-example-richtextfx)

## Badass JLink Plugin Example: RichTextFX ##

A small JavaFX application using [RichTextFX](https://github.com/FXMisc/RichTextFX) that shows how to use the [Badass JLink Plugin](https://github.com/beryx/badass-jlink-plugin).
It creates a custom runtime image containing only the JDK and JavaFX modules required by the application.
It also creates a platform-specific installer that associates files with the _my-java_ extension with this application.

The plugin is configured in `build.gradle` as follows:

```
plugins {
    id 'org.openjfx.javafxplugin' version '0.0.8'
    id 'org.beryx.jlink' version '2.16.2'
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

version = '5.4.3'

mainClassName = "org.example.richtextfx/org.example.richtextfx.JavaKeywordsDemo"
jlink {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'java-keywords'
    }
    addExtraDependencies("javafx")
    jpackage {
        // Set the environment property BADASS_JLINK_JPACKAGE_HOME or explicitly configure the below property
        // jpackageHome = '/usr/lib/jvm/jdk14'
        jvmArgs = ['-splash:$APPDIR/app/splash.png']
        imageOptions = ['--icon', 'src/main/resources/java.ico']
        installerOptions = [
                '--file-associations', 'src/main/resources/associations.properties',
                '--app-version', version,
        ]
        if (org.gradle.internal.os.OperatingSystem.current().windows) {
            installerOptions += ['--win-per-user-install', '--win-dir-chooser', '--win-menu']
        }
    }
    customImage {
        appModules = ['javafx.base', 'javafx.controls', 'javafx.graphics']
    }
}
tasks.jpackageImage.doLast {
    copy {
        from "src/main/resources"
        include "splash.png"
        into "build/jpackage/$project.name/app"
    }
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


**Creating platform-specific application installers:**
```
./gradlew jpackage
```

The platform-specific application installers will be available in the build/jpackage directory.
The installers associate files with the extension `.my-java` with this application.
