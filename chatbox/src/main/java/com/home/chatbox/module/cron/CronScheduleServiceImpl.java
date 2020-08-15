package com.home.chatbox.module.cron;

import com.home.chatbox.model.CronSchedule;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
@Service("cronScheduleService")
public class CronScheduleServiceImpl implements CronScheduleService {

    private static SchedulerFactory schedulerFactory;

    @Override
    public Date schedule(CronSchedule cron) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            String cronId = cron.getCronCode();
            String group = cron.getCronGroup();

            //Cron job definition
            JobKey jobKey = new JobKey(cronId, group);
            JobDetail job = newJob(cron.getExecutor())
                    .withIdentity(jobKey)
                    .usingJobData("cronCode",cron.getCronCode())
                    .build();

            //Cron Trigger
            TriggerKey triggerKey = new TriggerKey(cronId,group);
            CronExpression cronExpression = new CronExpression(cron.getCronExpression());

            Trigger trigger = newTrigger()
                    .withIdentity(triggerKey)
                    .withSchedule(cronSchedule(cronExpression))
                    .build();

            Date date = scheduler.scheduleJob(job, trigger);
            log.info("Cron Scheduled: " + cron + ". First Fire Time: " + date);
        }
        catch (Exception e){
            log.error("Cron couldn't be scheduled: " + this, e);
        }
        return null;
    }

    @Override
    public CronSchedule findByCronCode(String cronCode) {
        return null;
    }
}
