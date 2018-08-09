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

    if(${params.Env} == 'hello1'){
        stages {
            stage ('hello'){
            steps {
                echo 'Hello, Maven'
                  }
                           }
                }
                                 }
    else{
     stages {
            stage ('hello2'){
            steps {
                echo 'Hello, Maven'
                  }
                           }
         stage ('hell01'){
          echo 'Hello, Maven2'
         }
                }
    }
}
