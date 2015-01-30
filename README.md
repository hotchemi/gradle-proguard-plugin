Gradle Plugin Template
======================

This is a template project of Gradle plugin with blank implementation.

[![Build Status](https://travis-ci.org/int128/gradle-plugin-blank.png)](https://travis-ci.org/int128/gradle-plugin-blank)


Features
--------

This contains following features:

  * Plugin generator
  * Blank implementation of the plugin (see [HelloPlugin.groovy](src/main/groovy/com/example/HelloPlugin.groovy))
  * Testing with Spock (see [HelloPluginSpec.groovy](src/test/groovy/com/example/HelloPluginSpec.groovy))
  * Acceptance Test
  * Continuous integration support on Travis CI
  * Publishing the plugin on [Bintray](https://bintray.com) and [Gradle Plugins](http://plugins.gradle.org)
  * Gradle Wrapper
  * `.gitignore` for Gradle, IDEA and Eclipse


Getting Started
---------------

Update plugin ID, group name and description in `gradle.properties`.
See also [how to submit your plugin](http://plugins.gradle.org/submit).

Then, run the generate task. See [plugin-generator.gradle](gradle/plugin-generator.gradle) for details.

```
./gradlew generatePlugin

:generatePluginClass
Generating plugin class: .../src/main/groovy/com/example/HelloPlugin.groovy
:generatePluginMetadata
Generating plugin metadata: .../src/main/resources/META-INF/gradle-plugins/com.example.hello.properties
:generatePluginTestClass
Generating plugin test: .../src/test/groovy/com/example/HelloPluginSpec.groovy
:generatePlugin

BUILD SUCCESSFUL
```

All dependencies are downloaded by Gradle wrapper.

### Develop the plugin

Open the project with IDE like IntelliJ IDEA.
Repeat following steps.

1. Write a feature in `README.md`
2. Write a test code in `src/test/groovy/*Spec.groovy`
3. Write a product code in `src/main/groovy/*.groovy`

### Acceptance test

Install the artifact into the local repository and run the test task.

```sh
./gradlew install
./gradlew -p acceptance-test test
```

### Publish the plugin

Sign up Bintray and provide your user name and API key in `~/.gradle/gradle.properties` as follows:

```ini
bintray.credential=user:apikey
```

Run the upload task with release version.

```sh
./gradlew -Pversion=0.1 bintrayUpload
```


Working with Travis CI
----------------------

This project contains the continuous integration support and Travis CI will build the project on each push.

### Publish the plugin on Git tag

Add your user name and API key of Bintray in [.travis.yml](.travis.yml) as an encrypted variable.

```sh
travis encrypt --add -- BINTRAY=user:apikey
```

Then, push the tag.

```sh
git tag v0.1
git push origin --tags
```


Contributions
-------------

This is an open source software licensed under the Apache License Version 2.0.
Any issues or pull requests are welcome.
