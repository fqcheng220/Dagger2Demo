package fqcheng220.dagger2demo.utils;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/14 16:46
 */

public class Logger {
  public static void d(String tag,String message){
    System.out.println("[" + tag + "]" + ":" + message);
  }
}
