package eu.faircode.xlua.log;

public class XLuaDatabaseLogging {

    public static void addToRecord(String[] valuesForRecord) {
        if (valuesForRecord[0] != null && valuesForRecord[1] != null && valuesForRecord[2] != null && valuesForRecord[3] != null) {
            System.out.println("record update");
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Time: " + valuesForRecord[0]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Method: " + valuesForRecord[1]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "UID: " + valuesForRecord[2]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Package name: " + valuesForRecord[3]);
        }
    }

    public static void addToReserve(String[] valuesForRecord) {
        if (valuesForRecord[0] != null && valuesForRecord[1] != null && valuesForRecord[2] != null && valuesForRecord[3] != null) {
            System.out.println("install update");
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Time: " + valuesForRecord[0]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Method: " + valuesForRecord[1]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "UID: " + valuesForRecord[2]);
            System.out.println(XLuaDatabaseLogging.class.getSimpleName() + "Package name: " + valuesForRecord[3]);
        }
    }
}