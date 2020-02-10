# Target env

# https://kafka.apache.org/quickstart

CURRENT=$(shell pwd)
COMMANDPATH=$(CURRENT)/../../bin
CONFIGPATH=$(CURRENT)/config
BOOSTRAP_SERVER_SRC=localhost:9093
TOPIC_FOR_TESTING=testing0002

zk:
	$(COMMANDPATH)/zookeeper-server-start.sh $(CONFIGPATH)/zookeeper2182.properties

kf:
	rm -rf /tmp/kafka-logs-9093
	$(COMMANDPATH)/kafka-server-start.sh $(CONFIGPATH)/server9093.properties

create-topic:
	$(COMMANDPATH)/kafka-topics.sh --create \
		--bootstrap-server $(BOOSTRAP_SERVER_SRC) \
		--replication-factor 1 \
		--partitions 1 \
		--topic $(TOPIC_FOR_TESTING)

list-topics:
	$(COMMANDPATH)/kafka-topics.sh --list --bootstrap-server $(BOOSTRAP_SERVER_SRC)

produce-msg:
	$(COMMANDPATH)/kafka-console-producer.sh --broker-list $(BOOSTRAP_SERVER_SRC) --topic $(TOPIC_FOR_TESTING)

consume-msg:
	$(COMMANDPATH)/kafka-console-consumer.sh --bootstrap-server $(BOOSTRAP_SERVER_SRC) --topic $(TOPIC_FOR_TESTING) --from-beginning

consume-mirror-msg:
	$(COMMANDPATH)/kafka-console-consumer.sh --bootstrap-server $(BOOSTRAP_SERVER_SRC) --topic testing0003 --from-beginning

consume-mirror-prefix-msg:
	$(COMMANDPATH)/kafka-console-consumer.sh --bootstrap-server $(BOOSTRAP_SERVER_SRC) --topic nonprod.testing0003 --from-beginning

clean:
	$(COMMANDPATH)/zookeeper-server-stop.sh $(CONFIGPATH)/zookeeper2181.properties
