package java;

public class DCL {
    private DCL(){}

    private static volatile DCL dcl = null;

    public static DCL getInstance(){
        if(dcl == null) {
            synchronized (DCL.class){
                if(dcl == null) {
                    dcl = new DCL();
                }
            }
        }

        return dcl;
    }

}

class t{

}
