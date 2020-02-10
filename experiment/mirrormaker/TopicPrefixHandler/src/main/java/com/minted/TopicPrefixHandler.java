package com.minted;


import kafka.consumer.BaseConsumerRecord;
import kafka.message.MessageAndMetadata;
import kafka.tools.MirrorMaker;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Collections;
import java.util.List;

public class TopicPrefixHandler implements MirrorMaker.MirrorMakerMessageHandler {

    private final String topicPrefix;

    public TopicPrefixHandler(String topicPrefix) {
        this.topicPrefix = topicPrefix;
    }

    public List<ProducerRecord<byte[], byte[]>> handle(MessageAndMetadata<byte[], byte[]> record) {
        return Collections.singletonList(new ProducerRecord<byte[], byte[]>(topicPrefix + "." + record.topic(), record.partition(), record.key(), record.message()));
    }

    public List<ProducerRecord<byte[], byte[]>> handle(BaseConsumerRecord record) {
        return Collections.singletonList(new ProducerRecord<byte[], byte[]>(topicPrefix + "." + record.topic(), record.partition(), record.key(), record.value()));
    }
}
