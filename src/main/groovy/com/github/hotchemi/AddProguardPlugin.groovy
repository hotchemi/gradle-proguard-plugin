package com.github.hotchemi

import org.gradle.api.Plugin
import org.gradle.api.Project

class AddProguardPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('addProguard', type: AddProguardTask)
    }
}
