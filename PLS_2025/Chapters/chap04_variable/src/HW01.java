import java.util.*;

public class HW01 {
    // 각 스코프 레벨에서 "선언된 변수 이름들"만 보관
    private final Deque<Set<String>> scopeStack = new ArrayDeque<>();
    // 가장 가까운(유효한) 레벨 기록
    private final Map<String, Integer> levelOf = new HashMap<>();

    public HW01() {
        enterScope(); // 전역 레벨(0) 자동 시작
    }

    // 새 스코프 시작 (스택 push)
    /**
     * Step 2:
     * 빈 변수 스택 만들기.
     * 스택 위(top)에 새 스코프 추가.
     * 이후 선언되는 변수는 이 새 집합에 저장
     */
    public void enterScope() {
        // TODO: 새 스코프를 시작하도록 구현
        scopeStack.push(new HashSet<>());
    }

    // 현재 스코프 종료 (해당 레벨에서 선언한 이름 제거)
    /**
     * Step 5:
     * [조건 2] Scope는 Stack으로 관리되며, 종료 시 exitScope() 함수를 사용한다.
     * [조건 5] exitScope()가 호출되면 해당 Scope에서 선언한 변수는 모두 제거되어야 한다.
     * <p>
     * 동작 설명:
     * 1. 전역 스코프(L0)는 종료할 수 없으므로, 종료 시도 시 경고 메시지만 출력한다.
     * 2. 현재 스코프(스택 맨 위 집합)를 pop() 하여 꺼낸다.
     * 3. pop된 집합 안에 들어 있던 변수 이름들을 하나씩 확인한다.
     *    - 바깥쪽 스코프에 동일한 이름이 있으면 → levelOf 맵에 바깥쪽 레벨 번호로 복원한다.
     *    - 바깥쪽에도 없으면 → levelOf 맵에서 제거한다.
     * 결과적으로, 현재 스코프에서 선언된 변수들은 모두 제거되며,
     * 안쪽에서 섀도잉되었던 바깥 변수들이 다시 살아남는다.
     */
    public void exitScope() {
        if (scopeStack.size() <= 1) {                   // 전역 스코프 보호
            System.out.println("[warn] cannot exit global scope (L0)");
            return;
        }

        Set<String> declaredHere = scopeStack.pop();    // 현재 스코프에서 선언된 변수 집합 꺼냄

        for (String name : declaredHere) {
            int restored = -1;
            int level = currentLevel(); // pop 이후 현재 레벨
            int idx = 0;
            for (Set<String> set : scopeStack) {
                if (set.contains(name)) {
                    restored = level - idx; // 가장 가까운 스코프 레벨 번호
                    break;
                }
                idx++;
            }

            if (restored >= 0) {
                levelOf.put(name, restored);  // 바깥 스코프 변수 복원
            } else {
                levelOf.remove(name);         // 바깥에도 없으면 제거
            }
        }
    }


    // 현재 레벨에 변수 선언
    /**
     * Step 3:
     * 새로운 변수를 현재 스코프(스택 맨 위)에 등록하는 함수
     * 1. scopeStack.peek() 으로 현재 스코프 집합을 가져옴
     * 2. 집합(Set)에 변수 이름을 추가
     * 3. levelOf 맵에도 (변수 이름 → 현재 레벨 번호) 기록
     * → 같은 이름이 바깥에 이미 있어도 덮어쓰기(섀도잉)
     */
    public void declareVariable(String name) {
        // TODO: 현재 스코프에 name을 등록하고,
        //       levelOf 맵에도 현재 레벨 번호를 기록
        Set<String> here = scopeStack.peek();   //현재 스코프(스택 맨 위)를 가져옴
        here.add(name);                         // 현재 스코프에 변수 이름(name) 추가
        levelOf.put(name, currentLevel());      // levelOf 맵에 변수 이름과 현재 레벨 번호 기록

    }

    // 가장 가까운(유효한) 레벨 번호 반환, 없으면 -1
    /**
     * Step 4:
     * 변수 이름이 어느 레벨에 속해 있는지 확인하는 함수
     * 1. levelOf 맵에서 name 키를 찾음
     * 2. 해당 레벨 번호 반환
     * 3. 만약 없다면 기본값 -1 반환
     * → 섀도잉 상황에서는 항상 가장 안쪽 레벨 번호가 기록되어 있음
     */
    public int lookupLevel(String name) {
        // TODO: levelOf 맵을 이용하여 name의 레벨 반환
        return levelOf.getOrDefault(name, -1);   // 존재하지 않으면 -1 반환
    }


    // 현재 레벨(전역=0)
    /**
     * Step 1:
     * 현재 스코프의 깊이(레벨 번호)를 계산하는 함수
     * 전역 스코프만 있을 때 레벨 0, 그 위 블록 열리면 1, 그 위 또 열리면 2... 이런 식으로 작동
     * scopeStack 크기에서 1 빼면 현재 레벨 번호 나옴
     */
    public int currentLevel() {
        // TODO: 스택 크기를 이용하여 현재 레벨 번호 반환
        return scopeStack.size() - 1;
    }

    // === 시연: 한 레벨씩 내려가며 x를 재선언하고, 다시 올라오며 레벨 확인 ===


    public static void main(String[] args) {
        HW01 st = new HW01();

        st.declareVariable("x"); // L0
        System.out.println("enter L0, declare x → x at L" + st.lookupLevel("x"));

        st.enterScope(); // L1
        st.declareVariable("x");
        System.out.println("enter L1, declare x → x at L" + st.lookupLevel("x"));

        st.enterScope(); // L2
        st.declareVariable("x");
        System.out.println("enter L2, declare x → x at L" + st.lookupLevel("x"));

        st.enterScope(); // L3
        st.declareVariable("x");
        System.out.println("enter L3, declare x → x at L" + st.lookupLevel("x"));

        st.exitScope(); // L3 종료
        System.out.println("exit  L3 → x at L" + st.lookupLevel("x"));

        st.exitScope(); // L2 종료
        System.out.println("exit  L2 → x at L" + st.lookupLevel("x"));

        st.exitScope(); // L1 종료
        System.out.println("exit  L1 → x at L" + st.lookupLevel("x"));

        System.out.println("remain L0 → x at L" + st.lookupLevel("x"));

        // 전역 스코프 종료 시도
        st.exitScope(); // 경고 출력 예상
    }
}
