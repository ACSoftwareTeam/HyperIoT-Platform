#!/bin/bash

export SPARK_MASTER_HOST

. "/spark/sbin/spark-config.sh"

. "/spark/bin/load-spark-env.sh"

mkdir -p $SPARK_WORKER_LOG

export SPARK_HOME=/spark

rm -f $SPARK_HOME/conf/spark-defaults.conf  # remove file and recreate with new values
touch $SPARK_HOME/conf/spark-defaults.conf
echo "spark.eventLog.enabled true" >> $SPARK_HOME/conf/spark-defaults.conf
echo "spark.master $SPARK_MASTER" >> $SPARK_HOME/conf/spark-defaults.conf
echo "spark.eventLog.dir $SPARK_EVENT_LOG_DIR" >> $SPARK_HOME/conf/spark-defaults.conf

ln -sf /dev/stdout $SPARK_WORKER_LOG/spark-worker.out

/spark/sbin/../bin/spark-class org.apache.spark.deploy.worker.Worker \
    --webui-port $SPARK_WORKER_WEBUI_PORT $SPARK_MASTER >> $SPARK_WORKER_LOG/spark-worker.out
