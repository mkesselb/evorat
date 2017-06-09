package org.shiftone.jrat.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shiftone.jrat.util.Assert;
import org.shiftone.jrat.util.CharacterIterator;
import org.shiftone.jrat.util.log.Logger;

public class SignatureParser {
	
	private static final Logger LOG = Logger.getLogger(SignatureParser.class);
	private static Map PRIM_CODES = new HashMap();
	private CharacterIterator charIterator;
	
    static {
        PRIM_CODES.put("Z", "boolean");
        PRIM_CODES.put("B", "byte");
        PRIM_CODES.put("C", "char");
        PRIM_CODES.put("D", "double");
        PRIM_CODES.put("F", "float");
        PRIM_CODES.put("I", "int");
        PRIM_CODES.put("J", "long");
        PRIM_CODES.put("S", "short");
        PRIM_CODES.put("V", "void");
    }
		
    public Signature parseSignature(String descriptors) {
    	String returnType = "";
    	List<String> parameterTypes = new ArrayList<>(5);
    	
    	charIterator = new CharacterIterator(descriptors);
    	
        Assert.assertTrue("first char is (", charIterator.next() && (charIterator.get() == '('));

        boolean inParams = true;

        while (charIterator.next()) {
            char c = charIterator.get();

            if (c == ')') {
                inParams = false;
            }

            if (inParams) {
                parameterTypes.add(parseType());
            } else {
                returnType = parseType();
            }
        }
        
        return new Signature(returnType, parameterTypes);
    }

    private String parseType() {
        char c = charIterator.get();

        if (c == 'L') {
            return parseClassType();
        } else if (c == '[') {
            return parseArrayType();
        } else {
            return (String) PRIM_CODES.get(String.valueOf(c));
        }
    }

    private String parseArrayType() {
        StringBuffer sb = new StringBuffer("[]");

        while (charIterator.next() && (charIterator.get() == '[')) {
            sb.append("[]");
        }

        sb.insert(0, parseType());    // out the type at the start of the

        // [][][]
        return sb.toString();
    }

    private String parseClassType() {
        StringBuffer className = new StringBuffer();

        while (charIterator.next()) {
            char c = charIterator.get();

            if (c == ';') {
                break;
            } else if (c == '/') {
                className.append('.');
            } else {
                className.append(c);
            }
        }

        return className.toString();
    }
}
