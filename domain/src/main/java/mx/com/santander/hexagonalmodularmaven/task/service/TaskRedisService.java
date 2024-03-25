package mx.com.santander.hexagonalmodularmaven.task.service;

import mx.com.santander.hexagonalmodularmaven.redis.port.RedisPort;

public class TaskRedisService {
	
	private final RedisPort redisPort;
	
	public TaskRedisService(RedisPort redisPort){
		this.redisPort = redisPort;
	}
	
	public String execute() {
		return redisPort.saveRedis();
	}

}
