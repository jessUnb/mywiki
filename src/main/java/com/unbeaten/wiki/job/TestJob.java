//package com.unbeaten.wiki.job;
//
//import com.unbeaten.wiki.mapper.DocMapperCust;
//import com.unbeaten.wiki.service.impl.DocServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//public class TestJob {
//
//    @Resource
//    DocServiceImpl docService;
//   private static final Logger LOG = LoggerFactory.getLogger(TestJob.class);
//
//   /**
//    * 固定时间间隔，fixedRate单位毫秒
//    */
//   @Scheduled(fixedRate = 1000)
//   public void simple() throws InterruptedException {
//       SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
//       String dateString = formatter.format(new Date());
//       Thread.sleep(2000);
//       LOG.info("每隔5秒钟执行一次： {}", dateString);
//   }
//
//   /**
//    * 自定义cron表达式跑批
//    * 只有等上一次执行完成，下一次才会在下一个时间点执行，错过就错过
//    */
//   @Scheduled(cron = "5/30 * * * * ?")
//   public void cron() throws InterruptedException {
//       SimpleDateFormat formatter = new SimpleDateFormat("mm:ss SSS");
//       String dateString = formatter.format(new Date());
//       Thread.sleep(1500);
//       docService.updateEbookInfo();
//       LOG.info("每隔1秒钟执行一次： {}", dateString);
//   }
//
//}