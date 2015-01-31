package com.github.hotchemi

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class AddProguardSpec extends Specification {

    def "apply() should load the plugin"() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.with {
            apply plugin: 'add.proguard'
        }

        then:
        project.plugins.hasPlugin(AddProguardPlugin)
    }

}
