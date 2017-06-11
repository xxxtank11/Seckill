package com.ws.service;

import com.ws.dto.Exposer;
import com.ws.dto.SeckillExecution;
import com.ws.entity.Seckill;
import com.ws.exception.RepeatKillException;
import com.ws.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    //测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id =1002;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 13990875643L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.excuteSeckill(id,phone,md5);
                logger.info("result={}",seckillExecution);
            } catch (SeckillCloseException e){
                logger.error(e.getMessage());
            } catch (RepeatKillException e){
                logger.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckillProcedure(){
        long seckillId = 1002;
        long phone  = 13388995566L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()){
            SeckillExecution seckillExecution = seckillService.excuteSeckillProcedure(seckillId,phone,exposer.getMd5());
            logger.info(seckillExecution.getStateInfo());
        }

    }

//    @Test
//    public void excuteSeckill() throws Exception {
//        /**
//         * Exposer{
//         * exposed=true,
//         * md5='a6d280d582cfeb58dbd3f8996ec7d820',
//         * seckillId=1000,
//         * now=0,
//         * start=0,
//         * end=0}
//         */
//        long id = 1000;
//        long phone = 13990875643L;
//        String md5 = "a6d280d582cfeb58dbd3f8996ec7d820";
//        try {
//            SeckillExecution seckillExecution = seckillService.excuteSeckill(id,phone,md5);
//            logger.info("result={}",seckillExecution);
//        } catch (SeckillCloseException e){
//            logger.error(e.getMessage());
//        } catch (RepeatKillException e){
//            logger.error(e.getMessage());
//        }
//    }

}