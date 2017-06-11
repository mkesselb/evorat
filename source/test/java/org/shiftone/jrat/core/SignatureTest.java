package org.shiftone.jrat.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class SignatureTest {
	
	public SignatureParser parser = new SignatureParser();
	
	@Test
	public void testGetReturnType(){
		Signature sig = parser.parseSignature("(ICLString;)V");
		
		String result = sig.getReturnType();
		assertEquals("void", result);
	}
	
	@Test
	public void testGetReturnTypeClass(){
		Signature sig = parser.parseSignature("(ICLString;)Lorg/shiftone/jrat/core/Signature;");
		
		String result = sig.getReturnType();
		assertEquals("org.shiftone.jrat.core.Signature", result);
	}
	
	@Test
	public void testGetParameterCount(){
		Signature sig = parser.parseSignature("(IC)V");
		
		int result = sig.getParameterCount();
		assertEquals(2, result);
	}
	
	@Test
	public void testGetParameterCountEmpty(){
		Signature sig = parser.parseSignature("()V");
		
		int result = sig.getParameterCount();
		assertEquals(0, result);
	}
		
	@Test
	public void testGetParameterType(){
		Signature sig = parser.parseSignature("([[ICLorg/shiftone/jrat/core/Signature;)V");
		
		String result = sig.getParameterType(0);
		assertEquals("int[][]", result);
		
		result = sig.getParameterType(1);
		assertEquals("char", result);
		
		result = sig.getParameterType(2);
		assertEquals("org.shiftone.jrat.core.Signature", result);
	}
	
	@Test
	public void testGetShortParameterType(){
		Signature sig = parser.parseSignature("(ICLorg/shiftone/jrat/core/Signature;)V");
		
		String result = sig.getShortParameterType(0);
		assertEquals("int", result);
		
		result = sig.getShortParameterType(1);
		assertEquals("char", result);
		
		result = sig.getShortParameterType(2);
		assertEquals("Signature", result);
	}
	
	@Test
	public void testGetShortText(){
		Signature sig = parser.parseSignature("(ICLorg/shiftone/jrat/core/Signature;)V");
		
		String result = sig.getShortText();
		assertEquals("int,char,Signature", result);
	}
	
	@Test
	public void testGetShortTextEmpty(){
		Signature sig = parser.parseSignature("()V");
		
		String result = sig.getShortText();
		assertEquals("", result);
	}
	
	@Test
	public void testGetLongText(){
		Signature sig = parser.parseSignature("(ICLorg/shiftone/jrat/core/Signature;)V");
		
		String result = sig.getLongText();
		assertEquals("int,char,org.shiftone.jrat.core.Signature", result);
	}
	
	@Test
	public void testGetLongTextEmpty(){
		Signature sig = parser.parseSignature("()V");
		
		String result = sig.getLongText();
		assertEquals("", result);
	}
}