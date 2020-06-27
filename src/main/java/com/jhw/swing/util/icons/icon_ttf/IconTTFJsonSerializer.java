package com.jhw.swing.util.icons.icon_ttf;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class IconTTFJsonSerializer extends JsonSerializer<IconTTF> {

    @Override
    public void serialize(IconTTF value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeFieldName("ch");
        gen.writeString(String.valueOf((int) value.getCh()));

        gen.writeFieldName("size");
        gen.writeString(String.valueOf(value.getSize()));

        gen.writeEndObject();
    }
}
