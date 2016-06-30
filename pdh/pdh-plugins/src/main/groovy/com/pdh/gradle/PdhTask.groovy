package com.pdh.gradle;

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PdhTask extends DefaultTask {
    
    @TaskAction
    def showMessage() {
       println "------------showMessage-------------------"
       ssh.run {
                    settings {
                        knownHosts = allowAnyHosts
                    }
                    session(host: '10.221.10.140', user: 'sujoy_banerjee', agent: true) {
                        project.logger.quiet("*** Deployment request:")
                	}
                }
        println "From : ${project.c4rArgs.sender},\
                 message : ${project.c4rArgs.message}"
        println "To : ${project.c4rArgs.nestedArgs.receiver},\
                 email : ${project.c4rArgs.nestedArgs.email}"
        
    }
}
