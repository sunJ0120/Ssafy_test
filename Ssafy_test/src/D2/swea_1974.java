package D2;

import java.util.Scanner;

/*
 * 스도쿠 검증
 * 1. 3*3의 범위를 돈다
 * 2. 행을 체크한다.
 * 3. 열을 체크한다.
 */

/*
 * square 부분 해결하는게 상당히 어려웠는데..솔직히 정말 이렇게 하는게 맞나 싶긴 함
 */

public class swea_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder stb = new StringBuilder();
		
		
		for(int i = 1; i<=num; i++) {
			boolean line = true;
			boolean row = true;
			boolean square = true;
			
			int countNum = 0;
			
			int[][] sdoku = new int[9][9];
			
			for(int j = 0; j<9; j++) {
				for(int k = 0; k<9; k++) {
					sdoku[j][k] = sc.nextInt();
				}
			}
			
			//1. 행검증
			while(countNum < 9 && line) {
				boolean[] count = new boolean[10]; //체크용
				for(int j = 0; j<9; j++) {
					if(!count[sdoku[countNum][j]]) { //채워지지 않은 상태
						count[sdoku[countNum][j]] = true;
					}else { //반복
						line = false;
						break;
					}
				}
				countNum++;
			}
			
			countNum = 0;
			
			//체크
			if(!line) { //false
				stb.append("#"+ i + " "  + 0);
				stb.append("\n");
				continue;
			}
			
			//2. 열검증
			while(countNum < 9 && row) {
				boolean[] count = new boolean[10]; //체크용
				for(int j = 0; j<9; j++) {
					if(!count[sdoku[j][countNum]]) { //채워지지 않은 상태
						count[sdoku[j][countNum]] = true;
					}else { //반복
						row = false;
						break;
					}
				}
				countNum++;
			}
			
			//체크
			if(!row) { //false
				stb.append("#"+ i + " "  + 0);
				stb.append("\n");
				continue;
			}
			
			//3. 3*3 검증
			//행렬기준 또 달라야해
			int startrowNum = 0;
			int endrowNum = 3;
			int startlineNum = 0;
			int endlineNum = 3;
			int checkloop = 1;
			
			while(checkloop <= 9 && square) {
				boolean[] count = new boolean[10]; //체크용
				
				for(int j = startrowNum; j<endrowNum; j++) {
					for(int z = startlineNum; z<endlineNum; z++) {
						if(!count[sdoku[j][z]]) { //채워지지 않은 상태
							count[sdoku[j][z]] = true;
						}else { //반복
							square = false;
							break;
						}
					}
				}
				
				startrowNum = (endlineNum + 1 > 9) ? (startrowNum + 3) : startrowNum;
				endrowNum = (endlineNum + 1 > 9) ? (endrowNum + 3) : endrowNum;
				
				startlineNum = (endlineNum + 1 > 9) ? 0 : (startlineNum + 3);
				endlineNum = (endlineNum + 1 > 9) ? 3 : (endlineNum + 3);
				
				countNum = (countNum + 1 > 9) ? 3 : 0;
				checkloop++;
			}
			
			//체크
			if(!square) { //false
				stb.append("#"+ i + " "  + 0);
				stb.append("\n");
				continue;
			}
			
			if(square && line && row) {
				stb.append("#"+ i + " "  + 1);
				stb.append("\n");
				continue;
			}
		}
		System.out.println(stb);
	}
}
