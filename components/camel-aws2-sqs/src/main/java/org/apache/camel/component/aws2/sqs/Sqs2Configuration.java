/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.aws2.sqs;

import org.apache.camel.RuntimeCamelException;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import software.amazon.awssdk.core.Protocol;
import software.amazon.awssdk.services.sqs.SqsClient;

@UriParams
public class Sqs2Configuration implements Cloneable {

    // common properties
    private String queueName;
    @UriParam
    @Metadata(autowired = true)
    private SqsClient amazonSQSClient;
    @UriParam(label = "security", secret = true)
    private String accessKey;
    @UriParam(label = "security", secret = true)
    private String secretKey;
    @UriParam(defaultValue = "amazonaws.com")
    private String amazonAWSHost = "amazonaws.com";
    @UriParam(secret = true)
    private String queueOwnerAWSAccountId;
    @UriParam
    private String region;
    @UriParam(enums = "HTTP,HTTPS", defaultValue = "HTTPS")
    private Protocol proxyProtocol = Protocol.HTTPS;
    @UriParam(label = "proxy")
    private String proxyHost;
    @UriParam(label = "proxy")
    private Integer proxyPort;
    @UriParam(defaultValue = "true")
    private boolean autoCreateQueue = true;
    @UriParam(defaultValue = "false")
    private boolean trustAllCertificates;

    // consumer properties
    @UriParam(label = "consumer", defaultValue = "true")
    private boolean deleteAfterRead = true;
    @UriParam(label = "consumer", defaultValue = "true")
    private boolean deleteIfFiltered = true;
    @UriParam(label = "consumer")
    private Integer visibilityTimeout;
    @UriParam(label = "consumer")
    private String attributeNames;
    @UriParam(label = "consumer")
    private String messageAttributeNames;
    @UriParam(label = "consumer")
    private Integer waitTimeSeconds;
    @UriParam(label = "consumer")
    private Integer defaultVisibilityTimeout;
    @UriParam(label = "consumer")
    private boolean extendMessageVisibility;
    @UriParam(label = "consumer")
    private String kmsMasterKeyId;
    @UriParam(label = "consumer")
    private Integer kmsDataKeyReusePeriodSeconds;
    @UriParam(label = "consumer")
    private boolean serverSideEncryptionEnabled;
    @UriParam(label = "consumer", defaultValue = "1")
    private int concurrentConsumers = 1;
    @UriParam(label = "advanced")
    private String queueUrl;

    // producer properties
    @UriParam(label = "producer")
    private Integer delaySeconds;
    // producer properties
    @UriParam(label = "advanced")
    private boolean delayQueue;
    @UriParam(label = "producer", javaType = "java.lang.String", enums = "useConstant,useExchangeId,usePropertyValue")
    private MessageGroupIdStrategy messageGroupIdStrategy;
    @UriParam(label = "producer", javaType = "java.lang.String", defaultValue = "useExchangeId",
              enums = "useExchangeId,useContentBasedDeduplication")
    private MessageDeduplicationIdStrategy messageDeduplicationIdStrategy = new ExchangeIdMessageDeduplicationIdStrategy();
    @UriParam(label = "producer")
    private Sqs2Operations operation;

    // queue properties
    @UriParam(label = "queue")
    private Integer maximumMessageSize;
    @UriParam(label = "queue")
    private Integer messageRetentionPeriod;
    @UriParam(label = "queue")
    private Integer receiveMessageWaitTimeSeconds;
    @UriParam(label = "queue")
    private String policy;

    // dead letter queue properties
    @UriParam(label = "queue")
    private String redrivePolicy;

    // Likely used only for testing
    @UriParam(defaultValue = "https")
    private String protocol = "https";

    @UriParam(defaultValue = "false")
    private boolean useDefaultCredentialsProvider;

    /**
     * Whether or not the queue is a FIFO queue
     */
    boolean isFifoQueue() {
        // AWS docs suggest this is valid derivation.
        // FIFO queue names must end with .fifo, and standard queues cannot
        return queueName.endsWith(".fifo");
    }

    public String getAmazonAWSHost() {
        return amazonAWSHost;
    }

