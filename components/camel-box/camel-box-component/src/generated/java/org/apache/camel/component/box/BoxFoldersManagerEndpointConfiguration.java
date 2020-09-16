
/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.box;

import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link org.apache.camel.component.box.api.BoxFoldersManager}.
 */
@ApiParams(apiName = "folders", description = "Provides operations to manage Box folders",
           apiMethods = {@ApiMethod(methodName = "copyFolder", description="Copy folder to destination folder while optionally giving it a new name", signatures={"com.box.sdk.BoxFolder copyFolder(String folderId, String destinationFolderId, String newName)"}), @ApiMethod(methodName = "createFolder", description="Create a folder specified by path from parent folder with given parentFolderId, creating intermediate directories as required", signatures={"com.box.sdk.BoxFolder createFolder(String parentFolderId, String folderName)", "com.box.sdk.BoxFolder createFolder(String parentFolderId, String[] path)"}), @ApiMethod(methodName = "createFolderSharedLink", description="Create a shared link to folder", signatures={"com.box.sdk.BoxSharedLink createFolderSharedLink(String folderId, com.box.sdk.BoxSharedLink$Access access, java.util.Date unshareDate, com.box.sdk.BoxSharedLink$Permissions permissions)"}), @ApiMethod(methodName = "deleteFolder", description="Delete folder", signatures={"void deleteFolder(String folderId)"}), @ApiMethod(methodName = "getFolder", description="Return the Box folder referenced by path", signatures={"com.box.sdk.BoxFolder getFolder(String[] path)"}), @ApiMethod(methodName = "getFolderInfo", description="Get folder information", signatures={"com.box.sdk.BoxFolder$Info getFolderInfo(String folderId, String[] fields)"}), @ApiMethod(methodName = "getFolderItems", description="Returns a specific range of child items in folder and specifies which fields of each item to retrieve", signatures={"java.util.Collection<com.box.sdk.BoxItem$Info> getFolderItems(String folderId, Long offset, Long limit, String[] fields)"}), @ApiMethod(methodName = "getRootFolder", description="Return the root folder of authenticated user", signatures={"com.box.sdk.BoxFolder getRootFolder()"}), @ApiMethod(methodName = "moveFolder", description="Move folder to destination folder while optionally giving it a new name", signatures={"com.box.sdk.BoxFolder moveFolder(String folderId, String destinationFolderId, String newName)"}), @ApiMethod(methodName = "renameFolder", description="Rename folder giving it the name newName", signatures={"com.box.sdk.BoxFolder renameFolder(String folderId, String newFolderName)"}), @ApiMethod(methodName = "updateFolderInfo", description="Update folder information", signatures={"com.box.sdk.BoxFolder updateFolderInfo(String folderId, com.box.sdk.BoxFolder$Info info)"})})
@UriParams
@Configurer
public final class BoxFoldersManagerEndpointConfiguration extends BoxConfiguration {
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolderSharedLink", description="The access level of the shared link")})
    private com.box.sdk.BoxSharedLink.Access access;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "copyFolder", description="The id of the destination folder"), @ApiMethod(methodName = "moveFolder", description="The id of the destination folder")})
    private String destinationFolderId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "getFolderInfo", description="The information fields to retrieve; if null all information fields are retrieved."), @ApiMethod(methodName = "getFolderItems", description="The item fields to retrieve for each child item; if null all item fields are retrieved.")})
    private String[] fields;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "copyFolder", description="The id of folder to copy"), @ApiMethod(methodName = "createFolderSharedLink", description="The id of folder to create shared link on"), @ApiMethod(methodName = "deleteFolder", description="The id of folder to delete"), @ApiMethod(methodName = "getFolderInfo", description="The id of folder"), @ApiMethod(methodName = "getFolderItems", description="The id of folder"), @ApiMethod(methodName = "moveFolder", description="The id of folder to move"), @ApiMethod(methodName = "renameFolder", description="The id of folder to rename"), @ApiMethod(methodName = "updateFolderInfo", description="The id of folder to update")})
    private String folderId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolder", description="The name of created folder")})
    private String folderName;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "updateFolderInfo", description="The updated information")})
    private com.box.sdk.BoxFolder.Info info;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "getFolderItems", description="The maximum number of children to retrieve after the offset; if null all child items are retrieved.")})
    private Long limit;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "renameFolder", description="The new name of folder")})
    private String newFolderName;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "copyFolder", description="The new name for copied folder; if newName is null, the copied folder has same name as the original."), @ApiMethod(methodName = "moveFolder", description="The new name of moved folder; if newName is null, the moved folder has same name as the original.")})
    private String newName;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "getFolderItems", description="The index of first child item to retrieve; if null all child items are retrieved.")})
    private Long offset;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolder", description="The id of parent folder")})
    private String parentFolderId;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolder", description="Sequence of Box folder names from parent folder to returned folder"), @ApiMethod(methodName = "getFolder", description="Sequence of Box folder names from root folder to returned folder")})
    private String[] path;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolderSharedLink", description="The permissions of the created link; if permissions is null then the created shared link is create with default permissions.")})
    private com.box.sdk.BoxSharedLink.Permissions permissions;
    @UriParam
    @ApiParam(apiMethods = {@ApiMethod(methodName = "createFolderSharedLink", description="The date and time at which time the created shared link will expire; if unsharedDate is null then a non-expiring link is created.")})
    private java.util.Date unshareDate;

    public com.box.sdk.BoxSharedLink.Access getAccess() {
        return access;
    }

    public void setAccess(com.box.sdk.BoxSharedLink.Access access) {
        this.access = access;
    }

    public String getDestinationFolderId() {
        return destinationFolderId;
    }

    public void setDestinationFolderId(String destinationFolderId) {
        this.destinationFolderId = destinationFolderId;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public com.box.sdk.BoxFolder.Info getInfo() {
        return info;
    }

    public void setInfo(com.box.sdk.BoxFolder.Info info) {
        this.info = info;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getNewFolderName() {
        return newFolderName;
    }

    public void setNewFolderName(String newFolderName) {
        this.newFolderName = newFolderName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
        this.parentFolderId = parentFolderId;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public com.box.sdk.BoxSharedLink.Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(com.box.sdk.BoxSharedLink.Permissions permissions) {
        this.permissions = permissions;
    }

    public java.util.Date getUnshareDate() {
        return unshareDate;
    }

    public void setUnshareDate(java.util.Date unshareDate) {
        this.unshareDate = unshareDate;
    }
}
