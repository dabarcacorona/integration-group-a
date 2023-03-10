package cl.corona.integrationgroupa.scheduler;

import cl.corona.integrationgroupa.service.IntDownload;
import cl.corona.integrationgroupa.service.IntUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private IntDownload intownload;

    @Autowired
    private IntUpload intupload;

    @Scheduled(cron = "${cron.expression}")
    public void scheduledJob() throws InterruptedException, IOException {

        LOG.info("{} : Inicio transferencia de archivos",
                dateTimeFormatter.format(LocalDateTime.now()));

        intownload.DownloadFile();
        intupload.UploadFile();

        LOG.info("{} : Fin transferencia de archivos",
                dateTimeFormatter.format(LocalDateTime.now()));

    }
}
