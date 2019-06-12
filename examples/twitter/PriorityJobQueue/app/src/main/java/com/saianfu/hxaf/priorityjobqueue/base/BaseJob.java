package com.saianfu.hxaf.priorityjobqueue.base;

import com.saianfu.hxaf.jobqueue.Job;
import com.saianfu.hxaf.jobqueue.Params;
import com.saianfu.hxaf.jobqueue.Priority;

/**
 * 重庆赛安服消防科技有限公司版权所有
 *
 * @author 裴存亮
 * @date：2019-06-12 13:02
 * 描述：TODO
 */
public abstract class BaseJob extends Job {
    protected BaseJob() {
        super(new Params(Priority.MID).setPersistent(false).requireNetwork());
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() {
        try {
            boolean rs = doInJob();
            if (rs) {
                sendEvent(successEvent);
            } else {
                sendEvent(failEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendEvent(failEvent);
        }
    }

    public abstract boolean doInJob();

    public abstract String getTag();

    /**
     * 发送事件
     *
     * @param event
     */
    public abstract void sendEvent(JobEvent event);

    @Override
    protected void onCancel() {
        sendEvent(cancelEvent);
    }

    @Override
    protected int getRetryLimit() {
        return 3;
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }

    private JobEvent successEvent = new JobEvent(JobEvent.SUCCESS, getTag(), "");
    private JobEvent failEvent = new JobEvent(JobEvent.FAIL, getTag(), "");
    private JobEvent cancelEvent = new JobEvent(JobEvent.CANCEL, getTag(), "");


    /**
     * 发送的事件
     */
    public static class JobEvent {
        public static final int SUCCESS = 0;
        public static final int FAIL = 1;
        public static final int CANCEL = 2;

        public JobEvent(int rs, String tag, String data) {
            this.result = rs;
            this.tag = tag;
            this.data = data;
        }

        private int result = -1;
        private String tag = "";
        private String data = "";

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }


    }
}
