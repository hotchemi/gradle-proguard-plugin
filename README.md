# gradle-proguard-plugin

[![Build Status](https://travis-ci.org/hotchemi/gradle-proguard-plugin.svg)](https://travis-ci.org/hotchemi/gradle-proguard-plugin)

The gradle plugin to add proguard snippets to your proguard setting file quickly.

> This plugin pulls the proguard information from the [krschultz/android-proguard-snippets](https://github.com/krschultz/android-proguard-snippets).<br/>
> If you wanna add the snippets, PR to android-proguard-snippets!

## Download

You can download from jcenter.

Add following the code to your root `build.gradle`.

```groovy
apply plugin: 'add.proguard'

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.github.hotchemi:gradle-proguard-plugin:0.1.0'
    }
}
```

## How to use

Use the `addProguard` task as described below.

```sh
./gradlew addProguard -Plib=butterknife
```

The plugin add the proguard snippets to your `*.pro` file.

> You must prepare the one .pro file. If there are several files or nothing, the plugin shows the warning.

And you can use the `aP` task, it is the shortcut of the `addProguard`.

```sh
./gradlew aP -Plib=butterknife
```

You can put plural arguments.

```sh
./gradlew aP -Plib="butterknife gson rx-java"
```

If you already added the snippets of the library, the plugin stops task and shows the warning.

```sh
proguard-rules.pro already contains library's snippet. Do you continue(y/n)?
```

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
