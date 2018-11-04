import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamsSandBox {


    public void go() {
        List<String> list = new ArrayList<String>();
        putPutPut(list);
        Predicate<? super String> sd;

        String strng = "" + list.stream().filter(val -> val.contains("0")).count();
        System.out.println(list.stream().findFirst().get());
        System.out.println(strng);

    }

    private void putPutPut(List<String> list) {
        for (int i = 0; i < 1000; i++) {
            list.add("Elem" + i);
        }
    }
}


