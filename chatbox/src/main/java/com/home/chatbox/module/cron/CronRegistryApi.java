package com.home.chatbox.module.cron;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.home.chatbox.model.CronSchedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service("cronRegistryApi")
public class CronRegistryApi {
    private static List<CronSchedule> crons = new ArrayList<>();

    @PostConstruct
    private void init() throws IOException{
        long startTime = new Date().getTime();
        getCrons();
        long endTime = new Date().getTime();
        log.info("Loaded {} Crons in {} ms", crons.size(), (endTime - startTime));

    }

    private void getCrons() throws IOException{
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper
                .schemaFor(CronSchedule.class)
                .withColumnSeparator(',')
                .withHeader();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("crons.csv");
        MappingIterator<CronSchedule> it = mapper
                .readerFor(CronSchedule.class)
                .with(schema)
                .readValues(inputStream);

        while (it.hasNext()) {
            CronSchedule cronSchedule = it.next();
            crons.add(cronSchedule);
        }
    }
}
