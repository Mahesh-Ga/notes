class A{
    int a;
    int b;
    A(){
        System.out.println("In Ctor");
    }
    A(int a,int b){
        System.out.println(a + "" + b);
        this;
    }
}
public class Playground{
    public static void main(String[] args) {
        A a = new A(1,2);
    }
}