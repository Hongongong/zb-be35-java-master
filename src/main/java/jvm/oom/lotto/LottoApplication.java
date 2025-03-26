package jvm.oom.lotto;

/*
* OOM 발생시키는 버전
* */

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    // 생성된 로또 번호들을 저장할 리스트 (계속 누적되어 결국 OutOfMemoryError 발생)
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        // 로또번호 생성기 객체 생성
        LottoGenerator generator = new LottoGenerator();

        // 무한 루프: 계속 로또 번호를 생성하여 저장
        while (true) {
            List<Integer> lottoNumbers = generator.generate();// 로또번호 생성하는 메소드 호출
            System.out.println(lottoNumbers); // 로또 번호 6개 출력
            lottoHistory.add(lottoNumbers); // 생성된 로또 번호 리스트에 저장
        }

    }

}