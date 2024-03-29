package com.ssmstudy.jdk.polymorphism;

/**
 * 多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定，
 * 即一个引用变量到底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。
 * 因为在程序运行时才确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的
 * 具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。
 *
 * 1,多态存在的三个条件：
 *
 * ​ （1）继承或实现的关系 ；
 *
 * ​	（2）方法重写；
 *
 * ​	（3）父类引用子类对象
 *
 * ​		  upcasting 向上转型：将子类对象直接赋值给父类引用
 *
 * ​              向上转型不需要强行类型转换
 *
 * ​			     向上转型后父类不能调用子类特有的方法
 *
 * ​				 父类引用或调用的是子类的方法
 *
 * ​       downcasting 向下转型：将指向子类对象的父类引用赋值给子类引用
 *
 * ​              需要强行类型转换
 *
 *  				 如果引用的是子类对象，那么在向下转型的过程中是安全的，即编译是不会出错的
 *
 * ​				 如果父类引用的对象是父类本身，那么在向下转型的过程中是不安全的，编译不会出错，但是在运行时会出现java.lang.ClassCastException异常
 *
 * ​					可以通过instanceof避免报错
 *
 *
 *
 * 2,多态成员的访问特点
 *
 * ​    成员变量
 *
 * ​           编译看父类，运行看父类
 *
 * ​    成员方法
 *
 * ​           编译看父类，运行看子类
 *
 *
 *
 * 3,多态的使用场景
 *
 * ​       可以作为方法的参数和返回值进行使用，提高代码的拓展性
 *
 * 4,多态的作用
 *
 * ​       降低了类之间的耦合关系，大大提高了程序的可扩展性和可维护性
 */
public class Demo1 {
    public static void main(String[] args) {

    }
}

