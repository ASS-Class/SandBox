public class ThreadSandBox {

    public void go() {
        ExecA eaM = () -> execA("qwe");
        NewThread td = new NewThread(eaM);
        String newStr = td.customStart();
        ExecA eaM2 = () -> execB("qwe2");
        NewThread td2 = new NewThread(eaM2);
        String newStr2 = td2.customStart();
        try {
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            td2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(td.getOut());
        System.out.println(td2.getOut());
        System.out.println("+++++++++++");
        System.out.println(newStr + " " + newStr2);

    }

    String execA(String a) {
        System.out.println(a + " in execA()");
        return a + a;
    }

    String execB(String a) {
        System.out.println(a + " in execB()");
        return a + a;
    }
}

class NewThread extends Thread {
    public NewThread(ExecA ea0) {
        ea = ea0;
    }

    ExecA ea;
    private String out = "||||";

    @Override
    public void run() {
        out = ea.execA();
        System.out.println(out + " in run()");
    }

    String customStart() {
        start();
        return out;
    }

    public String getOut() {
        return out;
    }
}

interface ExecA {
    String execA();
}


