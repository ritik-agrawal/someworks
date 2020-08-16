package com.home.chatbox.module.cron;

import com.home.chatbox.model.CronSchedule;
import org.quartz.JobKey;

import java.util.Date;


public interface CronScheduleService {
    public Date schedule(CronSchedule cron);
    CronSchedule findByJobkey(JobKey jobKey);
}
