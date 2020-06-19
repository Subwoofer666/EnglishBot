import java.io.*;

public class test implements Cloneable {


    public static void main(String[] args) throws IOException {
        test zxc = new test();
        zxc.setName(new test());
    }

    private test name;

    public void setName(test name) {
        this.name = name;
    }

    public test getName() throws CloneNotSupportedException {
        return (test) super.clone();
    }
}






