node {
stage('pulling code from git'){
checkout scm
}
stage('Maven Build'){
sh '/opt/apache-maven-3.6.0/bin/mvn install'
}
stage('Build Image'){
sh 'sudo docker build -t accountservice:${BUILD_NUMBER} .'
//sh 'docker tag accountservice:${BUILD_NUMBER} vidyakamath0612/accountfinal5:final'
}
stage('Push Image'){
sh 'docker login -u vidyakamath0612 -p 8990benka'
sh 'docker push vidyakamath0612/accountservice:${BUILD_NUMBER} '
}
}
