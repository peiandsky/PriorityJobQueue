package com.saianfu.hxaf.jobqueue;

import com.saianfu.hxaf.jobqueue.network.NetworkUtil;

import java.util.*;

/**
 * This class is used when querying JobQueues to fetch particular jobs.
 * <p>
 * JobQueues should not reference this class after the query method returns because Constraints are
 * re-used by the JobManager.
 */
public class Constraint {
    @NetworkUtil.NetworkStatus private int maxNetworkType;
    private TagConstraint tagConstraint;
    private final Set<String> tags = new HashSet<>();
    private final List<String> excludeGroups = new ArrayList<>();
    private final List<String> excludeJobIds = new ArrayList<>();
    private boolean excludeRunning;
    private Long timeLimit;
    private long nowInNs;

    /**
     * Returns the max allowed network type
     * @return The max allowed network type for a job to match
     */
    public int getMaxNetworkType() {
        return maxNetworkType;
    }

    /**
     * The tag constraint to be used while querying with tags.
     *
     * @return The tag constraint to be used or null if there is no tag constraints.
     * @see #getTags()
     */
    public TagConstraint getTagConstraint() {
        return tagConstraint;
    }

    /**
     * The set of tags. If this list is not-empty, {@link #getTagConstraint()} will have a non-null
     * result.
     *
     * @return The set of tags
     * @see #getTagConstraint()
     */
    public Set<String> getTags() {
        return tags;
    }

    /**
     * The list of groups to be excluded. It is guaranteed to be ordered in natural string sorting
     * order.
     *
     * @return The set of job groups to exclude.
     */
    public List<String> getExcludeGroups() {
        return excludeGroups;
    }

    /**
     * Returns true if running jobs should be excluded from the query
     * @return True if running jobs should be excluded
     */
    public boolean excludeRunning() {
        return excludeRunning;
    }

    /**
     * Exclude jobs whose run time is after this time. Might be null if there is no time limit.
     * @return Time in NS which should be used to filter out delayed jobs
     */
    public Long getTimeLimit() {
        return timeLimit;
    }

    /**
     * The list of jobs ids that should be excluded from the result
     * @return The list of job ids that should be excluded from the result
     */
    public List<String> getExcludeJobIds() {
        return excludeJobIds;
    }

    void setMaxNetworkType(int maxNetworkType) {
        this.maxNetworkType = maxNetworkType;
    }

    void setTagConstraint(TagConstraint tagConstraint) {
        this.tagConstraint = tagConstraint;
    }

    void setExcludeRunning(boolean excludeRunning) {
        this.excludeRunning = excludeRunning;
    }

    void setTags(String[] tags) {
        this.tags.clear();
        if (tags != null) {
            Collections.addAll(this.tags, tags);
        }
    }

    public void setNowInNs(long nowInNs) {
        this.nowInNs = nowInNs;
    }

    void setExcludeGroups(Collection<String> excludeGroups) {
        this.excludeGroups.clear();
        if (excludeGroups != null) {
            this.excludeGroups.addAll(excludeGroups);
        }
    }

    void setExcludeJobIds(Collection<String> jobsIds) {
        this.excludeJobIds.clear();
        if (jobsIds != null) {
            this.excludeJobIds.addAll(jobsIds);
        }
    }

    public long getNowInNs() {
        return nowInNs;
    }

    void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    void clear() {
        maxNetworkType = NetworkUtil.UNMETERED;
        tagConstraint = null;
        tags.clear();
        excludeGroups.clear();
        excludeJobIds.clear();
        excludeRunning = false;
        timeLimit = null;
        nowInNs = Long.MIN_VALUE;
    }
}
