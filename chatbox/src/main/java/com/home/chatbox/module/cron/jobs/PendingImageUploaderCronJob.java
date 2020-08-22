package com.home.chatbox.module.cron.jobs;

import com.home.chatbox.module.cron.AbstractCronJob;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
@Slf4j
public class PendingImageUploaderCronJob extends AbstractCronJob {
    @Override
    public void execute() {
        log.info("Executing the pendingImageUploadCronJob at "+new Date().getTime());
    }
}
