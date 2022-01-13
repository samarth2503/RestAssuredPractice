package DataShare;

import java.util.LinkedHashMap;

public class ThreadLocalDatastoreAsMap {
	
	private ThreadLocalDatastoreAsMap() {}
	
	private static ThreadLocal<LinkedHashMap<String,Object>> dataMap = ThreadLocal.withInitial(()-> new LinkedHashMap<String,Object>());
	
	public static void setValue(String key,String value)
	{
		dataMap.get().put(key, value);
	}
	
	public static void getValue(String key)
	{
		dataMap.get().get(key);
	}

}
