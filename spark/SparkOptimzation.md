# Spark Optimization

* Avoid `groupBy` and prefer `reduceBy`

  ```scala
  val a = sc.parallelize(List("dog", "cat", "owl", "gnu", "ant"), 2)
  val b = a.map(x => (x.length, x))
  b.reduceByKey(_ + _).collect
  // b.groupByKey().mapValues(_.mkString("")).collect()
  // Array[(Int, String)] = Array((3,dogcatowlgnuant))
  
  val a = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", "eagle"), 2)
  val b = a.map(x => (x.length, x))
  b.reduceByKey(_ + _).collect
  //// b.groupByKey().mapValues(_.mkString("")).collect()
  // Array[(Int, String)] = Array((4,lion), (3,dogcat), (7,panther), (5,tigereagle))
  ```

  

- Shuffle Block Size

  - Default maximum size is **2GB**
  - Preferred partition size od **~128MB**
  - 

- Broadcast Join for small data files

  - Spark SQL uses **broadcast join** (aka **broadcast hash join**) instead of hash join to optimize join queries when the size of one side data is below [spark.sql.autoBroadcastJoinThreshold](https://jaceklaskowski.gitbooks.io/mastering-spark-sql/spark-sql-properties.html#spark.sql.autoBroadcastJoinThreshold).

  