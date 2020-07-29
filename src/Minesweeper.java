/**
 * @author: Hwayoung Jun
 * @Date  : 2020-07-29
 * @desc  : 지뢰찾기
 */
public class Minesweeper {

    public static void main(String[] args) {

        char[][] board = new char[10][10];

        int i = 0;
        while(i < 10) {
            /**
             * 1. 지뢰 좌표 구하기
             */
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);

            //중복 지뢰인 경우 지뢰 좌표를 다시 구한다.
            if(board[x][y] == 'M') {
                continue;
            } else {
                board[x][y] = 'M';
            }

            /**
             * 2. 지뢰 인접 영역 탐색 및 지뢰 개수 + 1
             */
            for(int _x = x - 1; _x <= x + 1; _x++) {
                for (int _y = y - 1; _y <= y + 1; _y++) {

                    //10 * 10 의 지뢰찾기 판을 벗어나지 않도록 한다.
                    if(_x > -1 && _x < 10 && _y > -1 && _y < 10) {
                        if (board[_x][_y] == 'M') {
                            continue;
                        } else {
                            board[_x][_y] = board[_x][_y] == '\u0000' ? '1' : (char) (Integer.valueOf(board[_x][_y]) + 1);
                        }
                    }
                }
            }

            i++;
        }

        /**
         * 3. 출력
         */
        for(char[] row : board) {
            for(char col :row) {
                System.out.print(String.format("%s ", col == '\u0000' ? "0" : col));
            }
            System.out.print("\r\n");
        }
    }
}
