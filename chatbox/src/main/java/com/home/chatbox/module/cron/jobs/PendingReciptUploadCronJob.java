package com.home.chatbox.module.cron.jobs;

import com.home.chatbox.module.cron.AbstractCronJob;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class PendingReciptUploadCronJob extends AbstractCronJob {
    @Override
    public void execute() {
        log.info("Executing the pendingReceiptUploadCronJob at "+new Date().getTime());
    }
}
