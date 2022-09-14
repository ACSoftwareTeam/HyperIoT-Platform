#!/bin/bash

exec $HADOOP_PREFIX/bin/yarn --config $HADOOP_CONF_DIR historyserver
