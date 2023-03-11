import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 */
public class test {
    @Test
    public void test(){

        T t1 = new T();
        new Thread(t1).start();

        T t2 = new T();
        new Thread(t2).start();
        System.out.println(t1.s1 == t2.s1);
    }

    class T implements Runnable{

        public Singleton1 s1 = null;
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            s1 = Singleton1.INSTANCE;
            s1.sayHello();
            System.out.println(s1.hashCode());
        }
    }

    // 使用枚举,也可以实现单例,推荐使用
    enum Singleton1{
        INSTANCE;

        public void sayHello(){
            System.out.println("hello en000um");
        }
    }
}
