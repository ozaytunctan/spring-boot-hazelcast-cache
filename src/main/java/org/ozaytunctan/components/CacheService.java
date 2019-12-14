package org.ozaytunctan.components;

import org.ozaytunctan.exceptions.HazelcastException;

public interface CacheService {

	public Object get(String key) throws HazelcastException;

	public Object get(String key, String subKey) throws HazelcastException;

	public boolean put(String key, Object value);

	public boolean put(String key, String subKey, Object value);

	public boolean put(String key, Object value, Long expireSeconds);

	public boolean put(String key, String subKey, Object value, Long expireSeconds);

	public boolean delete(String key);

	public boolean delete(String key, String subKey);

	public boolean clearAll();
}
