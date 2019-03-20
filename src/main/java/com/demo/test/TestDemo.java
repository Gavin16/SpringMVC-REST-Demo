package com.demo.test;

import com.alibaba.fastjson.JSON;
import com.demo.domain.UserDTO;
import com.demo.domain.queryparam.TestParam;
import com.demo.utils.ConvertUtil;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 20:33
 * @Description:
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        UserDTO user = new UserDTO();
        user.setAge("19");
        user.setName("zhansan");
        user.setGender("male");

        TestParam testParam = new TestParam();

        testParam.setUserDTO(user);

        List<String> addrList = Arrays.asList(new String[]{"南山区","福田区"});

        testParam.setAddrList(addrList);
        testParam.setName("大师兄");
        testParam.setAge(1900);

//        System.out.println(String.valueOf(testParam));

        String paramStr = JSON.toJSONString(testParam);

        Map<String,Object> map = JSON.parseObject(paramStr,Map.class);
//        System.out.println(map.toString());
        // class 文件
        System.out.println(TestParam.class.newInstance().toString());
        Constructor<?>[] constructors = testParam.getClass().getConstructors();

        for(Constructor constructor :constructors){
            TestParam instance = (TestParam) constructor.newInstance();
            System.out.println(instance.toString());
        }


        // 即使 TestParam 中的testRef 属性没有set 方法 依然可以通过反射设置 testRef 的值
        Class testClass = testParam.getClass();
        // 获得类的所有属性包括 私有的
        Field[] declaredFields = testClass.getDeclaredFields();
        // 设置 所有属性可以访问
        Field.setAccessible(declaredFields,true);
        Field testRef = testClass.getDeclaredField("testRef");
        // 这里如果不设置为 true 就无法访问该属性(public 属性除外)
        testRef.setAccessible(true);
        testRef.set(testParam,"setSuccess");
        System.out.println(testParam);


        // ============将Map 转化为 JavaBean=============
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("name","朝老二");
        paramMap.put("age",300);
        paramMap.put("addrList",Arrays.asList(new String[]{"北京","上海"}));
        paramMap.put("addressName","sdhfih");
        TestParam testParam1 = ConvertUtil.convertMapToBean(paramMap, TestParam.class);
        System.out.println("mapToBean : "+String.valueOf(testParam1));


        // ===========通过反射获取方法==============
        TestParam testParam2 = new TestParam();
        // 获取当前类所有的方法(不包括父类的方法)
        Method[] declaredMethods = testParam2.getClass().getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method.getName() + ":"+method.getReturnType().getName());
        }
        // 获取所有的方法(包括从父类继承而来的)
        Method[] methods = testParam2.getClass().getMethods();
        System.out.println("---------------");
        for(Method method : methods){
            System.out.println(method.getName()+" ： "+method.getReturnType().getName());
        }

        // 调用方法  无参&有参
        Method setName = testParam2.getClass().getMethod("setName", String.class);
        setName.invoke(testParam2,"zhansan");
        System.out.println(testParam2.toString());
        // 将 paramMap 中的参数利用反射保存到 testParam2 中
        // 利用set方法将map 中的值传入DTO中
        Field[] fields = testParam2.getClass().getDeclaredFields();


        System.out.println("888888888888888888888888888");

        for(Map.Entry entry : paramMap.entrySet()){
            String key = (String) entry.getKey();

            for(Field field : fields){
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), testParam2.getClass());
                Method writeMethod = pd.getWriteMethod();
                System.out.println(writeMethod.getName() + "---" + writeMethod.getReturnType().getName());
                if(key.equalsIgnoreCase(field.getName())){
                    writeMethod.invoke(testParam2,entry.getValue());
                    break;
                }
            }
        }
        System.out.println(testParam2);

        Class testParamClass = testParam2.getClass();

        TestParam newInstance = (TestParam) testParamClass.newInstance();

        System.out.println("0000000000000000000000");
        System.out.println(newInstance);
        Field name = newInstance.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(testParam2,"李君陌");
        System.out.println(testParam2);
        // TestParam 的不管哪一个对象获取到的Class对象都是同一个对象
        // 意味着 拿到TestParam 的Class 之后可以修改任一一个TestParam对象
        System.out.println(testParamClass == newInstance.getClass());

    }
}
