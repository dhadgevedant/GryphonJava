public class ExceptionHandeling {
    
    public void Arithmatic() {
        
        try{
            int a = 10;
            int b = 0;
            int c = a / b;
            System.out.println("Result: " + c);
        }
        catch(ArithmeticException e){

            
            System.out.println("Arithmetic Exception occurred: " + e.getMessage());

        }
        finally{
            System.out.println("Execution completed.");
        }
    }

    public void ArrayOutOfBounds(){
        try{
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception occurred: " + e.getMessage());
        }
        finally{
            System.out.println("Execution completed.");
        }
    }

    public void ArrayStore(){
        try{
            Object[] arr = new String[3];
            arr[0] = 10; // This will cause ArrayStoreException
        }
        catch(ArrayStoreException e){
            System.out.println("Array Store Exception occurred: " + e.getMessage());
        }
        finally{
            System.out.println("Execution completed.");
        }
    }
   
   
    public static void main(String[] args) {

        ExceptionHandeling obj = new ExceptionHandeling();
        obj.Arithmatic();

        System.out.println();
        obj.ArrayOutOfBounds();

        System.out.println();
        obj.ArrayStore();
    }

}
