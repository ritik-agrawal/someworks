package com.home.chatbox.module.cron;

import com.home.chatbox.model.CronSchedule;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Slf4j
public abstract class AbstractCronJob implements Job {

    public abstract void execute();
    protected void postRun(){}

    private String cronCode;
    @Autowired private  CronScheduleService cronScheduleService;

    protected CronSchedule getCronSchedule(){
        return cronScheduleService.findByCronCode(cronCode);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        long startTime = new Date().getTime();
        CronSchedule cs = getCronSchedule();
        try{
            log.debug("Cron "+cs.getCronCode()+" started at "+ new Date().getTime());
        }catch (Exception e){
            log.error("Cron Execution Failed with error: "+e.getMessage(),e);
        }finally {
            postRun();
            log.info("Cron "+cs.getCronCode()+" Finished in"+ (new Date().getTime() - startTime)+" ms");
        }
    }
}
