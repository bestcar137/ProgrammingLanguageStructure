public class prac09 {
    public static void main(String[] args) {
        String f_name = "GIL DONG";
        String l_name = "HONG ";
        String name;

        name = l_name + f_name; // 문자열 결합
        System.out.println(name);
        System.out.println(name.length()); // 문자열 길이

        name += " Fighting!";
        // name = name.concat(" Fighting!");

        System.out.println(name);
        // 특정 인덱스 문자 접근

        System.out.println(name.charAt(10));
        // 특정 문자(열)의 첫 번째 위치 검색

        System.out.println(name.indexOf("L"));
        // 인덱스 0부터 4글자 삭제
        name = name.substring(4);
        System.out.println(name);
    }
}