package pub.starfish.util.test;

public class FieldUtilTestVo {
    //正常boolean值
    private boolean booleanValue;
    //特殊名称
    private boolean aB;
    //特殊名称
    private boolean aBoolean;

    private String string;

    public String publicString;

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public boolean isaB() {
        return aB;
    }

    public void setaB(boolean aB) {
        this.aB = aB;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
