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
package org.apache.camel.impl.engine;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Experimental;
import org.apache.camel.ExtendedExchange;
import org.apache.camel.NonManagedService;
import org.apache.camel.StaticService;
import org.apache.camel.spi.ExchangeFactory;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.support.SynchronizationAdapter;
import org.apache.camel.support.service.ServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pooled {@link ExchangeFactory} that reuses {@link Exchange} instance from a pool.
 */
@Experimental
public class PooledExchangeFactory extends ServiceSupport
        implements ExchangeFactory, CamelContextAware, StaticService, NonManagedService {

    private static final Logger LOG = LoggerFactory.getLogger(PooledExchangeFactory.class);

    private final ReleaseOnCompletion onCompletion = new ReleaseOnCompletion();
    private final ConcurrentLinkedQueue<Exchange> pool = new ConcurrentLinkedQueue<>();
    private final AtomicLong acquired = new AtomicLong();
    private final AtomicLong created = new AtomicLong();
    private final AtomicLong released = new AtomicLong();

    private CamelContext camelContext;
    private boolean statisticsEnabled = true;

    @Override
    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Override
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public boolean isStatisticsEnabled() {
        return statisticsEnabled;
    }

    public void setStatisticsEnabled(boolean statisticsEnabled) {
        this.statisticsEnabled = statisticsEnabled;
    }

    @Override
    public Exchange create() {
        Exchange exchange = pool.poll();
        if (exchange == null) {
            if (statisticsEnabled) {
                created.incrementAndGet();
            }
            // create a new exchange as there was no free from the pool
            exchange = new DefaultExchange(camelContext);
        } else {
            if (statisticsEnabled) {
                acquired.incrementAndGet();
            }
            // reset exchange before we use it
            ExtendedExchange ee = exchange.adapt(ExtendedExchange.class);
            ee.reset();
        }
        // add on completion which will return the exchange when done
        exchange.adapt(ExtendedExchange.class).addOnCompletion(onCompletion);
        return exchange;
    }

    @Override
    public Exchange create(Endpoint fromEndpoint) {
        Exchange exchange = pool.poll();
        if (exchange == null) {
            if (statisticsEnabled) {
                created.incrementAndGet();
            }
            // create a new exchange as there was no free from the pool
            exchange = new DefaultExchange(fromEndpoint);
        } else {
            if (statisticsEnabled) {
                acquired.incrementAndGet();
            }
            // need to mark this exchange from the given endpoint
            exchange.adapt(ExtendedExchange.class).setFromEndpoint(fromEndpoint);
        }
        // add on completion which will return the exchange when done
        exchange.adapt(ExtendedExchange.class).addOnCompletion(onCompletion);
        return exchange;
    }

    @Override
    public void release(Exchange exchange) {
        if (statisticsEnabled) {
            released.incrementAndGet();
        }
        pool.offer(exchange);
    }

    @Override
    protected void doStop() throws Exception {
        pool.clear();

        if (statisticsEnabled) {
            LOG.info("PooledExchangeFactory usage [created: {}, acquired: {}, released: {}]", created.get(), acquired.get(),
                    released.get());
        }

        created.set(0);
        acquired.set(0);
        released.set(0);
    }

    private final class ReleaseOnCompletion extends SynchronizationAdapter {

        @Override
        public int getOrder() {
            // should be very very last so set as highest value possible
            return Integer.MAX_VALUE;
        }

        @Override
        public void onDone(Exchange exchange) {
            release(exchange);
        }
    }

}
