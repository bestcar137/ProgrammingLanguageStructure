import java.util.*;

public class Lab1_ScopeLevels {
    // 각 스코프 레벨에서 "선언된 변수 이름들"만 보관
    private final Deque<Set<String>> scopeStack = new ArrayDeque<>();
    // 가장 가까운(유효한) 레벨 기록
    private final Map<String, Integer> levelOf = new HashMap<>();

    public Lab1_ScopeLevels() {
        enterScope(); // 전역 레벨(0) 자동 시작
    }

    // 새 스코프 시작 (스택 push)
    public void enterScope() {
        // TODO: 새 스코프를 시작하도록 구현
    }

    // 현재 스코프 종료 (해당 레벨에서 선언한 이름 제거)
    public void exitScope() {
        // TODO: 현재 레벨에서 선언한 이름들을 제거하도록 구현
    }

    // 현재 레벨에 변수 선언
    public void declareVariable(String name) {
        // TODO: 현재 스코프에 name을 등록하고,
        //       levelOf 맵에도 현재 레벨 번호를 기록
    }

    // 가장 가까운(유효한) 레벨 번호 반환, 없으면 -1
    public int lookupLevel(String name) {
        // TODO: levelOf 맵을 이용하여 name의 레벨 반환
        return -1;
    }

    // 현재 레벨(전역=0)
    public int currentLevel() {
        // TODO: 스택 크기를 이용하여 현재 레벨 번호 반환
        return -1;
    }

    // === 시연: 한 레벨씩 내려가며 x를 재선언하고, 다시 올라오며 레벨 확인 ===
    public static void main(String[] args) {
        Lab1_ScopeLevels st = new Lab1_ScopeLevels();

        st.declareVariable("x"); // L0
        System.out.println("enter L0, declare x → x@L" + st.lookupLevel("x"));

        st.enterScope(); // L1
        st.declareVariable("x");
        System.out.println("enter L1, declare x → x@L" + st.lookupLevel("x"));

        st.enterScope(); // L2
        st.declareVariable("x");
        System.out.println("enter L2, declare x → x@L" + st.lookupLevel("x"));

        st.enterScope(); // L3
        st.declareVariable("x");
        System.out.println("enter L3, declare x → x@L" + st.lookupLevel("x"));

        st.exitScope(); // L3 종료
        System.out.println("exit  L3 → x@L" + st.lookupLevel("x"));

        st.exitScope(); // L2 종료
        System.out.println("exit  L2 → x@L" + st.lookupLevel("x"));

        st.exitScope(); // L1 종료
        System.out.println("exit  L1 → x@L" + st.lookupLevel("x"));

        System.out.println("remain L0 → x@L" + st.lookupLevel("x"));

        // 전역 스코프 종료 시도
        st.exitScope(); // 경고 출력 예상
    }}