pipeline {
    agent any
    parameters {
        choice(
            // choices are a string of newline separated values
            // https://issues.jenkins-ci.org/browse/JENKINS-41180
            choices: 'hello1\nhello2',
            description: '',
            name: 'Env')
    }

    stages {
        
        stage('Pull from git hub'){
      git 'https://github.com/GauravKumarQA/AutomationFrameworkUsingTestNG'
    }
        stage ('Test') {
            when {
                // Only say hello if a "greeting" is requested
                expression { params.Env == 'hello1' }
            }
            steps {
                 def mavenHome = tool name: 'M2_HOME', type: 'maven'
               bat "${mavenHome}/bin/mvn clean test -Denv=${params.Env}  -DbrowserName=chrome"
            }
        }
    }
}
