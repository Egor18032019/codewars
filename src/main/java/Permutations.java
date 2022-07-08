import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Permutations {
    public static void main(String[] args) {
        System.out.println(singlePermutations("aabb").toString());
    }


    public static List<String> singlePermutations(String s) {
        // Your code here!
        List<String> answer = new ArrayList<>();
//        HashSet<String> states = new HashSet<String>();
        int length = s.length();
        if (length <= 1) {
            answer.add(s);
            return answer;
        }
        if (length == 2) {
            answer.add(s);
            answer.add(String.valueOf(new StringBuilder(s).reverse()));
            return answer;
        }
        List<Character> list = s.chars().mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        permutate(answer, list, 0);

//        if (!answer.contains(value)) answer.add(value);



        return answer;
}

    public static void permutate(List<String> answer, List<Character> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list, i, k);
            permutate(answer, list, k+1);
            Collections.swap(list, k ,i);
        }

        if(k == list.size()-1){
            String value = list.stream().map(String::valueOf).collect(Collectors.joining());
            if(!answer.contains(value)){
            answer.add(value);
            }
        }
    }
}