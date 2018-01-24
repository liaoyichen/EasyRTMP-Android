package org.easydarwin.util.uart;

/**
 * @author benjaminwan
 *数据转换工具
 */
public class MyFunc {
	//-------------------------------------------------------
	// 判断奇数或偶数，位运算，最后一位是1则为奇数，为0是偶数
	public static int isOdd(int num)
	{
		return num & 0x1;
	}
    //-------------------------------------------------------
    public static int HexToInt(String inHex)//Hex字符串转int
    {
    	return Integer.parseInt(inHex, 16);
    }
    //-------------------------------------------------------
    public static byte HexToByte(String inHex)//Hex字符串转byte
    {
    	return (byte)Integer.parseInt(inHex,16);
    }
    //-------------------------------------------------------
    static public String Byte2Hex(Byte inByte)//1字节转2个Hex字符
    {
    	return String.format("%02x", inByte).toUpperCase();
    }
    //-------------------------------------------------------
    public static String ByteArrToHex(byte[] inBytArr)//字节数组转转hex字符串
	{
		StringBuilder strBuilder=new StringBuilder();
		int j=inBytArr.length;
		for (int i = 0; i < j; i++)
		{
			strBuilder.append(Byte2Hex(inBytArr[i]));
			strBuilder.append(" ");
		}
		return strBuilder.toString(); 
	}
  //-------------------------------------------------------
	public static String ByteArrToHex(byte[] inBytArr,int offset,int byteCount)//字节数组转转hex字符串，可选长度
	{
    	StringBuilder strBuilder=new StringBuilder();
		int j=byteCount;
		for (int i = offset; i < j; i++)
		{
			strBuilder.append(Byte2Hex(inBytArr[i]));
		}
		return strBuilder.toString();
	}
	//-------------------------------------------------------
	//转hex字符串转字节数组
    public static byte[] HexToByteArr(String inHex)//hex字符串转字节数组
	{
		int hexlen = inHex.length();
		byte[] result;
		if (isOdd(hexlen)==1)
		{//奇数
			hexlen++;
			result = new byte[(hexlen/2)];
			inHex="0"+inHex;
		}else {//偶数
			result = new byte[(hexlen/2)];
		}
	    int j=0;
		for (int i = 0; i < hexlen; i+=2)
		{
			result[j]=HexToByte(inHex.substring(i,i+2));
			j++;
		}
	    return result; 
	}
    
    /**
     * Ascii转换为字符串
     * @param value
     * @return
     */
    public static char asciiToChar(String value)
    {
    	char res = (char) Integer.parseInt(value, 16);
        return res;
    }
}