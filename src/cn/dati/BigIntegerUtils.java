package cn.dati;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by wufuqi on 2017/7/31.
 */

public class BigIntegerUtils {
    /**
     * 涓や釜鏁扮浉鍑�
     * @param a
     * @param b
     * @return
     */
    public static int subtract(int a,int b){
        BigInteger aI=BigInteger.valueOf(a);
        BigInteger bI=BigInteger.valueOf(b);

        double value = aI.subtract(bI).doubleValue();
        return (int)value;
    }

    /**
     * 涓や釜鏁扮浉涔�
     * @param a
     * @param b
     * @return
     */
  public static int multiply(double a,double b){
      BigDecimal aI=BigDecimal.valueOf(a);
      BigDecimal bI=BigDecimal.valueOf(b);

        double value = aI.multiply(bI).doubleValue();
//      Logs.e("wufuqi---","memememe  涓や釜鏁扮浉涔橈細aI锛�"+aI.toString()+",bi:"+bI.toString()+",value:"+value);
        return (int)value;
    }
    /**
     * 涓や釜鏁扮浉涔�
     * @param a
     * @param b
     * @return
     */
    public static double multiplyDouble(double a,double b){
        BigDecimal aI=BigDecimal.valueOf(a);
        BigDecimal bI=BigDecimal.valueOf(b);

        BigDecimal multiply = aI.multiply(bI);
        double value = multiply.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        Logs.e("wufuqi---","memememe  涓や釜鏁扮浉涔橈細aI锛�"+aI.toString()+",bi:"+bI.toString()+",value:"+value);
        return value;
    }
    /**
     * 涓や釜鏁伴櫎
     * @param a
     * @param b
     * @return
     */
  public static double divide(double a,double b){
      BigDecimal aI= BigDecimal.valueOf(a);
      BigDecimal bI=BigDecimal.valueOf(b);

        double value = aI.divide(bI,2,BigDecimal.ROUND_HALF_UP).doubleValue();
//      Logs.e("wufuqi---","memememe   涓や釜鏁扮浉闄わ細aI锛�"+aI.toString()+",bi:"+bI.toString()+",value:"+value);
      return value;
    }
    /**
     * 涓や釜鏁伴櫎
     * @param a
     * @param b
     * @return
     */
  public static double divide4(double a,double b){
      BigDecimal aI= BigDecimal.valueOf(a);
      BigDecimal bI=BigDecimal.valueOf(b);

        double value = aI.divide(bI,4,BigDecimal.ROUND_HALF_UP).doubleValue();
//      Logs.e("wufuqi---","memememe   涓や釜鏁扮浉闄わ細aI锛�"+aI.toString()+",bi:"+bI.toString()+",value:"+value);
      return value;
    }


    public static int divideMultiply(double a,double b,double c){
        double divide = divide(a, b);
        int multiply = multiply(divide, c);


        return (int)multiply;
    }

    public static double divideMultiplyDouble(double a,double b,double c){
        double divide = divide4(a, b);
        double multiply = multiplyDouble(divide, c);


        return multiply;
    }
}
