package 자료구조.슬라이딩윈도우.p009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 */
public class Main {
    //부분문자열에 포함되어야 할 A,G,C,T 최소 개수
    static Map<Character, Integer> minNumberByDNACharacter = new HashMap<>();

    //부분 문자열에서 만족하는 조건의 수
    static int numberOfSatisfyCondition;

    //만들 수 있는 비밀번호의 종류의 수
    static int numberOfPossiblePassword;

    //DNA를 구성하는 문자 배열
    static final char[] DNA_CHRACTERS = {'A', 'C', 'G', 'T'};

    //조건 개수 = DNA를 구성하는 문자 배열 크기
    static final int NUMBER_OF_CONDITION = DNA_CHRACTERS.length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //DNA 문자열 길이
        int S = Integer.parseInt(st.nextToken());

        //비밀번호로 사용할 부분문자열의 길이
        int P = Integer.parseInt(st.nextToken());

        //DNA 문자열
        String DNA = br.readLine();

        //부분문자열에 포함되어야 할 A,G,C,T 최소 개수 입력 받기
        st = new StringTokenizer(br.readLine());
        for(char c : DNA_CHRACTERS){
            minNumberByDNACharacter.put(c, Integer.parseInt(st.nextToken()));

            //포함되어야 할 최소 개수가 0인 경우 조건 만족 수 1 증가
            if(minNumberByDNACharacter.get(c) == 0){
                numberOfSatisfyCondition++;
            }
        }

        //처음 P개의 문자로 문자열을 만들었을 때 조건 만족 개수 구하기
        for (int i = 0; i < P; i++) {
            add(DNA.charAt(i));
        }

        //모든 조건 만족하는 문자열이면 개수 세기
        countNumberOfPossiblePassword();

        //맨 앞 문자는 제거하고, 맨 뒤에 문자를 추가하면서 조건 만족 개수 구하기
        //모든 조건 만족하는 문자열이면 개수 세기
        for (int i = P; i < S; i++) {
            add(DNA.charAt(i));
            remove(DNA.charAt(i - P));

            countNumberOfPossiblePassword();
        }

        //결과 출력
        System.out.println(numberOfPossiblePassword);

    }

    //문자 추가
    static void add(Character c) {
        minNumberByDNACharacter.put(c, minNumberByDNACharacter.get(c) - 1);

        if(minNumberByDNACharacter.get(c) == 0){
            numberOfSatisfyCondition++;
        }
    }

    //문자 제거
    static void remove(Character c) {
        if(minNumberByDNACharacter.get(c) == 0){
            numberOfSatisfyCondition--;
        }

        minNumberByDNACharacter.put(c, minNumberByDNACharacter.get(c) + 1);
    }

    //만들 수 있는 비밀번호 수 구하기
    static void countNumberOfPossiblePassword(){
        if (numberOfSatisfyCondition == NUMBER_OF_CONDITION) {
            numberOfPossiblePassword++;
        }
    }
}
