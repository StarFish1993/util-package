package pub.starfish.util.test;

import org.junit.Assert;
import org.junit.Test;
import pub.starfish.util.reflect.FieldUtil;
import pub.starfish.util.reflect.exception.BaseReflectException;

public class FieldUtilTest {


    private FieldUtilTestVo fieldUtilTestVo = new FieldUtilTestVo();
    @Test
    public void test() throws BaseReflectException {
            FieldUtil.setFieldValue(fieldUtilTestVo,"booleanValue", true);
            Assert.assertTrue(fieldUtilTestVo.isBooleanValue());
            FieldUtil.setFieldValue(fieldUtilTestVo,"aB",true);
            Assert.assertTrue(fieldUtilTestVo.isaB());
            FieldUtil.setFieldValue(fieldUtilTestVo,"aBoolean",true);
            Assert.assertTrue(fieldUtilTestVo.isaBoolean());
            FieldUtil.setFieldValue(fieldUtilTestVo,"string","false");
            Assert.assertEquals(fieldUtilTestVo.getString(),"false");
            FieldUtil.setFieldValue(fieldUtilTestVo,"publicString","false");
            Assert.assertEquals(fieldUtilTestVo.publicString,"false");


            Assert.assertTrue((Boolean) FieldUtil.getFieldValue(fieldUtilTestVo,"booleanValue"));
            Assert.assertTrue((Boolean) FieldUtil.getFieldValue(fieldUtilTestVo,"aB"));
            Assert.assertTrue((Boolean) FieldUtil.getFieldValue(fieldUtilTestVo,"aBoolean"));
            Assert.assertEquals(FieldUtil.getFieldValue(fieldUtilTestVo,"string"),"false");
            Assert.assertEquals(FieldUtil.getFieldValue(fieldUtilTestVo,"publicString"),"false");
    }
}
