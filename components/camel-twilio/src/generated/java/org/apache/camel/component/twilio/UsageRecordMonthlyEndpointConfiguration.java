
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
 * Camel endpoint configuration for {@link com.twilio.rest.api.v2010.account.usage.record.Monthly}.
 */
@ApiParams(apiName = "usage-record-monthly", description = "",
           apiMethods = {@ApiMethod(methodName = "reader", description="Create a MonthlyReader to execute read", signatures={"com.twilio.rest.api.v2010.account.usage.record.MonthlyReader reader()", "com.twilio.rest.api.v2010.account.usage.record.MonthlyReader reader(String pathAccountSid)"}), })
@UriParams
@Configurer
public final class UsageRecordMonthlyEndpointConfiguration extends TwilioConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "reader", description="The SID of the Account that created the resources to read")})
    private String pathAccountSid;

    public String getPathAccountSid() {
        return pathAccountSid;
    }

    public void setPathAccountSid(String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }
}
