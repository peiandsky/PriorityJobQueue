package com.saianfu.hxaf.jobqueue.di;

import com.saianfu.hxaf.jobqueue.Job;

/**
 * interface that can be provided to { com.birbit.android.jobqueue.JobManager} for dependency injection
 * it is called before the job's onAdded method is called. for persistent jobs, also run after job is brought
 * back from disk.
 */
public interface DependencyInjector {
    void inject(Job job);
}
