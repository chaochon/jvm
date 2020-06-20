package gc;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC save_hook = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.save_hook = this;
    }

    public void isAlive(){
        System.out.println("yes, i am still alive!");
    }


    public static void main(String[] args) throws Throwable{

        FinalizeEscapeGC finalizeEscapeGC = new FinalizeEscapeGC();

        finalizeEscapeGC = null;

        System.gc();

        Thread.sleep(1000);
        if(finalizeEscapeGC!=null){
            System.out.println("the object is alive!");
        }
        else{
            System.out.println("the object is dead!");
        }


    }

}
