package pub.starfish.util.reflect.biz;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

public class GeneralConv {
    /**
     * 对象通用转换
     *
     * @param source           源对象
     * @param destinationClass 目标类
     * @param <T>
     * @return 返回得到destinationClass
     */
    public static <T> T conv(Object source, Class<T> destinationClass) {
        if(null == source){
            return null;
        }
        return new DozerBeanMapper().map(source, destinationClass);
    }

    /**
     * 集合转换
     *
     * @param sourceList       源集合
     * @param destinationClass 目标类
     * @param <T>
     * @return 返回得到destinationClass的集合结果
     */
    public static <T> List<T> convert2List(List<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>(sourceList.size());
        sourceList.forEach(source -> destinationList.add(GeneralConv.conv(source, destinationClass)));
        return destinationList;
    }
}