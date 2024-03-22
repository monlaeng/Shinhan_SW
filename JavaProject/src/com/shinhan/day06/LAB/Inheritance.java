package com.shinhan.day06.LAB;
class C extends B{ 
    int meth()  { return 100; } 
    static int sMeth() { return 100; } 
} 

class B extends A{ 
    int meth()  { return 10; } 
    static int sMeth() { return 10; } 
} 

class A{ 
    int meth()  { return 1; } 
    static int sMeth() { return 1; } 
} 
 
public class Inheritance { 
    public static void main(String[] args){ 
        C c = new C(); 	//객체생성은 C, 자식생성시 부모도 생성된다. 부모는 자식을 담을 수 있다.
        B b = c; 
        A a = c; 
        
        if( a instanceof A ) {
            System.out.println( "a는 A의 인스턴스 이다.");
        }        
        if( a instanceof B) {
            System.out.println( "a는 B의 인스턴스 이다.");
        }
        if( a instanceof C) {
            System.out.println( "a는 C의 인스턴스 이다.");
        }
        
        System.out.println(a.meth() + " " + b.meth() + " " + c.meth()
                      + a.sMeth() + " " + b.sMeth() + " " + c.sMeth() ); 
        
        System.out.println(A.sMeth());
        System.out.println(B.sMeth());
        System.out.println(C.sMeth());
        
    } 
}

