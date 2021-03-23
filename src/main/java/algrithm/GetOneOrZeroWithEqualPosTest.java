package algrithm;

public class GetOneOrZeroWithEqualPosTest {

    static int get() {
        return 0;
    }

    static int getOneOrZero() {
        while (true) {
            int first = get();
            int second = get();

            if(first == second) continue;
            return first == 0 ? 0 : 1;
        }
    }
}
