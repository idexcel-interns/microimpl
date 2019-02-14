node {
stage('pulling code from git'){
checkout scm
}
stage('Build Image'){
sh 'sudo docker build -t LadyVK/microimpl:${BUILD_NUMBER} .'
sh 'docker tag LadyVK/microimpl:${BUILD_NUMBER} vidyakamath0612/accountfinal5:final'
}
stage('Push Image'){
sh 'docker login -u vidyakamath0612 -p 8990benka'
sh 'docker push vidyakamath0612/accountfinal5:final '
}
}
