
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
 * Camel endpoint configuration for {@link com.twilio.rest.api.v2010.account.sip.credentiallist.Credential}.
 */
@ApiParams(apiName = "sip-credential-list-credential", description = "",
           apiMethods = {@ApiMethod(methodName = "creator", description="Create a CredentialCreator to execute create", signatures={"com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialCreator creator(String pathCredentialListSid, String username, String password)", "com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialCreator creator(String pathAccountSid, String pathCredentialListSid, String username, String password)"}), @ApiMethod(methodName = "deleter", description="Create a CredentialDeleter to execute delete", signatures={"com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialDeleter deleter(String pathCredentialListSid, String pathSid)", "com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialDeleter deleter(String pathAccountSid, String pathCredentialListSid, String pathSid)"}), @ApiMethod(methodName = "fetcher", description="Create a CredentialFetcher to execute fetch", signatures={"com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialFetcher fetcher(String pathCredentialListSid, String pathSid)", "com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialFetcher fetcher(String pathAccountSid, String pathCredentialListSid, String pathSid)"}), @ApiMethod(methodName = "reader", description="Create a CredentialReader to execute read", signatures={"com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialReader reader(String pathCredentialListSid)", "com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialReader reader(String pathAccountSid, String pathCredentialListSid)"}), @ApiMethod(methodName = "updater", description="Create a CredentialUpdater to execute update", signatures={"com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialUpdater updater(String pathCredentialListSid, String pathSid)", "com.twilio.rest.api.v2010.account.sip.credentiallist.CredentialUpdater updater(String pathAccountSid, String pathCredentialListSid, String pathSid)"}), })
@UriParams
@Configurer
public final class SipCredentialEndpointConfiguration extends TwilioConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The password will not be returned in the response")})
    private String password;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The unique id of the Account that is responsible for this resource"), @ApiMethod(methodName = "deleter", description="The unique id of the Account that is responsible for this resource"), @ApiMethod(methodName = "fetcher", description="The unique id of the Account that is responsible for this resource"), @ApiMethod(methodName = "reader", description="The unique id of the Account that is responsible for this resource"), @ApiMethod(methodName = "updater", description="The unique id of the Account that is responsible for this resource")})
    private String pathAccountSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The unique id that identifies the credential list to include the created credential"), @ApiMethod(methodName = "creator", description="The unique id that identifies the credential list to include the created credential"), @ApiMethod(methodName = "deleter", description="The unique id that identifies the credential list that contains the desired credentials"), @ApiMethod(methodName = "deleter", description="The unique id that identifies the credential list to include the created credential"), @ApiMethod(methodName = "fetcher", description="The unique id that identifies the credential list that contains the desired credential"), @ApiMethod(methodName = "fetcher", description="The unique id that identifies the credential list to include the created credential"), @ApiMethod(methodName = "reader", description="The unique id that identifies the credential list that contains the desired credentials"), @ApiMethod(methodName = "reader", description="The unique id that identifies the credential list to include the created credential"), @ApiMethod(methodName = "updater", description="The unique id that identifies the credential list that includes this credential"), @ApiMethod(methodName = "updater", description="The unique id that identifies the credential list to include the created credential")})
    private String pathCredentialListSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "deleter", description="The unique id that identifies the resource to delete"), @ApiMethod(methodName = "fetcher", description="The unique id that identifies the resource to fetch"), @ApiMethod(methodName = "updater", description="The unique id that identifies the resource to update")})
    private String pathSid;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "creator", description="The username for this credential")})
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPathAccountSid() {
        return pathAccountSid;
    }

    public void setPathAccountSid(String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public String getPathCredentialListSid() {
        return pathCredentialListSid;
    }

    public void setPathCredentialListSid(String pathCredentialListSid) {
        this.pathCredentialListSid = pathCredentialListSid;
    }

    public String getPathSid() {
        return pathSid;
    }

    public void setPathSid(String pathSid) {
        this.pathSid = pathSid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
