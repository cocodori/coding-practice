package playground.problem.programmers.level2.소수찾기;

import java.util.HashSet;
import java.util.Iterator;

public class Solution {

    HashSet<Integer> numberSet = new HashSet<>();

    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }

        // 2. 남은 숫자 중에서 하나를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }

    public boolean isPrime(int num) {
        // 0과 1은 소수가 아니다.
        if (num == 0 || num == 1) return false;

        int limit = (int) Math.sqrt(num);

        for (int i = 2; i < limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(String numbers) {
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        // 2. 소수의 개수를 센다.
        int count = 0;
        Iterator<Integer> it = numberSet.iterator();

        while (it.hasNext()) {
            int num = it.next();

            if (isPrime(num)) {
                count++;
            }
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) {
        new Solution().solution("1231");
        new Solution().solution("121");
        new Solution().solution("144");
        new Solution().solution("169");
    }
}

//2, 10, 11, 12
//체크하는수가 완전제곱수일때 (121,144,169,225등) 소수체크 되는지 확인한번 해보시면 됩니다