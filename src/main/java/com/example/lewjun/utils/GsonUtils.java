package com.example.lewjun.utils;

import com.google.gson.*;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

/**
 * Gson工具类
 *
 * @author huiye
 */
class GsonUtils {
  private static Gson instance = null;

  static synchronized Gson getGson(boolean convertDate, FastDateFormat fastDateFormat) {
    if (instance == null) {
      GsonBuilder gsonBuilder = new GsonBuilder();
      if (convertDate) {
        gsonBuilder
            .registerTypeAdapter(Date.class, new DateToLongSerializer())
            .setDateFormat(DateFormat.LONG);
        gsonBuilder
            .registerTypeAdapter(Date.class, new LongToDateSerializer())
            .setDateFormat(DateFormat.LONG);
      }

      if (fastDateFormat != null)
          gsonBuilder.setDateFormat(fastDateFormat.getPattern());
      instance = gsonBuilder.create();
    }
    return instance;
  }

  /** 日期转long */
  private static class DateToLongSerializer implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(
            Date date, Type type, JsonSerializationContext jsonSerializationContext) {
      return new JsonPrimitive(date.getTime());
    }
  }

  /** long转日期 */
  private static class LongToDateSerializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(
            JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
        throws JsonParseException {
      return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
    }
  }
}
