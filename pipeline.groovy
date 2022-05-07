node{
 stage('Source'){
     git 'https://github.com/javahometech/myweb.git'
 }
 
 stage('Build'){
    def mvnHome = tool 'maven3'
    sh "${mvnHome}/bin/mvn clean package" 
 }
 stage('Send Email'){
     mail bcc: '', body: 'Demo Pipeline', cc: '', from: '', replyTo: '', subject: 'Pipeline Demo', to: 'vsubrahmanyamkv8@gmail.com'
 }
 stage('Archive'){
     archiveArtifacts 'target/*.war'
 }
 
 
}
