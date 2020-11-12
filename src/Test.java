import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan.chen
 * @ClassName Test
 * @Description  九九乘法表
 * @date 2020-07-28 10:15
 */
public class Test {

    public static void main(String[] args) {

        List<String> showList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            String str = "";
            for (int j = 1; j <= i; j++) {
                str = str + j + "*" + i + "=" + String.format("%1$-6s", i*j);
            }
            showList.add(str);
        }

        showList.forEach(System.out::println);


    }
}
