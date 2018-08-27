node{
    stage('Pull from git hub'){
      git 'https://github.com/GauravKumarQA/AutomationFrameworkUsingTestNG'
    }
    stage('Maven test'){
            
        def mavenHome = tool name: 'M2_HOME', type: 'maven'
     try{bat "${mavenHome}/bin/mvn clean test -Denv=${params.url}  -DbrowserName=chrome"}catch(err){echo "Fail"}
     try{ bat "${mavenHome}/bin/mvn clean test -Denv=${params.url}  -DbrowserName=chrome"}catch(err){echo "Fails"}
    }
}
