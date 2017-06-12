package org.shiftone.jrat.core;

import org.shiftone.jrat.util.log.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jeff@shiftone.org (Jeff Drost), mkesselb, s2paster
 */
public class Signature {

    private static final Logger LOG = Logger.getLogger(Signature.class);
    private String returnType;
    private List<String> parameterTypes = new ArrayList<>(5);
    
    public Signature(String returnType, List<String> parameterTypes){
    	this.returnType = returnType;
    	this.parameterTypes = parameterTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public int getParameterCount() {
        return parameterTypes.size();
    }

    public String getParameterType(int index) {
        return (String) parameterTypes.get(index);
    }

    public String getShortParameterType(int index) {
        String type = getParameterType(index);
        int dotIndex = type.lastIndexOf('.');

        if (dotIndex != -1) {
            type = type.substring(dotIndex + 1);
        }

        return type;
    }

    public String getShortText() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < getParameterCount(); i++) {
            if (i != 0) {
                sb.append(",");
            }

            sb.append(getShortParameterType(i));
        }

        return sb.toString();
    }

    public String getLongText() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < getParameterCount(); i++) {
            if (i != 0) {
                sb.append(",");
            }

            sb.append(getParameterType(i));
        }

        return sb.toString();
    }
}
