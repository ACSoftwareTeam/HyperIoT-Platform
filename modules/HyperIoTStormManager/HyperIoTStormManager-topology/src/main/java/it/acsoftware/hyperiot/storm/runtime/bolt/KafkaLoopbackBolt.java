package it.acsoftware.hyperiot.storm.runtime.bolt;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.io.Serializable;
import java.util.Map;

public class KafkaLoopbackBolt extends BaseBasicBolt implements Serializable {
    private Map config;
    private static final long serialVersionUID = 1L;

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        config = stormConf;
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // TODO: this is just a test bolt
        System.out.println(input);
        Thread.yield();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("hpacket"));
    }
}
