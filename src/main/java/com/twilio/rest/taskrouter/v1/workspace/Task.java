/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends Resource {
    private static final long serialVersionUID = 37662678894198L;

    public enum Status {
        PENDING("pending"),
        RESERVED("reserved"),
        ASSIGNED("assigned"),
        CANCELED("canceled"),
        COMPLETED("completed");
    
        private final String value;
        
        private Status(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Status.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a TaskFetcher to execute fetch.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskFetcher capable of executing the fetch
     */
    public static TaskFetcher fetcher(final String workspaceSid, 
                                      final String sid) {
        return new TaskFetcher(workspaceSid, sid);
    }

    /**
     * Create a TaskUpdater to execute update.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskUpdater capable of executing the update
     */
    public static TaskUpdater updater(final String workspaceSid, 
                                      final String sid) {
        return new TaskUpdater(workspaceSid, sid);
    }

    /**
     * Create a TaskDeleter to execute delete.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskDeleter capable of executing the delete
     */
    public static TaskDeleter deleter(final String workspaceSid, 
                                      final String sid) {
        return new TaskDeleter(workspaceSid, sid);
    }

    /**
     * Create a TaskReader to execute read.
     * 
     * @param workspaceSid The workspace_sid
     * @return TaskReader capable of executing the read
     */
    public static TaskReader reader(final String workspaceSid) {
        return new TaskReader(workspaceSid);
    }

    /**
     * Create a TaskCreator to execute create.
     * 
     * @param workspaceSid The workspace_sid
     * @return TaskCreator capable of executing the create
     */
    public static TaskCreator creator(final String workspaceSid) {
        return new TaskCreator(workspaceSid);
    }

    /**
     * Converts a JSON String into a Task object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Task object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Integer age;
    private final Task.Status assignmentStatus;
    private final String attributes;
    private final String addons;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final Integer priority;
    private final String reason;
    private final String sid;
    private final String taskQueueSid;
    private final String taskQueueFriendlyName;
    private final String taskChannelSid;
    private final String taskChannelUniqueName;
    private final Integer timeout;
    private final String workflowSid;
    private final String workflowFriendlyName;
    private final String workspaceSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Task(@JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("age")
                 final Integer age, 
                 @JsonProperty("assignment_status")
                 final Task.Status assignmentStatus, 
                 @JsonProperty("attributes")
                 final String attributes, 
                 @JsonProperty("addons")
                 final String addons, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("priority")
                 final Integer priority, 
                 @JsonProperty("reason")
                 final String reason, 
                 @JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("task_queue_sid")
                 final String taskQueueSid, 
                 @JsonProperty("task_queue_friendly_name")
                 final String taskQueueFriendlyName, 
                 @JsonProperty("task_channel_sid")
                 final String taskChannelSid, 
                 @JsonProperty("task_channel_unique_name")
                 final String taskChannelUniqueName, 
                 @JsonProperty("timeout")
                 final Integer timeout, 
                 @JsonProperty("workflow_sid")
                 final String workflowSid, 
                 @JsonProperty("workflow_friendly_name")
                 final String workflowFriendlyName, 
                 @JsonProperty("workspace_sid")
                 final String workspaceSid, 
                 @JsonProperty("url")
                 final URI url, 
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.accountSid = accountSid;
        this.age = age;
        this.assignmentStatus = assignmentStatus;
        this.attributes = attributes;
        this.addons = addons;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.priority = priority;
        this.reason = reason;
        this.sid = sid;
        this.taskQueueSid = taskQueueSid;
        this.taskQueueFriendlyName = taskQueueFriendlyName;
        this.taskChannelSid = taskChannelSid;
        this.taskChannelUniqueName = taskChannelUniqueName;
        this.timeout = timeout;
        this.workflowSid = workflowSid;
        this.workflowFriendlyName = workflowFriendlyName;
        this.workspaceSid = workspaceSid;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The age.
     * 
     * @return The age
     */
    public final Integer getAge() {
        return this.age;
    }

    /**
     * Returns The The assignment_status.
     * 
     * @return The assignment_status
     */
    public final Task.Status getAssignmentStatus() {
        return this.assignmentStatus;
    }

    /**
     * Returns The The attributes.
     * 
     * @return The attributes
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The The addons.
     * 
     * @return The addons
     */
    public final String getAddons() {
        return this.addons;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The priority.
     * 
     * @return The priority
     */
    public final Integer getPriority() {
        return this.priority;
    }

    /**
     * Returns The The reason.
     * 
     * @return The reason
     */
    public final String getReason() {
        return this.reason;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The task_queue_sid.
     * 
     * @return The task_queue_sid
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * Returns The The task_queue_friendly_name.
     * 
     * @return The task_queue_friendly_name
     */
    public final String getTaskQueueFriendlyName() {
        return this.taskQueueFriendlyName;
    }

    /**
     * Returns The The task_channel_sid.
     * 
     * @return The task_channel_sid
     */
    public final String getTaskChannelSid() {
        return this.taskChannelSid;
    }

    /**
     * Returns The The task_channel_unique_name.
     * 
     * @return The task_channel_unique_name
     */
    public final String getTaskChannelUniqueName() {
        return this.taskChannelUniqueName;
    }

    /**
     * Returns The The timeout.
     * 
     * @return The timeout
     */
    public final Integer getTimeout() {
        return this.timeout;
    }

    /**
     * Returns The The workflow_sid.
     * 
     * @return The workflow_sid
     */
    public final String getWorkflowSid() {
        return this.workflowSid;
    }

    /**
     * Returns The The workflow_friendly_name.
     * 
     * @return The workflow_friendly_name
     */
    public final String getWorkflowFriendlyName() {
        return this.workflowFriendlyName;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Task other = (Task) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(age, other.age) && 
               Objects.equals(assignmentStatus, other.assignmentStatus) && 
               Objects.equals(attributes, other.attributes) && 
               Objects.equals(addons, other.addons) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(priority, other.priority) && 
               Objects.equals(reason, other.reason) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(taskQueueSid, other.taskQueueSid) && 
               Objects.equals(taskQueueFriendlyName, other.taskQueueFriendlyName) && 
               Objects.equals(taskChannelSid, other.taskChannelSid) && 
               Objects.equals(taskChannelUniqueName, other.taskChannelUniqueName) && 
               Objects.equals(timeout, other.timeout) && 
               Objects.equals(workflowSid, other.workflowSid) && 
               Objects.equals(workflowFriendlyName, other.workflowFriendlyName) && 
               Objects.equals(workspaceSid, other.workspaceSid) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            age,
                            assignmentStatus,
                            attributes,
                            addons,
                            dateCreated,
                            dateUpdated,
                            priority,
                            reason,
                            sid,
                            taskQueueSid,
                            taskQueueFriendlyName,
                            taskChannelSid,
                            taskChannelUniqueName,
                            timeout,
                            workflowSid,
                            workflowFriendlyName,
                            workspaceSid,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("age", age)
                          .add("assignmentStatus", assignmentStatus)
                          .add("attributes", attributes)
                          .add("addons", addons)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("priority", priority)
                          .add("reason", reason)
                          .add("sid", sid)
                          .add("taskQueueSid", taskQueueSid)
                          .add("taskQueueFriendlyName", taskQueueFriendlyName)
                          .add("taskChannelSid", taskChannelSid)
                          .add("taskChannelUniqueName", taskChannelUniqueName)
                          .add("timeout", timeout)
                          .add("workflowSid", workflowSid)
                          .add("workflowFriendlyName", workflowFriendlyName)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}