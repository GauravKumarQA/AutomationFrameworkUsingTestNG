 properties([parameters([choice(choices: 'hello1\nhello2', description: '', name: 'Env')]), pipelineTriggers([])])
node{
    stage('Pull from git hub'){
      git 'https://github.com/GauravKumarQA/AutomationFrameworkUsingTestNG'
    }
    stage('Maven test'){
            
        def mavenHome = tool name: 'M2_HOME', type: 'maven'
     try{bat "${mavenHome}/bin/mvn clean test -Denv=hello1  -DbrowserName=chrome"}catch(err){echo "Fail"}
        bat "${mavenHome}/bin/mvn clean test -Denv=hello2  -DbrowserName=chrome"
    }
}
