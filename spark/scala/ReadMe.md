Gradle Setup:

- https://guides.gradle.org/building-scala-libraries/

Scala+Spark Notebook Toree:

https://toree.apache.org/docs/current/user/quick-start/

```
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/
export SPARK_HOME=/opt/binaries/spark-2.4.4-bin-hadoop2.7/

pip install --upgrade toree
jupyter toree install --spark_home=/opt/binaries/spark-2.4.4-bin-hadoop2.7/
```

