# !/bin/sh/

../bin/storm jar ./storm-kafkatopic-topology-1.0.0.jar org.apache.storm.flux.Flux -s 1000000 --remote ./topology_config.yaml --filter ./topology_dev.properties

