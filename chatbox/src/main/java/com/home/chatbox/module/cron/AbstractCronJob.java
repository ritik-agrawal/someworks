package com.home.chatbox.module.cron;

import com.home.chatbox.model.CronSchedule;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Slf4j
public abstract class AbstractCronJob implements Job {

    public abstract void execute();
    protected void postRun(){}

    private String cronCode;
    @Autowired private  CronScheduleService cronScheduleService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        long startTime = new Date().getTime();
        JobKey jobKey = jobExecutionContext.getTrigger().getJobKey();
        try{
            log.debug("Cron "+jobKey.getName()+"|"+jobKey.getGroup()+" started at "+ new Date().getTime());
            execute();
        }catch (Exception e){
            log.error("Cron Execution Failed with error: "+e.getMessage(),e);
        }finally {
            postRun();
            log.info("Cron "+jobKey.getName()+"|"+jobKey.getGroup()+" Finished in"+ (new Date().getTime() - startTime)+" ms");
        }
    }
}
