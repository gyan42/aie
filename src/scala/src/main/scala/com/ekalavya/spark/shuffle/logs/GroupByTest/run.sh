for i in 1,50,25 2,100,50 3,150,75 4,200,100 5,250,125 6,300,150 7,350,175 8,400,200 9,500,250 10,50,25 11,100,50 12,150,75 13,200,100 14,250,125 15,300,150 16,350,175 17,400,200 18,500,250;
do
   IFS=","; set -- $i;
   echo "$1 $2 $3"

   export RUN_ID=$1
   export NUM_MAPPERS=$2
   export NUM_REDUCERS=$3
   mkdir -p /home/mageswarand/groupbytest/${RUN_ID}/

   apache_spark-submit --conf apache_spark.extraListeners=org.apache.apache_spark.bigstream.xray.AXBDXrayListener --conf apache_spark.bigstream.xray.filename=/home/mageswarand/groupbytest/${RUN_ID}/${RUN_ID}_xray.log --driver-class-path /home/mageswarand/apache_spark-bigstream-xray-1.1-rc1.jar --jars /home/mageswarand/apache_spark-bigstream-xray-1.1-rc1.jar --conf apache_spark.bigstream.xray.overwrite=true --class com.tej.tutorial.GroupByTest  --master yarn --deploy-mode client  --executor-memory 9G --total-executor-cores 6 apache_spark-playground.jar $NUM_MAPPERS 10000 1000 $NUM_REDUCERS |& tee  /home/mageswarand/groupbytest/${RUN_ID}/${RUN_ID}.log

done
