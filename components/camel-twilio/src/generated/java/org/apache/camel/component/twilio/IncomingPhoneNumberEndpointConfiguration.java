
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
 * Camel endpoint configuration for {@link com.twilio.rest.api.v2010.account.IncomingPhoneNumber}.
 */
@ApiParams(apiName = "incoming-phone-number", description = "",
           apiMethods = {@ApiMethod(methodName = "creator", description="Create a IncomingPhoneNumberCreator to execute create", signatures={"com.twilio.rest.api.v2010.account.IncomingPhoneNumberCreator creator(String areaCode)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberCreator creator(com.twilio.type.PhoneNumber phoneNumber)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberCreator creator(String pathAccountSid, String areaCode)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberCreator creator(String pathAccountSid, com.twilio.type.PhoneNumber phoneNumber)"}), @ApiMethod(methodName = "deleter", description="Create a IncomingPhoneNumberDeleter to execute delete", signatures={"com.twilio.rest.api.v2010.account.IncomingPhoneNumberDeleter deleter(String pathSid)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberDeleter deleter(String pathAccountSid, String pathSid)"}), @ApiMethod(methodName = "fetcher", description="Create a IncomingPhoneNumberFetcher to execute fetch", signatures={"com.twilio.rest.api.v2010.account.IncomingPhoneNumberFetcher fetcher(String pathSid)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberFetcher fetcher(String pathAccountSid, String pathSid)"}), @ApiMethod(methodName = "reader", description="Create a IncomingPhoneNumberReader to execute read", signatures={"com.twilio.rest.api.v2010.account.IncomingPhoneNumberReader reader()", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberReader reader(String pathAccountSid)"}), @ApiMethod(methodName = "updater", description="Create a IncomingPhoneNumberUpdater to execute update", signatures={"com.twilio.rest.api.v2010.account.IncomingPhoneNumberUpdater updater(String pathSid)", "com.twilio.rest.api.v2010.account.IncomingPhoneNumberUpdater updater(String pathAccountSid, String pathSid)"}), })
@UriParams
@Configurer
public final class IncomingPhoneNumberEndpointConfiguration extends TwilioConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The desired area code for the new phone number")})
    private String areaCode;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The SID of the Account that will create the resource"), @ApiMethod(methodName = "deleter", description="The SID of the Account that created the resources to delete"), @ApiMethod(methodName = "fetcher", description="The SID of the Account that created the resource to fetch"), @ApiMethod(methodName = "reader", description="The SID of the Account that created the resources to read"), @ApiMethod(methodName = "updater", description="The SID of the Account that created the resource to update")})
    private String pathAccountSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "deleter", description="The unique string that identifies the resource"), @ApiMethod(methodName = "fetcher", description="The unique string that identifies the resource"), @ApiMethod(methodName = "updater", description="The unique string that identifies the resource")})
    private String pathSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The phone number to purchase in E.164 format")})
    private com.twilio.type.PhoneNumber phoneNumber;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public com.twilio.type.PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
