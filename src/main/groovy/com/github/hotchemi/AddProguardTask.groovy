package com.github.hotchemi

import groovy.util.logging.Log
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AddProguardTask extends DefaultTask {

    @TaskAction
    def run() {
        if (!project.hasProperty("lib"))
            Utils.exit("Please set arguments: `gradlew aP -Plib=library'")

        List<String> arguments = project.lib.split()
        if (arguments.isEmpty())
            Utils.exit "arguments aren't set"

        List<String> proguardPaths = Utils.findProguardPaths()
        if (proguardPaths.isEmpty())
            Utils.exit "There were no .pro files found."
        if (proguardPaths.size() > 1)
            Utils.exit "More than one .pro file was found.  Please remove unused ones."

        arguments.each { library ->
            String proguardPath = proguardPaths.first()
            File proguard = new File(proguardPath)
            if (proguard.text.contains(library)) {
                String response = System.console().readLine("> ${proguardPath} already contains ${library}'s snippet. Would you like to continue? (y/n) ")
                if (response == "n") {
                    Utils.exit("Shutdown")
                }
            }
            proguard.withWriterAppend {
                it << System.properties['line.separator'] + Utils.getHttpResponse(library)
            }
            Log.println("Added ${library}'s snippet to ${proguardPath}.")
        }
    }

}