    /**
     * The hostname of the Amazon AWS cloud.
     */
    public void setAmazonAWSHost(String amazonAWSHost) {
        this.amazonAWSHost = amazonAWSHost;
    }

    public String getQueueName() {
        return queueName;
    }

    /**
     * Name of queue. The queue will be created if they don't already exists.
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Amazon AWS Access Key
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Amazon AWS Secret Key
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public boolean isDeleteAfterRead() {
        return deleteAfterRead;
    }

    /**
     * Delete message from SQS after it has been read
     */
    public void setDeleteAfterRead(boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    public SqsClient getAmazonSQSClient() {
        return amazonSQSClient;
    }

    /**
     * To use the AmazonSQS as client
     */
    public void setAmazonSQSClient(SqsClient amazonSQSClient) {
        this.amazonSQSClient = amazonSQSClient;
    }

    public Integer getVisibilityTimeout() {
        return visibilityTimeout;
    }

    /**
     * The duration (in seconds) that the received messages are hidden from subsequent retrieve requests after being
     * retrieved by a ReceiveMessage request to set in the com.amazonaws.services.sqs.model.SetQueueAttributesRequest.
     * This only make sense if its different from defaultVisibilityTimeout. It changes the queue visibility timeout
     * attribute permanently.
     */
    public void setVisibilityTimeout(Integer visibilityTimeout) {
        this.visibilityTimeout = visibilityTimeout;
    }

    public String getAttributeNames() {
        return attributeNames;
    }

    /**
     * A list of attribute names to receive when consuming. Multiple names can be separated by comma.
     */
    public void setAttributeNames(String attributeNames) {
        this.attributeNames = attributeNames;
    }

    public String getMessageAttributeNames() {
        return messageAttributeNames;
    }

    /**
     * A list of message attribute names to receive when consuming. Multiple names can be separated by comma.
     */
    public void setMessageAttributeNames(String messageAttributeNames) {
        this.messageAttributeNames = messageAttributeNames;
    }

    public Integer getDefaultVisibilityTimeout() {
        return defaultVisibilityTimeout;
    }

    /**
     * The default visibility timeout (in seconds)
     */
    public void setDefaultVisibilityTimeout(Integer defaultVisibilityTimeout) {
        this.defaultVisibilityTimeout = defaultVisibilityTimeout;
    }

    public Integer getDelaySeconds() {
        return delaySeconds;
    }

    /**
     * Delay sending messages for a number of seconds.
     */
    public void setDelaySeconds(Integer delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

    public boolean isDelayQueue() {
        return delayQueue;
    }

    /**
     * Define if you want to apply delaySeconds option to the queue or on single messages
     */
    public void setDelayQueue(boolean delayQueue) {
        this.delayQueue = delayQueue;
    }

    public Integer getMaximumMessageSize() {
        return maximumMessageSize;
    }

    /**
     * The maximumMessageSize (in bytes) an SQS message can contain for this queue.
     */
    public void setMaximumMessageSize(Integer maximumMessageSize) {
        this.maximumMessageSize = maximumMessageSize;
    }

    public Integer getMessageRetentionPeriod() {
        return messageRetentionPeriod;
    }

    /**
     * The messageRetentionPeriod (in seconds) a message will be retained by SQS for this queue.
     */
    public void setMessageRetentionPeriod(Integer messageRetentionPeriod) {
        this.messageRetentionPeriod = messageRetentionPeriod;
    }

    public String getPolicy() {
        return policy;
    }

    /**
     * The policy for this queue. It can be loaded by default from classpath, but you can prefix with "classpath:", "file:", or
     * "http:" to load the resource from different systems.
     */
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getRedrivePolicy() {
        return redrivePolicy;
    }

    /**
     * Specify the policy that send message to DeadLetter queue. See detail at Amazon docs.
     */
    public void setRedrivePolicy(String redrivePolicy) {
        this.redrivePolicy = redrivePolicy;
    }

    public boolean isExtendMessageVisibility() {
        return this.extendMessageVisibility;
    }

    /**
     * If enabled then a scheduled background task will keep extending the message visibility on SQS. This is needed if
     * it takes a long time to process the message. If set to true defaultVisibilityTimeout must be set. See details at
     * Amazon docs.
     */
    public void setExtendMessageVisibility(boolean extendMessageVisibility) {
        this.extendMessageVisibility = extendMessageVisibility;
    }

    public Integer getReceiveMessageWaitTimeSeconds() {
        return receiveMessageWaitTimeSeconds;
    }

    /**
     * If you do not specify WaitTimeSeconds in the request, the queue attribute ReceiveMessageWaitTimeSeconds is used
     * to determine how long to wait.
     */
    public void setReceiveMessageWaitTimeSeconds(Integer receiveMessageWaitTimeSeconds) {
        this.receiveMessageWaitTimeSeconds = receiveMessageWaitTimeSeconds;
    }

    public Integer getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    /**
     * Duration in seconds (0 to 20) that the ReceiveMessage action call will wait until a message is in the queue to
     * include in the response.
     */
    public void setWaitTimeSeconds(Integer waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public String getQueueOwnerAWSAccountId() {
        return queueOwnerAWSAccountId;
    }

    /**
     * Specify the queue owner aws account id when you need to connect the queue with different account owner.
     */
    public void setQueueOwnerAWSAccountId(String queueOwnerAWSAccountId) {
        this.queueOwnerAWSAccountId = queueOwnerAWSAccountId;
    }

    public boolean isDeleteIfFiltered() {
        return deleteIfFiltered;
    }

    /**
     * Whether or not to send the DeleteMessage to the SQS queue if an exchange fails to get through a filter. If
     * 'false' and exchange does not make it through a Camel filter upstream in the route, then don't send
     * DeleteMessage.
     */
    public void setDeleteIfFiltered(boolean deleteIfFiltered) {
        this.deleteIfFiltered = deleteIfFiltered;
    }

    public String getRegion() {
        return region;
    }

    /**
     * The region in which SQS client needs to work. When using this parameter, the configuration will expect the
     * lowercase name of the region (for example ap-east-1) You'll need to use the name Region.EU_WEST_1.id()
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public int getConcurrentConsumers() {
        return concurrentConsumers;
    }

    /**
     * Allows you to use multiple threads to poll the sqs queue to increase throughput
     */
    public void setConcurrentConsumers(int concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public String getQueueUrl() {
        return queueUrl;
    }

    /**
     * To define the queueUrl explicitly. All other parameters, which would influence the queueUrl, are ignored. This
     * parameter is intended to be used, to connect to a mock implementation of SQS, for testing purposes.
     */
    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    public Protocol getProxyProtocol() {
        return proxyProtocol;
    }

    /**
     * To define a proxy protocol when instantiating the SQS client
     */
    public void setProxyProtocol(Protocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * To define a proxy host when instantiating the SQS client
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    /**
     * To define a proxy port when instantiating the SQS client
     */
    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getKmsMasterKeyId() {
        return kmsMasterKeyId;
    }

    /**
     * The ID of an AWS-managed customer master key (CMK) for Amazon SQS or a custom CMK.
     */
    public void setKmsMasterKeyId(String kmsMasterKeyId) {
        this.kmsMasterKeyId = kmsMasterKeyId;
    }

    public Integer getKmsDataKeyReusePeriodSeconds() {
        return kmsDataKeyReusePeriodSeconds;
    }

    /**
     * The length of time, in seconds, for which Amazon SQS can reuse a data key to encrypt or decrypt messages before
     * calling AWS KMS again. An integer representing seconds, between 60 seconds (1 minute) and 86,400 seconds (24
     * hours). Default: 300 (5 minutes).
     */
    public void setKmsDataKeyReusePeriodSeconds(Integer kmsDataKeyReusePeriodSeconds) {
        this.kmsDataKeyReusePeriodSeconds = kmsDataKeyReusePeriodSeconds;
    }

    public boolean isServerSideEncryptionEnabled() {
        return serverSideEncryptionEnabled;
    }

    /**
     * Define if Server Side Encryption is enabled or not on the queue
     */
    public void setServerSideEncryptionEnabled(boolean serverSideEncryptionEnabled) {
        this.serverSideEncryptionEnabled = serverSideEncryptionEnabled;
    }

    /**
     * Only for FIFO queues. Strategy for setting the messageGroupId on the message. Can be one of the following
     * options: *useConstant*, *useExchangeId*, *usePropertyValue*. For the *usePropertyValue* option, the value of
     * property "CamelAwsMessageGroupId" will be used.
     */
    public void setMessageGroupIdStrategy(String strategy) {
        if ("useConstant".equalsIgnoreCase(strategy)) {
            messageGroupIdStrategy = new ConstantMessageGroupIdStrategy();
        } else if ("useExchangeId".equalsIgnoreCase(strategy)) {
            messageGroupIdStrategy = new ExchangeIdMessageGroupIdStrategy();
        } else if ("usePropertyValue".equalsIgnoreCase(strategy)) {
            messageGroupIdStrategy = new PropertyValueMessageGroupIdStrategy();
        } else {
            throw new IllegalArgumentException("Unrecognised MessageGroupIdStrategy: " + strategy);
        }
    }

    public void setMessageGroupIdStrategy(MessageGroupIdStrategy messageGroupIdStrategy) {
        this.messageGroupIdStrategy = messageGroupIdStrategy;
    }

    public MessageGroupIdStrategy getMessageGroupIdStrategy() {
        return messageGroupIdStrategy;
    }

    public MessageDeduplicationIdStrategy getMessageDeduplicationIdStrategy() {
        return messageDeduplicationIdStrategy;
    }

    /**
     * Only for FIFO queues. Strategy for setting the messageDeduplicationId on the message. Can be one of the following
     * options: *useExchangeId*, *useContentBasedDeduplication*. For the *useContentBasedDeduplication* option, no
     * messageDeduplicationId will be set on the message.
     */
    public void setMessageDeduplicationIdStrategy(String strategy) {
        if ("useExchangeId".equalsIgnoreCase(strategy)) {
            messageDeduplicationIdStrategy = new ExchangeIdMessageDeduplicationIdStrategy();
        } else if ("useContentBasedDeduplication".equalsIgnoreCase(strategy)) {
            messageDeduplicationIdStrategy = new NullMessageDeduplicationIdStrategy();
        } else {
            throw new IllegalArgumentException("Unrecognised MessageDeduplicationIdStrategy: " + strategy);
        }
    }

    public void setMessageDeduplicationIdStrategy(MessageDeduplicationIdStrategy messageDeduplicationIdStrategy) {
        this.messageDeduplicationIdStrategy = messageDeduplicationIdStrategy;
    }

    public Sqs2Operations getOperation() {
        return operation;
    }

    /**
     * The operation to do in case the user don't want to send only a message
     */
    public void setOperation(Sqs2Operations operation) {
        this.operation = operation;
    }

    public boolean isAutoCreateQueue() {
        return autoCreateQueue;
    }

    /**
     * Setting the autocreation of the queue
     */
    public void setAutoCreateQueue(boolean autoCreateQueue) {
        this.autoCreateQueue = autoCreateQueue;
    }

    public String getProtocol() {
        return protocol;
    }

    /**
     * The underlying protocol used to communicate with SQS
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean isTrustAllCertificates() {
        return trustAllCertificates;
    }

    /**
     * If we want to trust all certificates in case of overriding the endpoint
     */
    public void setTrustAllCertificates(boolean trustAllCertificates) {
        this.trustAllCertificates = trustAllCertificates;
    }

    public boolean isUseDefaultCredentialsProvider() {
        return useDefaultCredentialsProvider;
    }

    /**
     * Set whether the SQS client should expect to load credentials on an AWS infra instance or to expect static
     * credentials to be passed in.
     */
    public void setUseDefaultCredentialsProvider(boolean useDefaultCredentialsProvider) {
        this.useDefaultCredentialsProvider = useDefaultCredentialsProvider;
    }

    // *************************************************
    //
    // *************************************************

    public Sqs2Configuration copy() {
        try {
            return (Sqs2Configuration) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeCamelException(e);
        }
    }
}
