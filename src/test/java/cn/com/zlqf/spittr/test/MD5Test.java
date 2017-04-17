package cn.com.zlqf.spittr.test;

import java.beans.Encoder;
import java.security.MessageDigest;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String[] args) {
		SimpleHash simpleHash = new SimpleHash("MD5", "123456", "hy", 1024);
		System.out.println(simpleHash.toString());
	}
}
