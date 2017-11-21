node {
    echo "This my first Jenkins"  
    sh '''javac Welcome.java'''
    echo "compilation completed"
    sh '''java Welcome'''   
    echo "end of program"
    sh "mkdir Default/demo/src/code"
 
    dir('Default/demo/src/code') {
        echo " I am inside demo"
    }

}
