node{
 stage('Source'){
     git 'https://github.com/kvsubrahmanyam/myweb.git'
 }
 
 stage('Build'){
    def mvnHome = tool 'maven3'
    sh "${mvnHome}/bin/mvn clean package" 
 }
 stage('Send Email'){
     mail bcc: '', body: 'Demo Pipeline', cc: '', from: '', replyTo: '', subject: 'Pipeline Demo', to: 'subrahmanyamkv8@gmail.com'
 }
 stage('Archive'){
     archiveArtifacts 'target/*.war'
 }
 
 
}
