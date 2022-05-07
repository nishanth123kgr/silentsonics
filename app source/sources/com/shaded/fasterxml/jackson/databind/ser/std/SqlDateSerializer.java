package com.shaded.fasterxml.jackson.databind.ser.std;

import com.shaded.fasterxml.jackson.core.JsonGenerationException;
import com.shaded.fasterxml.jackson.core.JsonGenerator;
import com.shaded.fasterxml.jackson.databind.JavaType;
import com.shaded.fasterxml.jackson.databind.JsonMappingException;
import com.shaded.fasterxml.jackson.databind.JsonNode;
import com.shaded.fasterxml.jackson.databind.SerializerProvider;
import com.shaded.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.shaded.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.shaded.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.shaded.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;

@JacksonStdImpl
public class SqlDateSerializer extends StdScalarSerializer<Date> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SqlDateSerializer() {
        super(Date.class);
    }

    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        SerializerProvider serializerProvider2 = serializerProvider;
        jsonGenerator.writeString(date.toString());
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        SerializerProvider serializerProvider2 = serializerProvider;
        Type type2 = type;
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonFormatVisitorWrapper jsonFormatVisitorWrapper2 = jsonFormatVisitorWrapper;
        JsonStringFormatVisitor expectStringFormat = jsonFormatVisitorWrapper2 == null ? null : jsonFormatVisitorWrapper2.expectStringFormat(javaType);
        if (expectStringFormat != null) {
            expectStringFormat.format(JsonValueFormat.DATE_TIME);
        }
    }
}
