package com.home.chatbox.model;

import com.home.chatbox.module.cron.AbstractCronJob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CronSchedule {

    private String cronCode;
    private String cronGroup;
    private String cronExpression;
    private String status;
    private Class<? extends AbstractCronJob> executor;
}
