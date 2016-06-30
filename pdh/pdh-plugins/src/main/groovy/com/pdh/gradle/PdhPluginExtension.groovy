//For keeping passing arguments from gradle script.
import org.gradle.api.Project

class PdhPluginExtension {
	Project project
    String message = 'Hello from Pdh'
    String sender = 'Pdh'
    PdhNestedPluginExtention nested = new PdhNestedPluginExtention()
   
    PdhPluginExtension(Project project) {
        this.project = project
    }
}