/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.aws.sqs.source;

/**
 * Utility class that provides handy methods to construct SQS Source Config for testing
 */
public class SqsSourceConfigHelper {

  public static final String TEST_REF_NAME = "TestRefName";
  public static final String TEST_ACCESS_ID = "test-access-id";
  public static final String TEST_ACCESS_KEY = "test-access-key";
  public static final String TEST_SQS_ENDPOINT = "TestSqsEndpoint";
  public static final String TEST_REGION = "us-east-1";
  public static final String TEST_QUEUE_NAME = "TestQueue";
  public static final String TEST_SCHEMA = "{" +
    "          \"name\": \"etlSchemaBody\",\n" +
    "          \"type\": \"record\",\n" +
    "          \"fields\": [\n" +
    "            {\n" +
    "              \"name\": \"message\",\n" +
    "              \"type\": \"bytes\"\n" +
    "            }\n" +
    "          ]\n" +
    "        }";

  public static ConfigBuilder newConfigBuilder() {
    return new ConfigBuilder();
  }

  public static class ConfigBuilder {
    private String referenceName = TEST_REF_NAME;
    private String authenticationMethod = "";
    private String accessId = TEST_ACCESS_ID;
    private String accessKey = TEST_ACCESS_KEY;
    private String sqsEndpoint = TEST_SQS_ENDPOINT;
    private String region = TEST_REGION;
    private String queueName = TEST_QUEUE_NAME;
    private Boolean delete = false;
    private Integer interval = 1;
    private Integer waitTime = 20;
    private Integer numberOfMessages = 10;
    private String format = "";
    private String schema = TEST_SCHEMA;

    public ConfigBuilder setReferenceName(String referenceName) {
      this.referenceName = referenceName;
      return this;
    }

    public ConfigBuilder setAuthenticationMethod(String authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
      return this;
    }

    public ConfigBuilder setAccessId(String accessId) {
      this.accessId = accessId;
      return this;
    }

    public ConfigBuilder setAccessKey(String accessKey) {
      this.accessKey = accessKey;
      return this;
    }

    public ConfigBuilder setSqsEndpoint(String sqsEndpoint) {
      this.sqsEndpoint = sqsEndpoint;
      return this;
    }

    public ConfigBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ConfigBuilder setQueueName(String queueName) {
      this.queueName = queueName;
      return this;
    }

    public ConfigBuilder setDelete(Boolean delete) {
      this.delete = delete;
      return this;
    }

    public ConfigBuilder setInterval(Integer interval) {
      this.interval = interval;
      return this;
    }

    public ConfigBuilder setWaitTime(Integer waitTime) {
      this.waitTime = waitTime;
      return this;
    }

    public ConfigBuilder setNumberOfMessages(Integer numberOfMessages) {
      this.numberOfMessages = numberOfMessages;
      return this;
    }

    public ConfigBuilder setFormat(String format) {
      this.format = format;
      return this;
    }

    public ConfigBuilder setSchema(String schema) {
      this.schema = schema;
      return this;
    }

    public SqsSourceConfig build() {
      return new SqsSourceConfig(referenceName, authenticationMethod, accessId, accessKey, region, queueName,
        sqsEndpoint, delete, interval, waitTime, numberOfMessages, format, schema);
    }

  }

}
