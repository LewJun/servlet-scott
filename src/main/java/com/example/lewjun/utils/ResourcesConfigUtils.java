package com.example.lewjun.utils;

import java.util.ResourceBundle;

/**
 * conf/config.properties读取工具类
 *
 * @author LewJun
 */
public class ResourcesConfigUtils {
  private static ResourceBundle getResourceBundle(String baseName) {
    return ResourceBundle.getBundle(baseName);
  }

  public static String getString(String key) {
    return getResourceBundle("conf/config").getString(key);
  }
}
