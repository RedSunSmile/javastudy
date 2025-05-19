package editlist.overriding2_16chapter.refactoring;

public class PhoneBookManager {

  final int MAX_CNT = 100;
  private static PhoneInfo[] infoStorage;
  private static int curCnt;

  public PhoneBookManager() {
    infoStorage = new PhoneInfo[MAX_CNT];
    curCnt = 0;
  }

  private void readFriendInfo(PhoneInfo info) {
    System.out.print("이름: ");
    info.name = MenuViewer.keyboard.nextLine();
    System.out.print("전화번호: ");
    info.phoneNumber = MenuViewer.keyboard.nextLine();
  }

  private void readUnivFriendInfo(PhoneUnivInfo uni) {
    System.out.print("이름: ");
    uni.name = MenuViewer.keyboard.nextLine();

    System.out.println("전화번호: ");
    uni.phoneNumber = MenuViewer.keyboard.nextLine();

    System.out.print("전공: ");
    uni.major = MenuViewer.keyboard.nextLine();

    System.out.print("학년: ");
    uni.year = MenuViewer.keyboard.nextInt();
    //버퍼비우기
    MenuViewer.keyboard.nextLine();
  }

  private void readCompanyFriendInfo(PhoneCompanyInfo company) {
    System.out.print("이름: ");
    company.name = MenuViewer.keyboard.nextLine();

    System.out.println("전화번호: ");
    company.phoneNumber = MenuViewer.keyboard.nextLine();

    System.out.println("회사: ");
    company.company = MenuViewer.keyboard.nextLine();
    MenuViewer.keyboard.nextLine();
  }

  public void inputData() {
    System.out.println("데이터 입력을 시작합니다.");
    System.out.println("1. 일반, 2. 대학, 3. 회사");
    System.out.print("선택>> ");
    int choice = MenuViewer.keyboard.nextInt();
    MenuViewer.keyboard.nextLine();
    PhoneInfo info = null;

    if (choice == 1) {
      info = new PhoneInfo("", "");
      readFriendInfo(info);
      infoStorage[curCnt++] = info;
      System.out.println("데이터 입력이 완료되었습니다. \n");

    } else if (choice == 2) {
      PhoneUnivInfo uni = new PhoneUnivInfo("", "", "", 0);
      readUnivFriendInfo(uni);
      infoStorage[curCnt++] = uni;
      System.out.println("데이터 입력이 완료되었습니다. \n");
    } else if (choice == 3) {
      PhoneCompanyInfo com = new PhoneCompanyInfo("", "", "");
      readCompanyFriendInfo(com);
      infoStorage[curCnt++] = com;
      System.out.println("데이터 입력이 완료되었습니다. \n");
    }
    System.out.println("잘못된 선택입니다.");
  }


  public void searchData() {
    System.out.println("데이터 검색을 시작합니다.");
    System.out.print("이름 : ");
    String search = MenuViewer.keyboard.nextLine();
    int dataIdx = search(search);
    if (dataIdx >= 0) {
      PhoneBookManager.infoStorage[dataIdx].showPhoneInfo();
      System.out.println("데이터 검색이 완료되었습니다. \n");
    } else {
      System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
    }
  }

  public void deleteData() {
    System.out.println("데이터 삭제를 시작합니다.");
    System.out.print("이름 : ");
    String name = MenuViewer.keyboard.nextLine();
    int dataIdx = search(name);

    if (dataIdx < 0) {
      System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
    } else {

      for (int idx = dataIdx; idx < (PhoneBookManager.curCnt - 1); idx++) {
        //인덱스 왼쪽땡겨돌며 데이터 밀기
        PhoneBookManager.infoStorage[idx] = PhoneBookManager.infoStorage[idx + 1];
      }
      PhoneBookManager.curCnt--;//확인사살로 결정된 데이터 없애기
      System.out.println("데이터 삭제가 완료되었습니다. \n");
    }
  }

  private int search(String name) {
    for (int idx = 0; idx < PhoneBookManager.curCnt; idx++) {
      PhoneInfo curInfo = PhoneBookManager.infoStorage[idx];
      if (name.compareTo(curInfo.name) == 0) {
        return idx;
      }
    }
    return -1;
  }
}

