package com.jhw.swing.util.icons.icon_ttf;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class IconTTFJsonDeserializer extends JsonDeserializer<IconTTF> {

    @Override
    public IconTTF deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode root = p.getCodec().readTree(p);
        int ch = Integer.parseInt(((TextNode) root.get("ch")).textValue());
        float size = Float.parseFloat(((TextNode) root.get("size")).textValue());
        return new IconTTF((char) ch).deriveIcon(size);
    }
}
