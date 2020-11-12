import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan.chen
 * @ClassName RegularTest
 * @Description  几点几分几秒时，时针和分针是90°
 * @date 2020-07-27 14:54
 */
public class DegreeTest {

    public static final int degree = 90; //角度度数

    public static void main(String[] args) {
        for (int i = 1; i < 13; i++) {
            System.out.print(String.format("%2d", i).replace(" ", "0") + "、在");
            List<String> stringList = getTime(i, degree);
            String showTime = "";
            if (stringList != null && stringList.size() > 0) {
                for (String str : stringList) {
                    showTime += String.format("%2d", i).replace(" ", "0") + "点"+ str + "和";
                }
            }
            if (showTime.equals("")) {
                System.out.println(String.format("%2d", i).replace(" ", "0") + "点时，时针和分针夹角是" + degree + "°");
            } else {
                System.out.println(showTime.substring(0, showTime.length() - 2) + "时，不存在时针和分针夹角是" + degree + "°");
            }
        }
        /*List<String> stringList = getTime(10, 90);
        if (stringList != null && stringList.size() > 0) {
            for (String str : stringList) {
                System.out.print(str + "   ");
            }
        }*/
    }

    //秒针速率：6度/分钟 时针速率： 0.5度/分钟
    private static List<String> getTime(int hour, int degree) {
        int m1 = 0;
        int s1 = 0;
        int m2 = 0;
        int s2 = 0;

        if (((hour + 1) * 30 + degree) < 360) {
            m1 = (int) ((degree + hour * 30) / (6 - 0.5));
            s1 = (int) ((((degree + hour * 30) / (6 - 0.5)) % 1) * 60);
        } else {
            m1 = (int) ((degree + hour * 30 - 360) / (6 - 0.5));
            s1 = (int) ((((degree + hour * 30 - 360) / (6 - 0.5)) % 1) * 60);
        }

        if (hour * 30 - degree >= 0) {
            m2 = (int) ((hour * 30 - degree) / (6 - 0.5));
            s2 = (int) ((((hour * 30 - degree) / (6 - 0.5)) % 1) * 60);
        } else {
            m2 = (int) (((360 - degree) + hour * 30) / (6 - 0.5));
            s2 = (int) (((((360 - degree) + hour * 30) / (6 - 0.5)) % 1) * 60);
        }


        List<String> listShow = new ArrayList<>();
        if (m1 >= 0 && m1 < 60) {
            listShow.add(getTimeShow(m1, s1));
        }
        if (m2 >= 0 && m2 < 60) {
            listShow.add(getTimeShow(m2, s2));
        }
        return listShow;
    }

    private static String getTimeShow(int m, int s) {
        return String.format("%2d", m).replace(" ", "0") + "分" + String.format("%2d", s).replace(" ", "0") + "秒";
    }

}
