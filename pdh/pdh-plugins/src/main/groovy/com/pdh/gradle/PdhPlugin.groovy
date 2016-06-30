package com.pdh.gradle;

import org.gradle.api.*;

class PdhPlugin implements Plugin<Project> {
    def void apply(Project project) {
    		
    		project.apply([plugin: 'download-task']);
        	project.apply([plugin: 'ssh']);
			
            def deploymentSpec = project.extensions.create("c4rArgs", PdhPluginExtension, project)
            def deploymentExSpec = project.c4rArgs.extensions.create("nestedArgs",PdhNestedPluginExtention)
            
            project.repositories {
            	maven {
                	mavenCentral()
            	}
        	}
            //project.task('PdhTask', type: PdhTask)
            
            project.task('PdhTask') << {
            	project.logger.quiet("*** PdhTask request:")
            	runDeploymentForAll(project)
        	}
    }  
    
    private void runDeploymentForAll(Project project) {
     	project.logger.quiet("*** runDeploymentForAll request:")
		project.ssh.run {
			settings {
				knownHosts = allowAnyHosts
			}
			session(host: '10.221.10.140', user: 'sujoy_banerjee', agent: true) {
				project.logger.quiet("*** Deployment request:")
				
			}
		}
    }
      
    
}


