import java.lang.reflect.Field;

public class HW01_SOL {
    // ===== 전역 변수(필드) 예시 =====
    public int i = 0;
    public int limit = 5;
    public double d = 0.0;
    public String s = "";

    // ===== [TODO 1] print: 그대로 출력 =====
    public void print(String msg) {
        // msg를 출력하는 구문 작성
        System.out.print(msg);
    }

    // ===== [TODO 2] assign: 문자열 타입명으로 강제 변환 후 반환 =====
    // typeName: "int" | "float" | "string" | "bool" (대소문자 무시)
    public Object assign(String typeName, String raw) {
        if (typeName == null || raw == null) {
            System.out.println("assign 실패: null 인자");
            return null;
        }
        String t = typeName.trim().toLowerCase();
        String v = raw.trim();

        // 문자열에 따옴표가 감싸져 있으면 제거
        if ((t.equals("string") || t.equals("str"))
                && v.length() >= 2
                && ((v.startsWith("\"") && v.endsWith("\"")) || (v.startsWith("'") && v.endsWith("'")))) {
            v = v.substring(1, v.length() - 1);
        }

        try {
            switch (t) {
                case "int":
                case "integer":
                    return Integer.parseInt(v);
                case "float":
                case "double":
                    return Double.parseDouble(v);
                case "string":
                case "str":
                    return v;
                case "bool":
                case "boolean": {
                    String vv = v.toLowerCase();
                    if (vv.equals("1")) return true;
                    if (vv.equals("0")) return false;
                    return Boolean.parseBoolean(vv);
                }
                default:
                    System.out.println("지원하지 않는 타입: " + typeName);
                    return null;
            }
        } catch (Exception e) {
            System.out.println("assign 변환 실패(" + typeName + ", " + raw + "): " + e.getMessage());
            return null;
        }
    }

    // ===== [TODO 3] if: 조건 true/false에 따라 블록 실행 =====
    public void ifCond(String cond) {
        // 조건식에 대한 결과를 확인하는 evalCondition(cond) 함수 활용
        if (evalCondition(cond)) {
            block_if_true();
        } else {
            block_if_false();
        }
    }

    // ===== [TODO 4] while: 조건 true면 while 블록 반복, false면 종료 블록 =====
    public void whileCond(String cond) {
        // 1) 조건문에서 증가시켜야하는 변수를 찾아내는 extractCondVariable(cond) 함수 활용
        String varName = extractCondVariable(cond);

        // 조건이 참인 동안 반복: 매회 while 블록 실행(+ 내부에서 varName 증가)
        while (evalCondition(cond)) {
            block_while_true(varName);
        }
        // 거짓이 되는 순간 1회 종료 블록 실행
        block_while_false();
    }

    // ===== [제공] 블록 함수들(수정 금지) =====
    public void block_if_true()  { System.out.println("This condition means True"); }
    public void block_if_false() { System.out.println("This condition means False"); }

    public void block_while_true(String varName) {
        System.out.println("Here is While Block");
        if (varName == null || varName.isEmpty()) return;
        try {
            Field f = this.getClass().getField(varName);
            Object cur = f.get(this);
            if (cur instanceof Integer iv)      f.set(this, iv + 1);
            else if (cur instanceof Double dv)  f.set(this, dv + 1.0);
            // 그 외 타입은 증가하지 않음(요구 단순화)
        } catch (Exception e) {
            System.out.println("증가 실패(" + varName + "): " + e.getMessage());
        }
    }

    public void block_while_false() {
        System.out.println("While finished (condition became false)");
    }

    // ===== [제공] 조건 평가/보조 함수(수정 금지) =====
    // 조건 평가: "왼쪽  비교  오른쪽" (==, >, <, >=, <= 지원)
    private boolean evalCondition(String cond) {
        cond = cond.trim();
        String op = findOp(cond);
        if (op == null) {
            System.out.println("조건 파싱 실패: 연산자 없음");
            return false;
        }
        String left = cond.substring(0, cond.indexOf(op)).trim();
        String right = cond.substring(cond.indexOf(op) + op.length()).trim();

        Double a = asNumber(left);
        Double b = asNumber(right);
        if (a == null || b == null) {
            System.out.println("조건 파싱 실패: 숫자 아님 (" + left + ", " + right + ")");
            return false;
        }
        return switch (op) {
            case "==" -> a.doubleValue() == b.doubleValue();
            case ">"  -> a >  b;
            case "<"  -> a <  b;
            case ">=" -> a >= b;
            case "<=" -> a <= b;
            default   -> false;
        };
    }

    // 우선순위: >=, <=, == 를 먼저 찾고, 그 다음 >, <
    private String findOp(String s) {
        if (s.contains(">=")) return ">=";
        if (s.contains("<=")) return "<=";
        if (s.contains("==")) return "==";
        if (s.contains(">"))  return ">";
        if (s.contains("<"))  return "<";
        return null;
    }

    // 토큰이 숫자면 파싱, 아니면 같은 이름의 전역 필드 값을 숫자로 읽음(int/double만)
    private Double asNumber(String token) {
        try {
            if (token.matches("[+-]?\\d+")) return (double) Integer.parseInt(token);
            if (token.matches("[+-]?\\d*\\.\\d+")) return Double.parseDouble(token);
            Field f = this.getClass().getField(token);
            Object v = f.get(this);
            if (v instanceof Integer iv) return iv.doubleValue();
            if (v instanceof Double dv)  return dv;
        } catch (Exception ignored) {}
        return null;
    }

    // 조건문에서 '증가 대상 변수' 하나 고르기: 왼쪽이 변수면 왼쪽, 아니면 오른쪽이 변수면 오른쪽
    private String extractCondVariable(String cond) {
        cond = cond.trim();
        String op = findOp(cond);
        if (op == null) return null;
        String left = cond.substring(0, cond.indexOf(op)).trim();
        String right = cond.substring(cond.indexOf(op) + op.length()).trim();
        if (isFieldName(left))  return left;
        if (isFieldName(right)) return right;
        return null;
    }

    private boolean isFieldName(String name) {
        try { this.getClass().getField(name); return true; }
        catch (NoSuchFieldException e) { return false; }
    }

    // ===== 메인: 완성 동작 데모(수정 불필요) =====
    public static void main(String[] args) {
        HW01_SOL e = new HW01_SOL();

        // print
        e.print("=== print ===\n");
        e.print("Hello, world!\n");

        // assign: 문자열 타입명으로 강제 변환 후 전역 필드에 직접 대입
        e.i     = (int)    e.assign("int",    "0");
        e.limit = (int)    e.assign("int",    "3");
        e.d     = (double) e.assign("float",  "1.5");
        e.s     = (String) e.assign("string", "seed");
        e.print("i=" + e.i + ", limit=" + e.limit + ", d=" + e.d + ", s=" + e.s + "\n");

        // if: "i < limit" 판단
        e.print("=== if ===\n");
        e.ifCond("i < limit");   // True면 block_if_true, 아니면 block_if_false

        // while: "i < limit" 동안 반복 (내부에서 i가 매회 +1)
        e.print("=== while i < limit ===\n");
        e.whileCond("i < limit");
        e.print("after while: i=" + e.i + "\n");

        // while: "d >= 3.0" (false → 바로 block_while_false)
        e.print("=== while d >= 3.0 ===\n");
        e.whileCond("d >= 3.0");
        e.print("after while: d=" + e.d + "\n");
    }
}
