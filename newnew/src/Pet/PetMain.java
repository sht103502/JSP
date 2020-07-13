package Pet;

import java.sql.Connection;
import java.util.Scanner;

public class PetMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		Member member = new Member();
		PetSQL sql = new PetSQL();

		Connection con = DBC.DBConnect();
		sql.connect();
		int menu = 0;
		int amenu = 0;
		int bmenu = 0;
		int cmenu = 0;
		int dmenu = 0;
		int emenu = 0;

		while (run) {
			System.out.println("================================");
			System.out.println("1.회원가입          2.로그인           3.로그아웃 ");
			System.out.println("================================");
			System.out.print("메뉴선택 >> ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("아이디 >> ");
				String id = sc.next();

				System.out.println("비밀번호 >> ");
				String pw = sc.next();

				System.out.println("이름 >> ");
				String name = sc.next();

				System.out.println("전화번호 >> ");
				int phone = sc.nextInt();

				int point = 0;
				
				member = new Member(id, pw, name, phone, point);

				sql.memberJoin(member);
				break;
			case 2:
				System.out.println("아이디>>");
				id = sc.next();

				System.out.println("비밀번호>>");
				pw = sc.next();

				boolean idCheck = sql.idpwCheck(id, pw);

				if (idCheck == true) {
					System.out.println("===========================");
					System.out.println("1.마이페이지                2.예약하기");
					System.out.println("===========================");
					System.out.print("메뉴선택 >> ");
					amenu = sc.nextInt();

					switch (amenu) {
					case 1:// 마이페이지
						System.out.println("===========================");
						System.out.println("1.포인트              2.회원탈퇴");
						System.out.println("===========================");
						System.out.print("메뉴선택 >> ");
						bmenu = sc.nextInt();

						switch (bmenu) {
						case 1: // 포인트
							System.out.println("===========================");
							System.out.println("1.포인트충전              2.잔액확인");
							System.out.println("===========================");
							System.out.print("메뉴선택 >> ");
							cmenu = sc.nextInt();
							switch (cmenu) {
							case 1: // 포인트 충전
								System.out.println("연락처를 입력하세요");
								phone = sc.nextInt();
								System.out.println("충전 할 금액을 입력하세요 >> ");
								point = sc.nextInt();
//								phone = 0;
								sql.pointPlus(point,phone);
								break;

							case 2: // 잔액확인
//								System.out.println("아이디조회 ");
//								id=sc.next();
//								sql.idCheck(id);
//								point = sql.checkBalance(Integer.parseInt(id));
//								System.out.println("잔액 : " + point);
							System.out.println("연락처를 입력하세요.");
							phone = sc.nextInt();
							sql.checkBalance(phone);
							System.out.println("잔액은 : " + sql.checkBalance(phone));
								break;
							} break;
						case 2: // 회원탈퇴
							System.out.println("회원탈퇴할 아이디를 입력하세요");
							id = sc.next();
							sql.idDelete(id);

							System.out.println("탈퇴완료되었습니다.");
							System.out.println("이용해주셔서 감사합니다.");

							break;
						}
						break;
					case 2: // 예약
						System.out.println("===========================");
						System.out.println("1.예약하기              2.예약확인");
						System.out.println("===========================");
						System.out.print("메뉴선택 >> ");
						dmenu = sc.nextInt();
						switch (dmenu) {
						case 1: // 예약하기
							System.out.println("===========================");
							System.out.println("1.호텔              2.건강검진");
							System.out.println("===========================");
							System.out.print("메뉴선택 >> ");
							emenu = sc.nextInt();
							switch (emenu) {
							case 1: // 호텔
								System.out.println("개세호텔에 오신것을 환영합니다.");
								System.out.println("회원등록시 기재한 애완동물의 이름를 입력해주세요 >>");
								name = sc.next();
								sql.insertRev(name);
								break;
							case 2: // 건강검진
								System.out.println("개세병원에 오신것을 환영합니다.");
								System.out.println("회원등록시 기재한 전화번호를 입력해주세요 >>");
								phone = sc.nextInt();
								sql.insertRev1(phone);
								break;
							}
							break;
						case 2: // 예약확인
						}
						break;
					}

					break;

				} else {
					System.out.println("아이디와 비밀번호를 다시 확인하세요.");
				}
				break;
			case 3:
				System.out.println("프로그램 종료가되었습니다.");
				run = false;
			}
		}
	}
}
