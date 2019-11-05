package com.wuss.leetCode;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void testMethod(Class clazz) {
        try {
            Scanner scanner = new Scanner(System.in);
            Method[] methods = clazz.getMethods();
//            System.out.println(Arrays.toString(methods));
            Object target = clazz.newInstance();

            Method[] objectMethods = Object.class.getMethods();
            List objectLists = Arrays.asList(objectMethods);
            Method method = null;
            for (Method m : methods){
                if(objectLists.contains(m)){
                    continue;
                }
                if("main".equals(m.getName())){
                    continue;
                }
                method = m;
                break;
            }
            if(method == null){
                return;
            }
            int parameterCount = method.getParameterCount();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] param = new Object[parameterCount];
            while (scanner.hasNext()){
                for (int i=0;i<parameterCount;i++){
                    param[i] = setValue(parameterTypes[i],scanner.next());
                }
                Object result = method.invoke(target,param);
                System.out.println(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static <T > T setValue(T clazz,String value){
        String name = ((Class)clazz).getTypeName();

        if(String.class.equals(clazz)){
            return (T)value;
        }
        if(Integer.class.equals(clazz)||"int".equals(name)){
            return (T)Integer.valueOf(value);
        }
        if(Long.class.equals(clazz) || "long".equals(name)){
            return (T) Long.valueOf(value);
        }
        if("int[]".equals(name)){
            String[] split = value.split(",");
            int[] reusltArr = new int[split.length];
            for (int i=0;i<split.length;i++){
                reusltArr[i] = Integer.valueOf(split[i]);
            }
            return (T) reusltArr;

        }
        if("java.lang.String[]".equals(name)){
            return (T) value.split(",");
        }
        if("com.wuss.leetCode.ListNode".equals(name)){
            String[] split = value.split(",");
            int[] reusltArr = new int[split.length];
            for (int i=0;i<split.length;i++){
                reusltArr[i] = Integer.valueOf(split[i]);
            }
            ListNode node = ListNode.getList(reusltArr);
            return (T) node;

        }
        return null;
    }
}
