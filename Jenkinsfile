node{
    stage('Pull from git hub'){
      git 'https://github.com/GauravKumarQA/AutomationFrameworkUsingTestNG'
    }
    stage('Maven test'){
        def mavenHome = tool name: 'M2_HOME', type: 'maven'
        sh "$(mavenHome)/bin/mvn test"
    }
}
