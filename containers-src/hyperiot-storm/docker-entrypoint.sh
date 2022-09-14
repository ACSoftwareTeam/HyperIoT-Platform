#!/bin/bash

set -e

# Allow the container to be started with `--user`
if [ "$1" = 'storm' -a "$(id -u)" = '0' ]; then
    chown -R "$STORM_USER" "$STORM_CONF_DIR" "$STORM_DATA_DIR" "$STORM_LOG_DIR"
    exec su-exec "$STORM_USER" "$0" "$@"
fi

# Generate the config only if it doesn't exist
CONFIG="$STORM_CONF_DIR/storm.yaml"
if [ ! -f "$CONFIG" ]; then
    cat << EOF > "$CONFIG"
storm.zookeeper.servers: [$ZOOKEEPER_SERVERS]
nimbus.seeds: [$NIMBUS_SEEDS]
storm.log.dir: "$STORM_LOG_DIR"
storm.local.dir: "$STORM_DATA_DIR"
supervisor.slots.ports: [$SUPERVISOR_SLOTS_PORTS]
worker.childopts: "-Xmx%HEAP-MEM%m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=artifacts/heapdump"
EOF
fi

exec "$@"
