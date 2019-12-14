package org.ozaytunctan.components;

import java.util.concurrent.TimeUnit;

import org.ozaytunctan.exceptions.HazelcastException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class HazelcastCacheInstance implements CacheService {

	@Autowired
	private HazelcastInstance hazelcastInstance;

	@Override
	public Object get(String key) throws HazelcastException {
		IMap<String, Object> mapValues = hazelcastInstance.getMap(key);
		if (mapValues.isEmpty())
			throw new HazelcastException("Map key entry not found key:" + key);

		return mapValues.get(key);
	}

	@Override
	public Object get(String key, String subKey) throws HazelcastException {
		IMap<String, Object> mapValues = hazelcastInstance.getMap(key);
		if (mapValues.isEmpty())
			throw new HazelcastException("Map key entry not found key:" + key);

		return mapValues.get(subKey);
	}

	@Override
	public boolean put(String key, Object value) {
		IMap<String, Object> imap = this.hazelcastInstance.getMap(key);
		imap.put(key, value);
		return true;
	}

	@Override
	public boolean put(String key, String subKey, Object value) {
		IMap<String, Object> imap = this.hazelcastInstance.getMap(key);
		imap.put(subKey, value);
		return false;
	}

	@Override
	public boolean put(String key, Object value, Long expireSeconds) {
		IMap<String, Object> imap = this.hazelcastInstance.getMap(key);
		imap.put(key, value, expireSeconds, TimeUnit.MILLISECONDS);
		return true;
	}

	@Override
	public boolean put(String key, String subKey, Object value, Long expireSeconds) {
		IMap<String, Object> imap = this.hazelcastInstance.getMap(key);
		imap.put(subKey, value, expireSeconds, TimeUnit.MILLISECONDS);
		return false;
	}

	@Override
	public boolean delete(String key) {
		return false;
	}

	@Override
	public boolean delete(String key, String subKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
