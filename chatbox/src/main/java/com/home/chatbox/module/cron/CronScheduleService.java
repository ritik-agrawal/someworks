package com.home.chatbox.module.cron;

import com.home.chatbox.model.CronSchedule;

import java.util.Date;


public interface CronScheduleService {
    public Date schedule(CronSchedule cron);
    CronSchedule findByCronCode(String cronCode);
}
