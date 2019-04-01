package com.alex.service.impl;

import com.alex.service.HistoryService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Resource
    private JedisPool jedisPool;

    @Override
    public void save2Redis(Map<String, String> param) {
        Jedis jedis = jedisPool.getResource();
        jedis.hmset("history:1",param);
        jedis.close();
    }
}
