
/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.braintree;

import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.braintreegateway.DisputeGateway}.
 */
@ApiParams(apiName = "dispute", description = "Provides methods to interact with Dispute objects",
           apiMethods = {@ApiMethod(methodName = "accept", description="Accept a Dispute, given a dispute ID", signatures={"com.braintreegateway.Result<com.braintreegateway.Dispute> accept(String id)"}), @ApiMethod(methodName = "addFileEvidence", description="Add File Evidence to a Dispute, given an ID and a FileEvidenceRequest File evidence request", signatures={"com.braintreegateway.Result<com.braintreegateway.DisputeEvidence> addFileEvidence(String disputeId, String documentId)", "com.braintreegateway.Result<com.braintreegateway.DisputeEvidence> addFileEvidence(String disputeId, com.braintreegateway.FileEvidenceRequest fileEvidenceRequest)"}), @ApiMethod(methodName = "addTextEvidence", description="Add Text Evidence to a Dispute, given an ID and content", signatures={"com.braintreegateway.Result<com.braintreegateway.DisputeEvidence> addTextEvidence(String id, String content)", "com.braintreegateway.Result<com.braintreegateway.DisputeEvidence> addTextEvidence(String id, com.braintreegateway.TextEvidenceRequest textEvidenceRequest)"}), @ApiMethod(methodName = "finalize", description="Finalize a Dispute, given an ID", signatures={"com.braintreegateway.Result<com.braintreegateway.Dispute> finalize(String id)"}), @ApiMethod(methodName = "find", description="Returns a Dispute, given an ID", signatures={"com.braintreegateway.Dispute find(String id)"}), @ApiMethod(methodName = "removeEvidence", description="Remove Evidence from a Dispute, given an ID and a DisputeEvidence ID", signatures={"com.braintreegateway.Result<com.braintreegateway.Dispute> removeEvidence(String disputeId, String evidenceId)"}), @ApiMethod(methodName = "search", description="Finds all Disputes that match the query", signatures={"com.braintreegateway.PaginatedCollection<com.braintreegateway.Dispute> search(com.braintreegateway.DisputeSearchRequest query)"})})
@UriParams
@Configurer
public final class DisputeGatewayEndpointConfiguration extends BraintreeConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "addTextEvidence", description="The content of the text evidence for the dispute")})
    private String content;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "addFileEvidence", description="The dispute id to add text evidence to"), @ApiMethod(methodName = "removeEvidence", description="The dispute id to remove evidence from")})
    private String disputeId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "addFileEvidence", description="The document id of a previously uploaded document")})
    private String documentId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "removeEvidence", description="The evidence id to remove")})
    private String evidenceId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "addFileEvidence", description="The file evidence request for the dispute")})
    private com.braintreegateway.FileEvidenceRequest fileEvidenceRequest;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "accept", description="The dispute id to accept"), @ApiMethod(methodName = "addTextEvidence", description="The dispute id to add text evidence to"), @ApiMethod(methodName = "finalize", description="The dispute id to finalize"), @ApiMethod(methodName = "find", description="The dispute id to find")})
    private String id;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "search", description="The query for what disputes to find")})
    private com.braintreegateway.DisputeSearchRequest query;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "addTextEvidence", description="The text evidence request for the dispute")})
    private com.braintreegateway.TextEvidenceRequest textEvidenceRequest;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEvidenceId() {
        return evidenceId;
    }

    public void setEvidenceId(String evidenceId) {
        this.evidenceId = evidenceId;
    }

    public com.braintreegateway.FileEvidenceRequest getFileEvidenceRequest() {
        return fileEvidenceRequest;
    }

    public void setFileEvidenceRequest(com.braintreegateway.FileEvidenceRequest fileEvidenceRequest) {
        this.fileEvidenceRequest = fileEvidenceRequest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public com.braintreegateway.DisputeSearchRequest getQuery() {
        return query;
    }

    public void setQuery(com.braintreegateway.DisputeSearchRequest query) {
        this.query = query;
    }

    public com.braintreegateway.TextEvidenceRequest getTextEvidenceRequest() {
        return textEvidenceRequest;
    }

    public void setTextEvidenceRequest(com.braintreegateway.TextEvidenceRequest textEvidenceRequest) {
        this.textEvidenceRequest = textEvidenceRequest;
    }
}
