package com.pauloneto.activemq.artemis.jms.producer;
/**
* @author paulo.antonio@fornecedores.sicoob.com.br 
* @version 0.1 - 30 de out de 2019
*/

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class EmailProducer {

	@Inject
	@JMSConnectionFactory("java:/jms/remoteConnectionFactory")
	private JMSContext context;
	
	@Resource(lookup = "java:jboss/exported/jms/queue/RemoteEmailQueue")
	private Queue queue;
	
	public void sendEmail(String email) {
		context.createProducer().send(queue, email);
	}
	
}
