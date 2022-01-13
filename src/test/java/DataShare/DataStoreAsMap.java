package DataShare;

import java.util.LinkedHashMap;

public class DataStoreAsMap {
	
	private DataStoreAsMap()
	{
		
	}
	
	private static LinkedHashMap<String,Object> dataMap = new LinkedHashMap<>();
	
	public static void setValue(String key,Object value)
	{
		dataMap.put(key, value);
	}
	
	public static Object getValue(String key)
	{
		return dataMap.get(key);
	}
	

}
