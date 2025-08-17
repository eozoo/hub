/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.cowave.hub.meter.domain.torna.support;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.*;
import com.alibaba.fastjson.util.TypeUtils;
import com.cowave.hub.meter.domain.torna.util.IdUtil;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 隐藏真实id，转换成hashid
 *
 * @author tanghc
 */
public class IdCodec implements ObjectSerializer, ObjectDeserializer {

    private static final CollectionCodec COLLECTION_CODEC = new CollectionCodec();


    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        Class<?> clazz = TypeUtils.getClass(fieldType);
        if (List.class.isAssignableFrom(clazz)) {
            List list = (List) object;
            if (CollectionUtils.isEmpty(list)) {
                out.writeNull(SerializerFeature.WriteNullListAsEmpty);
            } else {
                List<String> hashIds = (List<String>) list.stream()
                        .map(el -> IdUtil.encode(Long.parseLong(String.valueOf(el))))
                        .collect(Collectors.toList());
                out.write(hashIds);
            }
        } else {
            Number value = (Number) object;
            if (value == null) {
                out.writeNull(SerializerFeature.WriteNullNumberAsZero);
                return;
            }
            // 转换成hashid
            out.writeString(IdUtil.encode(value.longValue()));
        }
    }


    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        final JSONLexer lexer = parser.lexer;
        Class<?> clazz = TypeUtils.getClass(type);
        // 将hashid解析成真实id
        if (Collection.class.isAssignableFrom(clazz)) {
            List list = COLLECTION_CODEC.deserialze(parser, List.class, fieldName);
            return (T) list.stream()
                    .map(hashId -> IdUtil.decode(String.valueOf(hashId)))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else {
            String val = lexer.stringVal();
            lexer.nextToken(JSONToken.COMMA);
            Long decodeVal = IdUtil.decode(val);
            if (clazz == int.class || clazz == Integer.class) {
                if (decodeVal == null) {
                    return null;
                } else {
                    return (T) Integer.valueOf(decodeVal.intValue());
                }
            } else {
                return (T) decodeVal;
            }
        }
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
