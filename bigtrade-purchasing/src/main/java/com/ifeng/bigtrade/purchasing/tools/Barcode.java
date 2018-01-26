package com.ifeng.bigtrade.purchasing.tools;

/**
 * 校验码生成格式
 * 
 * @author shaolin 2017-04-11
 *
 */
public class Barcode
{

	/**
	 * 获取校验码
	 * 
	 * @param str
	 * @return
	 */
	public static String getBarcode(String str)
	{
		int code = checkCode(two(str), one(str));
		return String.valueOf(code);
	}

	public static int two(String str)
	{// 偶位数的和*3
		int m = 0;
		for (int i = 1; i < str.length() - 1; i += 2)
		{
			m += (str.charAt(i) - '0');
		}
		return m * 3;
	}

	public static int one(String str)
	{// 奇位数的和
		int n = 0;
		for (int i = 0; i < str.length() - 1; i += 2)
		{
			n += (str.charAt(i) - '0');
		}
		return n;
	}

	public static int checkCode(int m, int n)
	{// 校验码理论值
		int c = 0;
		if (((m + n) % 10) == 0)
		{
			c = 0;
		} else
		{
			c = 10 - ((m + n) % 10);
		}
		return c;
	}
}
