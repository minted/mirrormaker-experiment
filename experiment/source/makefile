
# https://kafka.apache.org/quickstart

CURRENT=$(shell pwd)
COMMANDPATH=$(CURRENT)/../../bin
CONFIGPATH=$(CURRENT)/config
BOOSTRAP_SERVER_SRC=localhost:9092
TOPIC_FOR_TESTING=testing0003

zk:
	$(COMMANDPATH)/zookeeper-server-start.sh $(CONFIGPATH)/zookeeper2181.properties

kf:
	rm -rf /tmp/kafka-logs-9092
	$(COMMANDPATH)/kafka-server-start.sh $(CONFIGPATH)/server9092.properties

kf-2:
	$(COMMANDPATH)/kafka-server-start.sh $(CONFIGPATH)/server9094.properties

produce-msg-2:
	$(COMMANDPATH)/kafka-console-producer.sh --broker-list localhost:9094 --topic $(TOPIC_FOR_TESTING)

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

clean:
	$(COMMANDPATH)/zookeeper-server-stop.sh $(CONFIGPATH)/zookeeper2181.properties
