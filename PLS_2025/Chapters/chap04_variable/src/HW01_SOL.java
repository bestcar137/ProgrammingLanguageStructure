import java.util.*;

public class HW01_SOL {
    // 각 스코프 레벨에서 "선언된 변수 이름들"만 보관
    private final Deque<Set<String>> scopeStack = new ArrayDeque<>();
    // 가장 가까운(유효한) 레벨 기록
    private final Map<String, Integer> levelOf = new HashMap<>();

    public HW01_SOL() {
        enterScope(); // 전역 레벨(0) 자동 시작
    }

    // 새 스코프 시작 (스택 push)
    /**
     * Step 2:
     * [조건 2] Scope = Stack 관리, 새 Scope 시작 시 enterScope()
     * [조건 1] 전역 스코프(L0) = 생성자에서 최초 1회 enterScope()
     * <p>
     * 동작:
     * 1) 빈 변수 집합(HashSet) 생성 → 스택 top에 push
     * 2) push된 집합 = 현재 스코프, 이후 선언 변수 저장 대상
     */
    public void enterScope() {
        // TODO: 새 스코프 시작
        scopeStack.push(new HashSet<>());
    }

    // 현재 스코프 종료 (해당 레벨에서 선언한 이름 제거)
    /**
     * Step 5:
     * [조건 2] 스코프 종료 = exitScope()
     * [조건 5] 해당 스코프에서 선언한 변수 전부 제거
     * <p>
     * 동작:
     * 1) 전역 스코프(L0) 보호 → 종료 시도 시 경고 출력
     * 2) 현재 스코프 집합 pop
     * 3) pop된 이름들 순회
     *    - 바깥 스코프에 동일 이름 존재 → levelOf에 바깥 레벨로 복원
     *    - 바깥에도 없음 → levelOf에서 제거
     * 결과: 현재 스코프 선언 변수 제거, 섀도잉되었던 바깥 변수 복귀
     */
    public void exitScope() {
        if (scopeStack.size() <= 1) {                   // 전역 스코프 보호
            System.out.println("[warn] cannot exit global scope (L0)");
            return;
        }

        Set<String> declaredHere = scopeStack.pop();    // 현재 스코프에서 선언된 변수 집합

        for (String name : declaredHere) {
            int restored = -1;
            int level = currentLevel(); // pop 이후 현재 레벨
            int idx = 0;
            for (Set<String> set : scopeStack) {
                if (set.contains(name)) {
                    restored = level - idx; // 가장 가까운 스코프 레벨
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
     * [조건 3] 변수 선언 = declareVariable(String name)
     * [조건 4] 동일 이름 안쪽 재선언 시 섀도잉, 가장 안쪽 레벨 유효
     * <p>
     * 동작:
     * 1) 현재 스코프 집합(스택 top)에 변수 이름 추가
     * 2) levelOf에 (이름 → 현재 레벨) 기록
     * 3) 바깥 동일 이름 존재 시 현재 레벨로 갱신(섀도잉 반영)
     */
    public void declareVariable(String name) {
        // TODO: 현재 스코프에 name 등록 + level 기록
        Set<String> here = scopeStack.peek();   // 현재 스코프(스택 top)
        here.add(name);                         // 이름 추가
        levelOf.put(name, currentLevel());      // 레벨 기록
    }

    // 가장 가까운(유효한) 레벨 번호 반환, 없으면 -1
    /**
     * Step 4:
     * [조건 3] 변수 레벨 확인 = lookupLevel(String name)
     * [조건 4] 섀도잉 시 가장 안쪽 레벨 반환
     * <p>
     * 동작:
     * 1) levelOf에서 name 조회 → 레벨 반환
     * 2) 없으면 -1 반환
     * 3) 섀도잉 반영은 declareVariable에서 이미 갱신
     */
    public int lookupLevel(String name) {
        // TODO: name의 레벨 반환
        return levelOf.getOrDefault(name, -1);  // 없으면 -1
    }

    // 현재 레벨(전역=0)
    /**
     * Step 1:
     * 현재 스코프 깊이(레벨 번호) 계산 유틸
     * <p>
     * 동작:
     * 1) 전역만 존재 시 스택 크기 = 1 → 현재 레벨 = 0
     * 2) 스코프 열릴 때마다 스택 크기 +1 → 현재 레벨 = (스택 크기 - 1)
     */
    public int currentLevel() {
        // TODO: 스택 크기를 이용한 현재 레벨 반환
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
