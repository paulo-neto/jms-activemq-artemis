package com.pauloneto.activemq.artemis.jms.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
* @author paulo.antonio@fornecedores.sicoob.com.br 
* @version 0.1 - 30 de out de 2019
*/
@MessageDriven(name="EmailMDB",
		activationConfig = {
				@ActivationConfigProperty(propertyName="destinationLookup", propertyValue="java:jboss/exported/jms/queue/RemoteEmailQueue"),
				@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
				@ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge"),
				
				
				 @ActivationConfigProperty(propertyName = "user",propertyValue = "paulo.neto"),
				 @ActivationConfigProperty(propertyName = "password",propertyValue = "java231074"),
				 @ActivationConfigProperty(propertyName = "transactionTimeout",propertyValue = "180"),
				 @ActivationConfigProperty(propertyName = "connectionParameters",propertyValue = "host=localhost;port=5445;httpUpgradeEnabled=true"),
				 @ActivationConfigProperty(propertyName = "connectorClassName",propertyValue = "org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory")
				})
public class EmailMDB implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
