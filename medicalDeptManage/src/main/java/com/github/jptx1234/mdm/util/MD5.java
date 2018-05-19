package com.github.jptx1234.mdm.util;


import java.security.MessageDigest;



public class MD5 {
	

	  /**
	   *
	   */
	  private final static String[] hexDigits = {
	      "0", "1", "2", "3", "4", "5", "6", "7",
	      "8", "9", "a", "b", "c", "d", "e", "f"
	  };

	  /**
	   * 转换字节数组为16进制字串
	   * @param b 字节数组
	   * @return 16进制字串
	   */

	  public static String byteArrayToHexString(byte[] b) {
	    StringBuffer resultSb = new StringBuffer();
	    for (int i = 0; i < b.length; i++) {
	      resultSb.append(byteToHexString(b[i]));
	    }
	    return resultSb.toString();
	  }

	  /**
	   *
	   * @param b byte
	   * @return String
	   */
	  private static String byteToHexString(byte b) {
	    int n = b;
	    if (n < 0) {
	      n = 256 + n;
	    }
	    int d1 = n / 16;
	    int d2 = n % 16;
	    return hexDigits[d1] + hexDigits[d2];
	  }

	  /**
	   *
	   * @param origin String
	   * @return String
	   */
	  public static String MD5Encode(String origin) {
	    String resultString = null;

	    try {
	      resultString = new String(origin);
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
	    }
	    catch (Exception ex) {
	    }
	    return resultString;
	  }

	  
	  /** 
	   * 加密解密算法 执行一次加密，两次解密 
	   */   
	  public static String convertMD5(String inStr){  

	      char[] a = inStr.toCharArray();  
	      for (int i = 0; i < a.length; i++){  
	          a[i] = (char) (a[i] ^ 't');  
	      }  
	      String s = new String(a);  
	      return s;  

	  }  

	  /**
	   *
	   * @param args String[]
	   */
	  public static void main(String[] args) {
		  
	    String hashCode= MD5.MD5Encode("1234");
	    System.out.println("加密的：" +hashCode);

	    
	  }


	
}
