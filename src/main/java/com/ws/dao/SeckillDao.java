package com.ws.dao;

import com.ws.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新库存的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀的商品信息
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param off
     * @param limit
     * @return
     * java没有保存形参的记录：queryAll(int offset, int limit) => queryAll(arg0, arg1)
     */
    List<Seckill> queryAll(@Param("off") int offset, @Param("limit") int limit);
}
