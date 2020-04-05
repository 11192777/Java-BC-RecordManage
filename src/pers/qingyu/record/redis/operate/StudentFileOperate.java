package pers.qingyu.record.redis.operate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.service.StudentService;
import pers.qingyu.record.util.RedisUtil;
import pers.qingyu.record.util.SerializeUtil;
import redis.clients.jedis.Jedis;

public class StudentFileOperate {

	public static void putStudentFile(StudentFile file) {
		Jedis redis = RedisUtil.getJedis();
		redis.set(new Long(file.getNumber()).toString().getBytes(), SerializeUtil.toSerialize(file));
		RedisUtil.close(redis);
	}

	public static StudentFile getStudentFile(long number) {
		Jedis redis = RedisUtil.getJedis();
		byte[] bytes = redis.get(new Long(number).toString().getBytes());

		StudentFile file = (StudentFile) SerializeUtil.unSerialize(bytes);
		RedisUtil.close(redis);
		return file;
	}
	

	public static void removeAllFile(ArrayList<StudentFile> files) {
		Jedis redis = RedisUtil.getJedis();
		for (StudentFile file : files) {
			if (getStudentFile(file.getNumber()) != null) {
				redis.del(new Long(file.getNumber()).toString().getBytes());
			}
		}
		RedisUtil.close(redis);
	}
	
	public static void deleteAll() {
		Jedis redis = RedisUtil.getJedis();
		Set<String> set = redis.keys("*");
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			redis.del(it.next());
		}
		
	}
}
