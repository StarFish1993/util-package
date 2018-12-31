package pub.starfish.util.reflect;

import pub.starfish.util.reflect.exception.BaseReflectException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 安全的获得和设置指定的fieldName
 * 在
 *
 * @author yuheng
 */
public class FieldUtil {

    public static final String GET_STR = "get";
    public static final String IS_STR = "is";
    public static final String SET_STR = "set";

    /**
     * 获得 t.fieldName 的值
     *
     * @param t         操作对象的实例
     * @param fieldName 属性名
     * @param <T>       操作对象的类型
     * @return 获得到的值
     * @throws BaseReflectException
     * 参考ErrorEnum
     */
    public static <T> Object getFieldValue(T t, String fieldName) throws BaseReflectException {
        Class<?> tClass = t.getClass();
        Field declaredField = null;
        try {
            declaredField = tClass.getDeclaredField(fieldName);
            int modifiers = declaredField.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return declaredField.get(t);
            }
            if (declaredField.getType().equals(boolean.class)) {
                return is(t,fieldName);
            } else {
                return getter(t,fieldName);
            }
        } catch (NoSuchFieldException e) {
            // 在没有找到field的时候，通过getter获得值
            return getter(t,fieldName);
        } catch (IllegalAccessException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.ILLEGAL_ACCESS,e);
        }

    }

    /**
     * 设置 t.fieldName 的值
     * 操作对象的类型
     *
     * @param t         操作对象的实例
     * @param fieldName 属性名
     * @param value     设置的值
     * @param <T>       操作对象的类型
     * @throws BaseReflectException
     * 参考ErrorEnum
     */
    public static <T> void setFieldValue(T t, String fieldName, Object value) throws BaseReflectException {
        Class<?> tClass = t.getClass();
        Field declaredField = null;
        try {
            declaredField = tClass.getDeclaredField(fieldName);
            int modifiers = declaredField.getModifiers();
            //是公共的且可修改
            if (Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers)) {
                declaredField.set(t, value);
            }else {
                String name = declaredField.getName();
                String methodName = SET_STR;

                methodName = buildMethodName(methodName, fieldName);

                Method method = tClass.getMethod(methodName, declaredField.getType());
                method.invoke(t, value);
            }
        } catch (NoSuchMethodException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.NO_SUCH_GETTER, e);
        } catch (IllegalAccessException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.CATCH_ERROR,e);
        } catch (NoSuchFieldException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.NO_SUCH_FIELD,e);
        }

    }

    /**
     * 通过getter获得属性值
     * @param t
     * 实例
     * @param fieldName
     * 属性名
     * @param <T>
     * 类型
     * @return
     * 获得到的值
     * @throws BaseReflectException
     * 参考ErrorEnum
     */
    public static <T> Object getter(T t, String fieldName) throws BaseReflectException{
        return getterOrIs(GET_STR,t,fieldName);
    }

    /**
     * 通过is获得属性值
     * @param t
     * 实例
     * @param fieldName
     * 属性名
     * @param <T>
     * 类型
     * @return
     * 获得到的值
     * @throws BaseReflectException
     * 参考ErrorEnum
     */
    public static <T> Object is(T t, String fieldName) throws BaseReflectException{
        return getterOrIs(IS_STR,t,fieldName);
    }


    private static <T> Object getterOrIs(String methodPre, T t, String fieldName) throws BaseReflectException {
        Class<?> tClass = t.getClass();
        String methodName = methodPre;
        methodName = buildMethodName(methodName, fieldName);

        Method method = null;
        try {
            method = tClass.getMethod(methodName);
            return method.invoke(t);
        } catch (NoSuchMethodException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.NO_SUCH_GETTER, e);
        } catch (IllegalAccessException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw new BaseReflectException(BaseReflectException.ErrorEnum.CATCH_ERROR,e);
        }
    }

    private static String buildMethodName(String methodNamePre, String fieldName) {
        //fieldName的第二个字符，在 aBoolean 等类似情况getter 或 setter会被处理为 getaBoolean 或 setaBoolean
        String to2 = fieldName.substring(1, 2);
        if (fieldName.length() >= 2 && to2.toUpperCase().equals(to2)) {
            methodNamePre += fieldName;
        } else {
            methodNamePre += fieldName.substring(0, 1).toUpperCase() +
                    fieldName.substring(1);
        }
        return methodNamePre;
    }
}
