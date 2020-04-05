package pers.qingyu.record.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static String ip = "192.168.10.103";
	private static int port = 6379;
	private static int maxConnect = 10000;
	private static int minFree = 100;
	private static int timeout = 10;
	private static JedisPool pool = null;

	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxConnect);
		config.setMaxIdle(minFree);
		config.setMaxWaitMillis(timeout);
		config.setTestOnBorrow(true);

//		pool = new JedisPool(config, ip, port, timeout);

	}

	public static Jedis getJedis() {
		if (pool != null) {
//			return pool.getResource();
			return new Jedis("192.168.10.103",6379);
		} else {
			return new Jedis("192.168.10.103",6379);
		}
	}

	public static void close(final Jedis redis) {
		if (redis != null) {
			redis.close();
		}
	}
}
