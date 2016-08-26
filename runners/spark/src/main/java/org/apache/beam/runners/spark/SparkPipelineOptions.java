/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.beam.runners.spark;

import org.apache.beam.sdk.options.ApplicationNameOptions;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.StreamingOptions;

/**
 * Spark runner pipeline options.
 */
public interface SparkPipelineOptions extends PipelineOptions, StreamingOptions,
                                              ApplicationNameOptions {
  @Description("The url of the spark master to connect to, (e.g. spark://host:port, local[4]).")
  @Default.String("local[1]")
  String getSparkMaster();
  void setSparkMaster(String master);

  @Description("Timeout to wait (in msec) for a streaming execution to stop, -1 runs until "
          + "execution is stopped")
  @Default.Long(-1)
  Long getTimeout();
  void setTimeout(Long timeoutMillis);

  @Description("Batch interval for Spark streaming in milliseconds.")
  @Default.Long(1000)
  Long getBatchIntervalMillis();
  void setBatchIntervalMillis(Long batchInterval);

  @Description("Enable/disable sending aggregator values to Spark's metric sinks")
  @Default.Boolean(true)
  Boolean getEnableSparkSinks();
  void setEnableSparkSinks(Boolean enableSparkSinks);
}
