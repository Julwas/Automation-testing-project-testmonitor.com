package utils;

public  class TestUtils {
    public static String generateString(int length){
        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i<length; i++){
            sb.append("*");
        } return sb.toString();
    }
}
