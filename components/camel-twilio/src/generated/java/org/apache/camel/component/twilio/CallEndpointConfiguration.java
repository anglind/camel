
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
 * Camel endpoint configuration for {@link com.twilio.rest.api.v2010.account.Call}.
 */
@ApiParams(apiName = "call", description = "",
           apiMethods = {@ApiMethod(methodName = "creator", description="Create a CallCreator to execute create", signatures={"com.twilio.rest.api.v2010.account.CallCreator creator(com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, String applicationSid)", "com.twilio.rest.api.v2010.account.CallCreator creator(com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, com.twilio.type.Twiml twiml)", "com.twilio.rest.api.v2010.account.CallCreator creator(com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, java.net.URI url)", "com.twilio.rest.api.v2010.account.CallCreator creator(String pathAccountSid, com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, String applicationSid)", "com.twilio.rest.api.v2010.account.CallCreator creator(String pathAccountSid, com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, com.twilio.type.Twiml twiml)", "com.twilio.rest.api.v2010.account.CallCreator creator(String pathAccountSid, com.twilio.type.Endpoint to, com.twilio.type.Endpoint from, java.net.URI url)"}), @ApiMethod(methodName = "deleter", description="Create a CallDeleter to execute delete", signatures={"com.twilio.rest.api.v2010.account.CallDeleter deleter(String pathSid)", "com.twilio.rest.api.v2010.account.CallDeleter deleter(String pathAccountSid, String pathSid)"}), @ApiMethod(methodName = "fetcher", description="Create a CallFetcher to execute fetch", signatures={"com.twilio.rest.api.v2010.account.CallFetcher fetcher(String pathSid)", "com.twilio.rest.api.v2010.account.CallFetcher fetcher(String pathAccountSid, String pathSid)"}), @ApiMethod(methodName = "reader", description="Create a CallReader to execute read", signatures={"com.twilio.rest.api.v2010.account.CallReader reader()", "com.twilio.rest.api.v2010.account.CallReader reader(String pathAccountSid)"}), @ApiMethod(methodName = "updater", description="Create a CallUpdater to execute update", signatures={"com.twilio.rest.api.v2010.account.CallUpdater updater(String pathSid)", "com.twilio.rest.api.v2010.account.CallUpdater updater(String pathAccountSid, String pathSid)"}), })
@UriParams
@Configurer
public final class CallEndpointConfiguration extends TwilioConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The SID of the Application resource that will handle the call")})
    private String applicationSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="Twilio number from which to originate the call")})
    private com.twilio.type.Endpoint from;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The SID of the Account that will create the resource"), @ApiMethod(methodName = "deleter", description="The SID of the Account that created the resource(s) to delete"), @ApiMethod(methodName = "fetcher", description="The SID of the Account that created the resource(s) to fetch"), @ApiMethod(methodName = "reader", description="The SID of the Account that created the resource(s) to read"), @ApiMethod(methodName = "updater", description="The SID of the Account that created the resource(s) to update")})
    private String pathAccountSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "deleter", description="The unique string that identifies this resource"), @ApiMethod(methodName = "fetcher", description="The SID of the Call resource to fetch"), @ApiMethod(methodName = "updater", description="The unique string that identifies this resource")})
    private String pathSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="Phone number, SIP address, or client identifier to call")})
    private com.twilio.type.Endpoint to;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="TwiML instructions for the call")})
    private com.twilio.type.Twiml twiml;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The absolute URL that returns TwiML for this call")})
    private java.net.URI url;

    public String getApplicationSid() {
        return applicationSid;
    }

    public void setApplicationSid(String applicationSid) {
        this.applicationSid = applicationSid;
    }

    public com.twilio.type.Endpoint getFrom() {
        return from;
    }

    public void setFrom(com.twilio.type.Endpoint from) {
        this.from = from;
    }

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

    public com.twilio.type.Endpoint getTo() {
        return to;
    }

    public void setTo(com.twilio.type.Endpoint to) {
        this.to = to;
    }

    public com.twilio.type.Twiml getTwiml() {
        return twiml;
    }

    public void setTwiml(com.twilio.type.Twiml twiml) {
        this.twiml = twiml;
    }

    public java.net.URI getUrl() {
        return url;
    }

    public void setUrl(java.net.URI url) {
        this.url = url;
    }
}
