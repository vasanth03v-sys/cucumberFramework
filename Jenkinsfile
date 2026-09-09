pipeline{
agent any
stages{
stage('checkout'){
steps{
git'https://github.com/vasanth03v-sys/cucumberFramework.git''}
}
}
stage('Build'){
steps{
bat 'mvnw.cmd clean test'
}
}
}
}