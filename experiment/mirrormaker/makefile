CURRENT=$(shell pwd)
COMMANDPATH=$(CURRENT)/../../bin
CONFIGPATH=$(CURRENT)/config

mirror:
	$(COMMANDPATH)/kafka-mirror-maker.sh \
		--consumer.config $(CONFIGPATH)/consumer.properties \
		--producer.config $(CONFIGPATH)/producer.properties \
		--whitelist=".*"

mirror-prefix:
	export CLASSPATH=$CLASSPATH:/Users/andy.chen/src/kafka/kafka_2.12-2.4.0/experiemnt/mirrormaker/TopicPrefixHandler/target/TopicPrefixHandler-1.0-SNAPSHOT.jar &&\
	$(COMMANDPATH)/kafka-mirror-maker.sh \
		--consumer.config $(CONFIGPATH)/consumer.properties \
		--producer.config $(CONFIGPATH)/producer.properties \
		--message.handler com.minted.TopicPrefixHandler \
		--message.handler.args "nonprod" \
		--whitelist=".*"
