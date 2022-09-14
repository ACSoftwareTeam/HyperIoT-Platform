#!/bin/bash

#export SPARK_MASTER_HOST=`hostname`
export SPARK_MASTER_HOST    # on Kubernetes, hostname variable contains a non-public ip

. "/spark/sbin/spark-config.sh"

. "/spark/bin/load-spark-env.sh"

mkdir -p $SPARK_MASTER_LOG

export SPARK_HOME=/spark

rm -f $SPARK_HOME/conf/spark-defaults.conf  # remove file and recreate with new values
touch $SPARK_HOME/conf/spark-defaults.conf
echo "spark.eventLog.enabled true" >> $SPARK_HOME/conf/spark-defaults.conf
echo "spark.master $SPARK_MASTER" >> $SPARK_HOME/conf/spark-defaults.conf
echo "spark.eventLog.dir $SPARK_EVENT_LOG_DIR" >> $SPARK_HOME/conf/spark-defaults.conf
echo "spark.master.rest.enabled true" >> $SPARK_HOME/conf/spark-defaults.conf

ln -sf /dev/stdout $SPARK_MASTER_LOG/spark-master.out

cd /spark/bin && /spark/sbin/../bin/spark-class org.apache.spark.deploy.master.Master \
    --ip $SPARK_MASTER_HOST --port $SPARK_MASTER_PORT --webui-port $SPARK_MASTER_WEBUI_PORT >> $SPARK_MASTER_LOG/spark-master.out
