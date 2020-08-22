package com.home.chatbox.module.cron.jobs;

import com.home.chatbox.module.cron.AbstractCronJob;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Date;

@Slf4j
public class PendingReciptUploadCronJob extends AbstractCronJob {
    @Override
    public void execute() {
        log.info("Executing the pendingReceiptUploadCronJob at "+new Date().getTime());
        File dir = new File("/home/ritik/Downloads/recipts");
        File[] files = dir.listFiles();
        if (null != files && files.length > 0){
            for (File file : files){
                log.info("Recipt:"+file.getName());
            }
        }
    }
}
