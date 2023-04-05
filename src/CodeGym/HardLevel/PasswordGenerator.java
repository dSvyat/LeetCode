package CodeGym.HardLevel;

import java.io.ByteArrayOutputStream;

/*
Implement the logic of the getPassword method, which should return a ByteArrayOutputStream containing the password bytes.
The requirements for the password are:
1) 8 characters.
2) only numbers and Latin letters of different case.
3) numbers and letters in different cases are obligatory.
All generated passwords must be unique.
Requirements:
- The Solution class must contain the getPassword() method.
- The password must be 8 characters long.
- The password must contain at least one digit.
- The password must contain at least one lower-case Latin letter.
- Password must contain at least one uppercase letter.
- A password must not contain other symbols, except digits and Latin letters of different case.
- Generated passwords must be unique.
 */
public class PasswordGenerator {

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream is = new ByteArrayOutputStream();
        Basket[] baskets = new Basket[3];
        baskets[0] = new Basket('0', '9');
        baskets[1] = new Basket('a', 'z');
        baskets[2] = new Basket('A', 'Z');
        int i = 0;
        for (; i < 5; i++) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
        }
        for (int j = 0; j < baskets.length; j++) {
            generateChar(is, baskets, j);
            i++;
        }

        while (i < 8) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
            i++;
        }
        return is;
    }

    private static void generateChar(ByteArrayOutputStream is, Basket[] baskets, int index) {
        Basket basket = baskets[index];
        is.write((char) basket.getRandom());
    }

    public static class Basket {
        int begin;
        int quantity;

        private Basket(char begin, char end) {
            this.begin = begin;
            this.quantity = end - begin + 1;
        }

        public int getRandom() {
            return (int) (Math.random() * quantity) + begin;
        }
    }
}
