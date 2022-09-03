package models.file;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

	private DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	@Override
	public JsonElement serialize(LocalDateTime arg0, Type arg1, JsonSerializationContext arg2) {

		return new JsonPrimitive(format.format(arg0));
	}

}
