package com.saianfu.hxaf.priorityjobqueue;

import com.saianfu.hxaf.priorityjobqueue.base.BaseJob;

/**
 * 重庆赛安服消防科技有限公司版权所有
 *
 * @author 裴存亮
 * @date： 2019-06-12 13:32
 * 描述：TODO
 */
public class TestJob extends BaseJob {
    private int taskId;
    
    public TestJob(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean doInJob() {
        System.out.println("TestJob:" + taskId);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String getTag() {
        return "TestJob-" + taskId;
    }

    @Override
    public void sendEvent(JobEvent event) {
        System.out.println("sendEvent:" + event.getResult() + "---");
    }

}
