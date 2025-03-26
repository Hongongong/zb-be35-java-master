package jvm.oom.lotto;

/*
 * OOM 발생시키는 버전
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LottoGenerator {

    public List<Integer> generate() {

        // 1 ~ 45 사이의 숫자 중에서 중복 없이 6개의 숫자를 생성
        List<Integer> numbers = new ArrayList<>(); // HashSet 사용하여 중복 허용 안됨

        while (numbers.size() < 6) {
            // 1부터 45까지의 로또 번호 생성
            numbers.add(ThreadLocalRandom.current().nextInt(1, 46));
        }

        return numbers;

    }

}