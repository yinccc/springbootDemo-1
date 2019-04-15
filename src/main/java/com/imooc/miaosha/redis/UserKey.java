package com.imooc.miaosha.redis;

public class UserKey extends BasePrefix{
	
	private UserKey(String prefix) {
		super(prefix);
	}
	
	public static UserKey getById=new UserKey("id");
	public static UserKey getByname=new UserKey("name");
}
