
/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.twilio;

import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.twilio.rest.api.v2010.account.Notification}.
 */
@ApiParams(apiName = "notification", description = "",
           apiMethods = {@ApiMethod(methodName = "fetcher", description="Create a NotificationFetcher to execute fetch", signatures={"com.twilio.rest.api.v2010.account.NotificationFetcher fetcher(String pathSid)", "com.twilio.rest.api.v2010.account.NotificationFetcher fetcher(String pathAccountSid, String pathSid)"}), @ApiMethod(methodName = "reader", description="Create a NotificationReader to execute read", signatures={"com.twilio.rest.api.v2010.account.NotificationReader reader()", "com.twilio.rest.api.v2010.account.NotificationReader reader(String pathAccountSid)"}), })
@UriParams
@Configurer
public final class NotificationEndpointConfiguration extends TwilioConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "fetcher", description="The SID of the Account that created the resource to fetch"), @ApiMethod(methodName = "reader", description="The SID of the Account that created the resources to read")})
    private String pathAccountSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "fetcher", description="The unique string that identifies the resource")})
    private String pathSid;

    public String getPathAccountSid() {
        return pathAccountSid;
    }

    public void setPathAccountSid(String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public String getPathSid() {
        return pathSid;
    }

    public void setPathSid(String pathSid) {
        this.pathSid = pathSid;
    }
}
