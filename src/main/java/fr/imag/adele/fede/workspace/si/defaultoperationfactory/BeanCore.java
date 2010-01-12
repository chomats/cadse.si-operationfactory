/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package fr.imag.adele.fede.workspace.si.defaultoperationfactory;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import fr.imag.adele.cadse.core.oper.annotation.OperParameter;


public class BeanCore {
	public static String getPropertyName(Field field, String value) {
		if (OperParameter.DEFAULT_VALUE.equals(value))
			return field.getName();
		return value;
	}
	
	public static <T> T getValue(Class<?> beanType, Object obj, String fieldName, 
			Field field, Method getMethod) {
		if (field == null)
			try {
				field = beanType.getField(fieldName);
			} catch (SecurityException e1) {
			} catch (NoSuchFieldException e1) {
		}
		if (field != null && makeAccessible(field))
			try {
				Object value = field.get(obj);
				return (T) value;
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		if (getMethod == null) {
			String methodName = capitalize("get", fieldName);
			try {
				getMethod = beanType.getMethod(methodName);
			} catch (SecurityException e) {
			} catch (NoSuchMethodException e) {
			}
		}
		if (getMethod != null && makeAccessible(getMethod)) {
			try {
				return (T) getMethod.invoke(obj);
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
		}
		return null;
	}
	
	/**
     * Returns a String which capitalizes the first letter of the string.
     */
    public static String capitalize(String prefix, String name) { 
    	if (name == null || name.length() == 0) { 
    		return prefix; 
        }
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(name.substring(0, 1).toUpperCase());
		sb.append(name.substring(1));
		return sb.toString();
    }
    
    private static boolean makeAccessible(Member m) {
        if(!Modifier.isPublic(m.getModifiers()) || !Modifier.isPublic(m.getDeclaringClass().getModifiers())) {
            try {
            	if (m instanceof Field) {
            		((Field) m).setAccessible(true);
                    return true;
            	} 
            	if (m instanceof Method) {
            		((Method) m).setAccessible(true);
                    return true;
            	} 
            } catch( SecurityException e ) {
                return false;
            }
        }
        return true;
    }
}
