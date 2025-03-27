package annotation.general.suppresswarnings;


import java.util.ArrayList;
import java.util.List;

// 컴파일러 경고를 무시
// 실무에서 사용하지 않는걸 권장, 경고 메세지 안나도록 하는게 우선
// 간혹 어쩔 수 없이 쓰이긴함
@SuppressWarnings({"unchecked", "rawtypes", "unused"})
public class SuppressWarningsExample {

    public void something() {
        List list = new ArrayList<>();
        list.add("data");
        System.out.println(list.get(0));
    }

}
