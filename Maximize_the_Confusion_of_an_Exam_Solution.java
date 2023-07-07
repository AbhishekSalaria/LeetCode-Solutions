public class Maximize_the_Confusion_of_an_Exam_Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int answer = 0, left = 0, count = 0, size = answerKey.length();

        for(int i = 0; i < size; i++) {
            if(answerKey.charAt(i) == 'F') {
                count++;
                while(count > k) {
                    if(answerKey.charAt(left) == 'F') {
                        count--;
                    }
                    left++;
                }
            }
            answer = Math.max(answer, i - left + 1);
        }

        left = 0;
        count = 0;

        for(int i = 0; i < size; i++) {
            if(answerKey.charAt(i) == 'T') {
                count++;
                while(count > k) {
                    if(answerKey.charAt(left) == 'T') {
                        count--;
                    }
                    left++;
                }
            }
            answer = Math.max(answer, i - left + 1);
        }
        return answer;
    }
}