public class Field {
    private String fieldName;
    private String fieldType;
    private String stringFieldValue;
    private int intFieldValue;
    private boolean boolField;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String name) {
        this.fieldName = name;
    }

    public String getFieldType(){
        return fieldType;
    }

    public void setFieldType(String type) {
        this.fieldType = type;
    }
}
